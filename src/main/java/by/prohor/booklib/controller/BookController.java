package by.prohor.booklib.controller;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.repository.BookRepository;
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

    final
    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("api")
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String name){
        List<Book> books = new ArrayList<>();
        if(name==null){
            bookRepository.findAll().forEach(books::add);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("api/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        Book book = bookRepository.findById(id);
        if(book!=null){
            return new ResponseEntity<>(book, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("api")
    public ResponseEntity<String> createBook(@Valid @RequestBody Book b){
        bookRepository.create(new Book(b.getIsbn(), b.getName(), b.getAuthor(), b.getPage(), b.getWeight(), b.getPrice()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("api/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Long id, @Valid @RequestBody Book b){
        Book book = bookRepository.findById(id);

        if(book != null){
            book.setId(Math.toIntExact(id));
            book.setIsbn(b.getIsbn());
            book.setName(b.getName());
            book.setAuthor(b.getAuthor());
            book.setPage(b.getPage());
            book.setWeight(b.getWeight());
            book.setPrice(b.getPrice());

            bookRepository.update(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("api/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("api")
    public ResponseEntity<String> deleteAllBook(){
        bookRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
