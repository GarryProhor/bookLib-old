package by.prohor.booklib.controller;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.services.BookServiceImpl;
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

    private final BookServiceImpl bookServiceImpl;

    @Autowired
    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @GetMapping
    public ResponseEntity<Object> getAllBooks(){
        return new ResponseEntity<>(bookServiceImpl.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getBookById(@PathVariable("id") Long id){
            return new ResponseEntity<>(bookServiceImpl.findByIdBook(id), HttpStatus.OK);
    }

    @GetMapping("name/{author}")
    public ResponseEntity<Object> getBookByAuthorName(@PathVariable("author") String author){
        return new ResponseEntity<>(bookServiceImpl.findByAuthorName(author), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book b){
        return new ResponseEntity<>(bookServiceImpl.saveBook(new Book(b.getIsbn(), b.getName(),
                b.getAuthor(), b.getPage(), b.getWeight(), b.getPrice())), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @Valid @RequestBody Book b){
        Book book = bookServiceImpl.findByIdBook(id);

        if(book != null){
            book.setId(Math.toIntExact(id));
            book.setIsbn(b.getIsbn());
            book.setName(b.getName());
            book.setAuthor(b.getAuthor());
            book.setPage(b.getPage());
            book.setWeight(b.getWeight());
            book.setPrice(b.getPrice());

            return new ResponseEntity<>(bookServiceImpl.updateBook(book), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        bookServiceImpl.deleteBook(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllBook(){
        bookServiceImpl.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
