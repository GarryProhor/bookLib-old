package by.prohor.booklib.external.service;

import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.entity.BookOpenLibrary;
import by.prohor.booklib.external.util.BookFromOpenLibrary;
import by.prohor.booklib.external.util.IsbnFromOpenLibrary;
import by.prohor.booklib.mappers.book.BookMapperImpl;
import by.prohor.booklib.services.BookService;
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

    private static String URL_AUTHORNAME = "http://openlibrary.org/search.json?author={authorName}";
    private static String URL_ISBN = "http://openlibrary.org/api/books?bibkeys=ISBN:{isbn}&jscmd=data&format=json";
    private static int lengthIsbn = 13;


    private final BookService bookService;

    public OpenLibraryService(BookService bookService) {
        this.bookService = bookService;
    }

    public List<BookOpenLibrary> findBooksByAuthor(String author) {
        RestTemplate restTemplate = new RestTemplate();
        List<BookOpenLibrary> bookList = bookService.findByAuthorName(author);
        ResponseEntity<String> response = restTemplate.exchange(
                URL_AUTHORNAME, HttpMethod.GET,null, String.class, author);

        List<String> isbnList = IsbnFromOpenLibrary.findIsbn(response.getBody()).stream()
                .filter(isbn->isbn.length()==lengthIsbn).collect(Collectors.toList());

        for(String isbn : isbnList){
            response = restTemplate.exchange(URL_ISBN, HttpMethod.GET, null, String.class, isbn);

            BookEntity book = BookFromOpenLibrary.findBook(response.getBody(), isbn);
            book.setIsbn(isbn);
            book.setAuthor(author);
            bookList.add(BookMapperImpl.bookEntityToBookOpenLibrary(book));
        }
        return bookList;
    }
}
