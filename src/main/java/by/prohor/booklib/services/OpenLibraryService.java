package by.prohor.booklib.services;

import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.entity.BookOpenLibrary;
import by.prohor.booklib.mappers.book.BookMapperImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpenLibraryService {

    private String URL_AUTHORNAME = "http://openlibrary.org/search.json?author={authorName}";
    private String URL_ISBN = "http://openlibrary.org/api/books?bibkeys=ISBN:{isbn}&jscmd=data&format=json";
    private int lengthIsbn = 13;

    private final BookService bookService;

    public OpenLibraryService(BookService bookService) {
        this.bookService = bookService;
    }

    public List<String> findIsbn (String json) {
        List<String> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode docs = jsonNode.path("docs");
            for(JsonNode docsNode : docs){
                JsonNode isbns = docsNode.path("isbn");
                for(JsonNode isbnNode : isbns){
                    list.add(isbnNode.textValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public BookEntity findBook(String json , String isbn){
        BookEntity bookEntity = new BookEntity();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode isbnNode = jsonNode.path("ISBN:" + isbn);
            String title = isbnNode.path("title").asText();

            bookEntity.setName(title);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bookEntity;
    }

    public List<BookOpenLibrary> findBooksByAuthor(String author) {
        RestTemplate restTemplate = new RestTemplate();
        List<BookOpenLibrary> bookList = bookService.findByAuthorName(author);
        ResponseEntity<String> response = restTemplate.exchange(
                URL_AUTHORNAME, HttpMethod.GET,null, String.class, author);

        List<String> isbnList = findIsbn(response.getBody()).stream()
                .filter(isbn->isbn.length()==lengthIsbn).collect(Collectors.toList());

        for(String isbn : isbnList){
            response = restTemplate.exchange(URL_ISBN, HttpMethod.GET, null, String.class, isbn);

            BookEntity book = findBook(response.getBody(), isbn);
            book.setIsbn(isbn);
            book.setAuthor(author);
            bookList.add(BookMapperImpl.bookEntityToBookOpenLibrary(book));
        }
        return bookList;
    }
}
