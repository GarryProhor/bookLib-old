package by.prohor.booklib.entity;

//import by.prohor.booklib.util.BookDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

//@JsonDeserialize(using = BookDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "book")
public class Book {

    @Id
    private Long id;

    private String isbn;

    private String name;

    private String author;

    private int page;

    private double weight;

    private BigDecimal price;

    public Book() {
    }

    public Book(Long id, String isbn, String name, String author, int page, double weight, BigDecimal price) {
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public static class BookBuilder {
        private @NotNull Long id;
        private @Pattern(regexp = "[0-9]{13}") String isbn;
        private @NotBlank(message = "should not be empty") @Size(min = 2, max = 25, message = "should be between 2 and 25 characters") String name;
        private @NotBlank(message = "should not be empty") @Size(min = 2, max = 25, message = "should be between 2 and 25 characters") String author;
        private @Min(1) @Max(1000) int page;
        private @PositiveOrZero double weight;
        private @Positive @Digits(integer = 4, fraction = 2) BigDecimal price;

        BookBuilder() {
        }

        public BookBuilder id(@NotNull Long id) {
            this.id = id;
            return this;
        }

        public BookBuilder isbn(@Pattern(regexp = "[0-9]{13}") String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder name(@NotBlank(message = "should not be empty") @Size(min = 2, max = 25, message = "should be between 2 and 25 characters") String name) {
            this.name = name;
            return this;
        }

        public BookBuilder author(@NotBlank(message = "should not be empty") @Size(min = 2, max = 25, message = "should be between 2 and 25 characters") String author) {
            this.author = author;
            return this;
        }

        public BookBuilder page(@Min(1) @Max(1000) int page) {
            this.page = page;
            return this;
        }

        public BookBuilder weight(@PositiveOrZero double weight) {
            this.weight = weight;
            return this;
        }

        public BookBuilder price(@Positive @Digits(integer = 4, fraction = 2) BigDecimal price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(id, isbn, name, author, page, weight, price);
        }

        public String toString() {
            return "Book.BookBuilder(id=" + this.id + ", isbn=" + this.isbn + ", name=" + this.name + ", author=" + this.author + ", page=" + this.page + ", weight=" + this.weight + ", price=" + this.price + ")";
        }
    }
}
