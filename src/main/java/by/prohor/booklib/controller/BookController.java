package by.prohor.booklib.controller;

import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;
import by.prohor.booklib.service.dto.BookDTO;
import by.prohor.booklib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@Validated
@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable("id") Long bookId) {
        return ResponseEntity.ok(bookService.getBook(bookId));
    }

//    @GetMapping
//    public ResponseEntity<BookDTO> getBooks(@RequestParam(required=false) String author,
//                                           @RequestParam Integer offset,
//                                           @RequestParam Integer limit){
//        if (Objects.isNull(author)) {
//            return new ResponseEntity<BookDTO>((BookDTO) bookService.findAllBooks(), HttpStatus.OK);
//        }
//        return new ResponseEntity<BookDTO>(bookService.findByAuthorName(author), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("name/{author}")
    public ResponseEntity<List<BookOpenLibrary>> getBookByAuthorName(
            @RequestParam(required=false)
            @PathVariable("author") String author){

        return ResponseEntity.ok(bookService.findByAuthorName(author));
    }
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.saveBook(bookDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDTO> updateBook(
            @PathVariable("id") Long bookId,
            @Valid @RequestBody BookDTO bookDTO) {

        return ResponseEntity.ok(bookService.updateBook(bookId, bookDTO));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long bookId) {
        String response = bookService.deleteBook(bookId);
        return ResponseEntity.ok(response);
    }
}
