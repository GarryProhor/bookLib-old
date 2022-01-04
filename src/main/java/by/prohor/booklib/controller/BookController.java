package by.prohor.booklib.controller;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.service.impl.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("web")
public class BookController {
    BookService bookService = new BookService();

    @RequestMapping(value = "api", method = RequestMethod.GET)
    public List<Book> list(){
        return bookService.list();
    }

    @RequestMapping(value = "api", method = RequestMethod.POST)
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }
    
    @RequestMapping(value = "api/{id}", method = RequestMethod.GET)
    public Book get(@PathVariable int id){
        return bookService.get(id);
    }

    @RequestMapping(value = "api/{id}", method = RequestMethod.DELETE)
    public Book delete(@PathVariable int id){
        return bookService.delete(id);
    }

    @RequestMapping(value = "api/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable int id, @RequestBody Book book){
        return bookService.update(id, book);
    }

}
