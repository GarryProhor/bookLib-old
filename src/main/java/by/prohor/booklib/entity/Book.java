package by.prohor.booklib.entity;

import by.prohor.booklib.util.BookDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@JsonDeserialize(using = BookDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @NotNull
    private int id;

    @Pattern(regexp = "[0-9]{13}")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
