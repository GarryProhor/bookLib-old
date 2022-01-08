package by.prohor.booklib.controller;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.exception.BookIncorrectData;
import by.prohor.booklib.exception.NoSuchBookException;
import by.prohor.booklib.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("web")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("api")
    public List<Book> list(){
        return bookService.list();
    }

    @PostMapping("api")
    public Book create(@Valid @RequestBody Book book){
        return bookService.create(book);
    }

    @GetMapping("api/{id}")
    public Book get(@PathVariable int id){
        Book book = bookService.get(id);

        if(book==null){
            throw new NoSuchBookException("There is no book with ID = " +
                    id + " in HashMap");
        }
        return book;
    }

    @DeleteMapping("api/{id}")
    public Book delete(@PathVariable int id){
        return bookService.delete(id);
    }

    @PutMapping("api/{id}")
    public Book update(@PathVariable int id,@Valid @RequestBody Book book){
        return bookService.update(id, book);
    }



}
