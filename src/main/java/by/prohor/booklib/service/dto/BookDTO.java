package by.prohor.booklib.service.dto;

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

public class BookDTO {
    @NotNull
    private Long id;

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

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPage() {
        return page;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
