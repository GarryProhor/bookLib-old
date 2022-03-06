package by.prohor.booklib.controller;

import by.prohor.booklib.external.alfabank.model.BookCurrency;
import by.prohor.booklib.external.alfabank.service.AlfabankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {

    @Autowired
    AlfabankServiceImpl alfabankService;

    public List<BookCurrency> getBooks(String title){
        return alfabankService.getBook(title);
    }
}
