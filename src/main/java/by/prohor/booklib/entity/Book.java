package by.prohor.booklib.entity;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class Book {
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

    @Min(0)
    private double weight;

    // ^[0-9]*[.,][0-9]+$
    // ^\d+(?:[.,]\d{2})?$
    //@Pattern(regexp = "^[0-9]*[.,][0-9]+$", message = "шляпа полная")
    @DecimalMin(value = "0.0", message = "invalid number. enter a positive number")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    public Book(int id, String isbn, String name, String author, int page, double weight, double price) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.page = page;
        this.weight = weight;
        this.price = BigDecimal.valueOf(price);
    }
}
