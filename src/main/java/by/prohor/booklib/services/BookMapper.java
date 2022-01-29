package by.prohor.booklib.services;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import org.springframework.stereotype.Service;

@Service
public class BookMapper  {

    public static Book entityIntoDTO(BookEntity bookEntity) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setIsbn(bookEntity.getIsbn());
        book.setName(bookEntity.getName());
        book.setAuthor(bookEntity.getAuthor());
        book.setPage(bookEntity.getPage());
        book.setWeight(bookEntity.getWeight());
        book.setPrice(bookEntity.getPrice());
        return book;
    }

    public static BookEntity dtoIntoEntity(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setName(book.getName());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setPage(book.getPage());
        bookEntity.setWeight(book.getWeight());
        bookEntity.setPrice(book.getPrice());
        return bookEntity;
    }


}
