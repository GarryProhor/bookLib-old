package by.prohor.booklib.stub;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.service.dto.BookDTO;

import java.math.BigDecimal;


public class BookStub {
    public static BookDTO buildBookDTO(){

        BookDTO book = new BookDTO();
       // book.setId(1);
        book.setIsbn("ISBN 978-1-55111-123-9");
        book.setName("Garry Potter");
        book.setAuthor("G.Rouling");
        book.setPage(700);
        book.setWeight(0.78);
        book.setPrice(BigDecimal.valueOf(99.98));
        return book;
    }
    public static Book buildBook(){

        Book book = new Book();
       // book.setId(1);
        book.setIsbn("ISBN 978-1-55111-123-9");
        book.setName("Garry Potter");
        book.setAuthor("G.Rouling");
        book.setPage(700);
        book.setWeight(0.78);
        book.setPrice(BigDecimal.valueOf(99.98));
        return book;
    }

}
