package by.prohor.booklib.services;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.entity.BookOpenLibrary;
import by.prohor.booklib.external.service.OpenLibraryService;
import by.prohor.booklib.mappers.book.BookMapperImpl;
import by.prohor.booklib.repository.implementation.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final OpenLibraryService openLibraryService;
    @Autowired
    private BookMapperImpl mapper;

    public List<Book> findAllBooks(){
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            Book book = mapper.bookEntityToBook(bookEntity);
            bookList.add(book);
        }
        return bookList;
    }

    public Book findByIdBook(Long id){
        BookEntity bookEntity = bookRepository.findById(id);
        Book book = mapper.bookEntityToBook(bookEntity);
        return book;
    }

    public List<BookOpenLibrary> findByAuthorName(String author){
        List<BookEntity> bookEntity = bookRepository.findByName(author);
        List<BookOpenLibrary> openLibraryList = openLibraryService.findBooksByAuthor(author);
        List<BookOpenLibrary> bookOpenLibraryList = bookEntity.stream()
                .map(BookMapperImpl::bookEntityToBookOpenLibrary).collect(Collectors.toList());
        bookOpenLibraryList.addAll(openLibraryList);
        return bookOpenLibraryList;
    }


    public Book saveBook(Book book){
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.create(bookEntity);
        return book;
    }

    public BookEntity updateBook(Book book){
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.update(bookEntity);
        return bookEntity;
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }
}
