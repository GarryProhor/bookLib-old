package by.prohor.booklib.services;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.repository.implementation.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> findAllBooks(){
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<Book> bookList = bookEntities.stream().map(BookMapper::entityIntoDTO).collect(Collectors.toList());
        return bookList;
    }

    public Book findByIdBook(Long id){
        BookEntity bookEntity = bookRepository.findById(id);
        Book book = BookMapper.entityIntoDTO(bookEntity);
        return book;
    }

    public void saveBook(Book book){
        BookEntity bookEntity = BookMapper.dtoIntoEntity(book);
        bookRepository.create(bookEntity);
    }

    public void updateBook(Book book){
        BookEntity bookEntity = BookMapper.dtoIntoEntity(book);
        bookRepository.update(bookEntity);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }
}
