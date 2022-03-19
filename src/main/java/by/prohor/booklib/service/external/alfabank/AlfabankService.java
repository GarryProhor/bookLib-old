package by.prohor.booklib.service.external.alfabank;

import by.prohor.booklib.external.alfabank.model.BookCurrency;

import java.util.List;

public interface AlfabankService {
    List<BookCurrency> getBook(String title);
}
