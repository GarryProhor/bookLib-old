package by.prohor.booklib.services;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;
import by.prohor.booklib.external.openlibrary.service.OpenLibraryServiceImpl;
import by.prohor.booklib.mappers.book.BookMapperImpl;
import by.prohor.booklib.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final OpenLibraryServiceImpl openLibraryServiceImpl;
    @Autowired
    private BookMapperImpl mapper;

    @Override
    public List<Book> findAllBooks(){
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            Book book = mapper.bookEntityToBook(bookEntity);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public Book findByIdBook(Long id){
        BookEntity bookEntity = bookRepository.findById(id);
        Book book = mapper.bookEntityToBook(bookEntity);
        return book;
    }

    @Override
    public List<BookOpenLibrary> findByAuthorName(String author){
        List<BookEntity> bookEntity = bookRepository.findByName(author);
        List<BookOpenLibrary> openLibraryList = openLibraryServiceImpl.findBooksByAuthor(author);
        List<BookOpenLibrary> bookOpenLibraryList = bookEntity.stream()
                .map(BookMapperImpl::bookEntityToBookOpenLibrary).collect(Collectors.toList());
        bookOpenLibraryList.addAll(openLibraryList);
        return bookOpenLibraryList;
    }

    @Override
    public Book saveBook(Book book){
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.create(bookEntity);
        return book;
    }

    @Override
    public BookEntity updateBook(Book book){
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.update(bookEntity);
        return bookEntity;
    }

    @Override
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    @Override
    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }
}
