package by.prohor.booklib.controller;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.exception.NoSuchBookException;
import by.prohor.booklib.dao.impl.BookDAO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("web")
public class BookController {

    private final BookDAO bookDAO;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping("api")
    public List<Book> list(){
        return bookDAO.list();
    }

    @PostMapping("api")
    public int create(@Valid @RequestBody Book book){
        return bookDAO.create(book);
    }

    @GetMapping("api/{id}")
    public Book get(@PathVariable int id){
        Book book = bookDAO.get(id);

        if(book==null){
            throw new NoSuchBookException("There is no book with ID = " +
                    id + " in HashMap");
        }
        return book;
    }

    @DeleteMapping("api/{id}")
    public Book delete(@PathVariable int id){
        return bookDAO.delete(id);
    }

    @PutMapping("api/{id}")
    public Book update(@PathVariable int id,@Valid @RequestBody Book book){
        return bookDAO.update(id, book);
    }



}
