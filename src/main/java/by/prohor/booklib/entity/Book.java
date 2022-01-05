package by.prohor.booklib.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Book {
    private int id;

    private String isbn;

    @NotEmpty(message = "should not be empty")
    @Size(min = 2, max = 25, message = "should be between 2 and 25 characters")
    private String name;

    @NotEmpty(message = "should not be empty")
    @Size(min = 2, max = 25, message = "should be between 2 and 25 characters")
    private String author;

    @Size(min = 0, max = 1500, message = "should be between 0 and 1500 pages")
    private int page;

    @Min(value = 0, message = "")
    private double weight;

    @Min(value = 0, message = "")
    private double price;

    public Book(int id, String isbn, String name, String author, int page, double weight, double price) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.page = page;
        this.weight = weight;
        this.price = price;
    }
}
