package by.prohor.booklib.controller;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.repository.implementation.BookRepository;
import by.prohor.booklib.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("web")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("api")
    public ResponseEntity<Object> getAllBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("api/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable("id") Long id){
            return new ResponseEntity<>(bookService.findByIdBook(id), HttpStatus.OK);
    }

    @PostMapping("api")
    public ResponseEntity<String> createBook(@Valid @RequestBody Book b){
        bookService.saveBook(new Book(b.getIsbn(), b.getName(), b.getAuthor(), b.getPage(), b.getWeight(), b.getPrice()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("api/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Long id, @Valid @RequestBody Book b){
        Book book = bookService.findByIdBook(id);

        if(book != null){
            book.setId(Math.toIntExact(id));
            book.setIsbn(b.getIsbn());
            book.setName(b.getName());
            book.setAuthor(b.getAuthor());
            book.setPage(b.getPage());
            book.setWeight(b.getWeight());
            book.setPrice(b.getPrice());

            bookService.updateBook(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("api/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("api")
    public ResponseEntity<String> deleteAllBook(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
