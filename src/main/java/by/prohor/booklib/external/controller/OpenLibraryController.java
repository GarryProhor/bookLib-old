package by.prohor.booklib.external.controller;

import by.prohor.booklib.external.service.OpenLibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("api")
public class OpenLibraryController {

    private final OpenLibraryService openLibraryService;

    public OpenLibraryController(OpenLibraryService openLibraryService) {
        this.openLibraryService = openLibraryService;
    }

    @GetMapping("name/{author}")
    public ResponseEntity<Object> getBookByAuthorName(@PathVariable("author") String author){
        return new ResponseEntity<>(openLibraryService.findBooksByAuthor(author), HttpStatus.OK);

    }
}
