package by.prohor.booklib.entity;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String isbn;
    private String name;
    private String author;
    private int page;
    private double weight;
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
