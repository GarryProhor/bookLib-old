package by.prohor.booklib.service;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.repository.implementation.BookRepository;
import by.prohor.booklib.services.BookMapper;
import by.prohor.booklib.services.BookService;
import by.prohor.booklib.stub.BookStub;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {BookServiceTest.class})
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    @Order(1)
    public void test_getAllBooks(){
        List<BookEntity> books = new ArrayList<>();
        books.add(BookStub.buildBook());
        when(bookRepository.findAll()).thenReturn(books);
        assertEquals(1, bookService.findAllBooks().size());
    }

    @Test
    @Order(2)
    public void test_getBookById(){
        List<BookEntity> books = new ArrayList<>();
        books.add(BookStub.buildBook());
        int bookId=1;

        when(bookRepository.findById((long) bookId)).thenReturn(BookStub.buildBook());
        assertEquals(bookId, bookService.findByIdBook((long) bookId).getId());
    }

    @Test
    @Order(3)
    public void test_saveBook(){
        BookEntity book = BookStub.buildBook();
        when(bookRepository.create(book)).thenReturn(book.getId());
    }

    @Test
    @Order(4)
    public void test_updateBook(){
        BookEntity book = BookStub.buildBook();
        when(bookRepository.update(book)).thenReturn(book.getId());
        assertEquals(book, bookService.updateBook(BookMapper.entityIntoDTO(book)));
    }

    @Test
    @Order(5)
    public void test_deleteBook(){
        Book book = BookStub.buildBookDTO();
        bookService.deleteBook((long) book.getId());
      //  verify(bookRepository.deleteById((long) book.getId()), times(1));
    }

}
