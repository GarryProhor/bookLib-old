package by.prohor.booklib.services.external.alfabank;

import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.external.alfabank.model.BookCurrency;
import by.prohor.booklib.external.alfabank.model.RateListResponse;

import java.util.List;

/**
 *  interface Alfabank service.
 */
public interface AlfabankServiceInt {

    List<BookCurrency> getBook(String title);

    List<BookCurrency> booksListToCurrency(List<BookEntity> bookEntityList, RateListResponse rateListResponse);
}
