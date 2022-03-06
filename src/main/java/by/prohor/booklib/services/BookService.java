package by.prohor.booklib.services;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;
import java.util.List;

/**
 *  interface Book service.
 */
public interface BookService {

    List<Book> findAllBooks();

    Book findByIdBook(Long id);

    List<BookOpenLibrary> findByAuthorName(String author);


    Book saveBook(Book book);

    BookEntity updateBook(Book book);

    void deleteBook(Long id);

    void deleteAllBooks();
}
