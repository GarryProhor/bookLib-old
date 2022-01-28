package by.prohor.booklib.entity;

import by.prohor.booklib.util.BookDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@JsonDeserialize(using = BookDeserializer.class)
public class Book {
    @NotNull
    private int id;

    @Pattern(regexp = "^[ISBN]{4} [978]{3}[-]{1}[\\d]{1}[-]{1}[\\d]{5}[-]{1}[\\d]{3}[-]{1}[\\d]{1}$")
    private String isbn;

    @NotBlank(message = "should not be empty")
    @Size(min = 2, max = 25, message = "should be between 2 and 25 characters")
    private String name;

    @NotBlank(message = "should not be empty")
    @Size(min = 2, max = 25, message = "should be between 2 and 25 characters")
    private String author;

    @Min(1)
    @Max(1000)
    private int page;

    @PositiveOrZero
    private double weight;

    @Positive
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    public Book() {
    }

    public Book(int id, String isbn, String name, String author, int page, double weight, double price) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.page = page;
        this.weight = weight;
        this.price = BigDecimal.valueOf(price);
    }
    public Book(String isbn, String name, String author, int page, double weight, double price) {

        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.page = page;
        this.weight = weight;
        this.price = BigDecimal.valueOf(price);
    }

    public Book(String isbn, String name, String author, int page, double weight, BigDecimal price) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.page = page;
        this.weight = weight;
        this.price = price;
    }
}
