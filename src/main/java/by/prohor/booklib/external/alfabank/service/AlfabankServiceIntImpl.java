package by.prohor.booklib.external.alfabank.service;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.external.alfabank.model.BookCurrency;
import by.prohor.booklib.external.alfabank.model.RateListResponse;
import by.prohor.booklib.external.alfabank.util.AlfabankURL;
import by.prohor.booklib.service.external.alfabank.AlfabankService;
import by.prohor.booklib.service.repo.BookRepo;
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
public class AlfabankServiceIntImpl extends AlfabankURL implements AlfabankService {

    private final BookRepo bookRepo;
    private final RestTemplate restTemplate;

    public AlfabankServiceIntImpl(BookRepo bookRepo, RestTemplate restTemplate) {
        this.bookRepo = bookRepo;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<BookCurrency> getBook(String title) {

        RateListResponse rateList = restTemplate.getForEntity(URL, RateListResponse.class).getBody();
        Book book = new Book();
        book.setName(title);
        return booksListToCurrency(bookRepo.findAll(), rateList);
    }


    private List<BookCurrency> booksListToCurrency(List<Book> bookList, RateListResponse rateListResponse){
        List<BookCurrency> bookCurrencies = new ArrayList<>();
        for (Book book:bookList) {
            Map<String, BigDecimal> priceMap = new HashMap<>();
            @Positive @Digits(integer = 4, fraction = 2) BigDecimal byn = book.getPrice();
            priceMap.put("BYN", byn);
            priceMap.putAll(rateListResponse.toCurrency(book.getPrice()));
            bookCurrencies.add(new BookCurrency(book, priceMap));
        }
        return bookCurrencies;
    }

}

