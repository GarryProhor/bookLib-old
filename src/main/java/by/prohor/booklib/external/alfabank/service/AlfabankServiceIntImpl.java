package by.prohor.booklib.external.alfabank.service;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.external.alfabank.model.BookCurrency;
import by.prohor.booklib.external.alfabank.model.RateListResponse;
import by.prohor.booklib.external.alfabank.util.AlfabankURL;
import by.prohor.booklib.services.dao.LibRepository;
import by.prohor.booklib.services.external.alfabank.AlfabankServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AlfabankServiceIntImpl extends AlfabankURL implements AlfabankServiceInt {

    private final LibRepository libRepository;
    private final RestTemplate restTemplate;


    @Override
    public List<BookCurrency> getBook(String title) {

        RateListResponse rateList = restTemplate.getForEntity(URL, RateListResponse.class).getBody();
        Book book = new Book();
        book.setName(title);
        return booksListToCurrency(libRepository.findByBooks(book), rateList);
    }

    @Override
    public List<BookCurrency> booksListToCurrency(List<BookEntity> bookEntityList, RateListResponse rateListResponse){
        List<BookCurrency> bookCurrencies = new ArrayList<>();
        for (BookEntity book:bookEntityList) {
            Map<String, BigDecimal> priceMap = new HashMap<>();
            @Positive @Digits(integer = 4, fraction = 2) BigDecimal byn = book.getPrice();
            priceMap.put("BYN", byn);
            priceMap.putAll(rateListResponse.toCurrency(book.getPrice()));
            bookCurrencies.add(new BookCurrency(book, priceMap));
        }
        return bookCurrencies;
    }

}

