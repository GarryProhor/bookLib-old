package by.prohor.booklib.external.alfabank.service;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.external.alfabank.model.BookCurrency;
import by.prohor.booklib.external.alfabank.model.RateListResponse;
import by.prohor.booklib.external.alfabank.util.AlfabankURL;
import by.prohor.booklib.repository.interfaces.LibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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

public class AlfabankService extends AlfabankURL {


    private final LibRepository libRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public AlfabankService(LibRepository libRepository, RestTemplateBuilder builder) {
        this.libRepository = libRepository;
        this.restTemplate = builder.build();
    }


    public List<BookCurrency> getBook(String title) {

        RateListResponse rateList = restTemplate.getForEntity(URL, RateListResponse.class).getBody();
        Book book = new Book();
        book.setName(title);
        return booksListToCurrency(libRepository.findByBooks(book), rateList);
    }

    private List<BookCurrency> booksListToCurrency(List<BookEntity> bookEntityList, RateListResponse rateListResponse){
        List<BookCurrency> bookCurrencies = new ArrayList<>();
        for (BookEntity book:bookEntityList) {

            Map<String, BigDecimal> priceMap = new HashMap<String, BigDecimal>();
            @Positive @Digits(integer = 4, fraction = 2) BigDecimal byn = book.getPrice();
            priceMap.put("BYN", byn);
            priceMap.putAll(rateListResponse.toCurrency(book.getPrice()));
            bookCurrencies.add(new BookCurrency(book, priceMap));
        }
        return bookCurrencies;
    }

}

