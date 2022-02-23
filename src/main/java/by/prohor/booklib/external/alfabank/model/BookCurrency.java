package by.prohor.booklib.external.alfabank.model;
import by.prohor.booklib.entity.BookEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;


@Data
@NoArgsConstructor
public class BookCurrency {

    private String isbn;
    private String name;
    private String author;
    private int page;
    private double weight;
    private Map <String, BigDecimal> price;

    public BookCurrency(BookEntity book, Map<String, BigDecimal> price) {
        this.isbn = book.getIsbn();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.page = book.getPage();
        this.weight = book.getWeight();
        this.price = price;
    }

}