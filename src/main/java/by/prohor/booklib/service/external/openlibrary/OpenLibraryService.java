package by.prohor.booklib.service.external.openlibrary;

import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;

import java.util.List;

/**
 * The interface OpenLibrary service.
 */
public interface OpenLibraryService {

    List<BookOpenLibrary> findBooksByAuthor(String author);
}
