package by.prohor.booklib.mappers.book;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.entity.BookOpenLibrary;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper{
    @Override
    public Book bookEntityToBook(BookEntity bookEntity) {
        if(bookEntity == null){
            return null;
        }
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setIsbn(bookEntity.getIsbn());
        book.setName(bookEntity.getName());
        book.setAuthor(book.getAuthor());
        book.setPage(book.getPage());
        book.setWeight(book.getWeight());
        book.setPrice(bookEntity.getPrice());
        return book;
    }

    @Override
    public BookEntity bookToBookEntity(Book book) {
        if(book == null){
            return null;
        }
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


    public static BookOpenLibrary bookEntityToBookOpenLibrary(BookEntity bookEntity) {
        if(bookEntity == null){
            return null;
        }
        BookOpenLibrary bookOpenLibrary = new BookOpenLibrary();
        bookOpenLibrary.setIsbn(bookEntity.getIsbn());
        bookOpenLibrary.setName(bookEntity.getName());
        bookOpenLibrary.setAuthor(bookEntity.getAuthor());
        return bookOpenLibrary;
    }
}
