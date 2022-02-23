package by.prohor.booklib.external.openlibrary.service;

import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;
import by.prohor.booklib.external.openlibrary.util.BookFromOpenLibrary;
import by.prohor.booklib.external.openlibrary.util.IsbnFromOpenLibrary;
import by.prohor.booklib.external.openlibrary.util.OpenLibraryURL;
import by.prohor.booklib.mappers.book.BookMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpenLibraryService extends OpenLibraryURL{

    private final RestTemplate restTemplate;
    @Autowired
    public OpenLibraryService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<BookOpenLibrary> findBooksByAuthor(String author) {

        List<BookOpenLibrary> bookList = new ArrayList<>();

        ResponseEntity<String> response = restTemplate.exchange(
                (URL_BASE+URL_AUTHORNAME), HttpMethod.GET,null, String.class, author);

        List<String> isbnList = IsbnFromOpenLibrary.findIsbn(response.getBody()).stream()
                .filter(isbn->isbn.length()==lengthIsbn).collect(Collectors.toList());

        for(String isbn : isbnList){
            response = restTemplate.exchange((URL_BASE+URL_ISBN), HttpMethod.GET, null, String.class, isbn);

            BookEntity book = BookFromOpenLibrary.findBook(response.getBody(), isbn);
            book.setIsbn(isbn);
            book.setAuthor(author);
            bookList.add(BookMapperImpl.bookEntityToBookOpenLibrary(book));
        }
        return bookList;
    }
}
