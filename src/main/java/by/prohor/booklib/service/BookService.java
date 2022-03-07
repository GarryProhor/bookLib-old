package by.prohor.booklib.service;

import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;
import by.prohor.booklib.service.dto.BookDTO;

import java.util.List;

/**
 *  interface Book service.
 */
public interface BookService {

    List<BookDTO> findAllBooks();

    BookDTO getBook(Long bookId);

    List<BookOpenLibrary> findByAuthorName(String author);

    BookDTO saveBook(BookDTO bookDTO);

    String deleteBook(Long id);

    BookDTO updateBook (Long bookId, BookDTO bookDTO);
}
