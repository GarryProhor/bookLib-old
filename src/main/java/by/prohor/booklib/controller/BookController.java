package by.prohor.booklib.controller;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("v1/api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getBookById(@PathVariable("id") Long id){
            return new ResponseEntity<>(bookService.findByIdBook(id), HttpStatus.OK);
    }

    @GetMapping("name/{author}")
    public ResponseEntity<Object> getBookByAuthorName(@PathVariable("author") String author){
        return new ResponseEntity<>(bookService.findByAuthorName(author), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book b){
        return new ResponseEntity<>(bookService.saveBook(new Book(b.getIsbn(), b.getName(),
                b.getAuthor(), b.getPage(), b.getWeight(), b.getPrice())), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @Valid @RequestBody Book b){
        Book book = bookService.findByIdBook(id);

        if(book != null){
            book.setId(Math.toIntExact(id));
            book.setIsbn(b.getIsbn());
            book.setName(b.getName());
            book.setAuthor(b.getAuthor());
            book.setPage(b.getPage());
            book.setWeight(b.getWeight());
            book.setPrice(b.getPrice());

            return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllBook(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
