package by.prohor.booklib.controller;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.services.BookMapper;
import by.prohor.booklib.services.BookService;
import by.prohor.booklib.stub.BookStub;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;



@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {BookControllerTest.class})
public class BookControllerTest {

    @Mock
    BookService bookService;

    @InjectMocks
    private BookController bookController;


    @Test
    @Order(1)
    public void test_getAllBooks(){
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(BookMapper.entityIntoDTO(BookStub.buildBook()));
        Mockito.when(bookService.findAllBooks()).thenReturn(bookList);
        ResponseEntity<Object> res = bookController.getAllBooks();
        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    @Order(2)

    public void test_getBookById(){
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(BookMapper.entityIntoDTO(BookStub.buildBook()));
        int countId = 1;
        Mockito.when(bookService.findByIdBook((long) countId)).thenReturn(BookMapper.entityIntoDTO(BookStub.buildBook()));
        ResponseEntity<Object> res = bookController.getBookById((long) countId);
        assertEquals(HttpStatus.OK, res.getStatusCode());    }

    @Test
    @Order(3)

    public void test_createBook(){
        Book book = BookStub.buildBookDTO();
        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        ResponseEntity<Object> res = bookController.createBook(book);
        assertEquals(HttpStatus.CREATED, res.getStatusCode());
    }
    @Test
    @Order(4)
    public void test_updateBook(){
        Book book = BookStub.buildBookDTO();
        Mockito.when(bookService.updateBook(book)).thenReturn(BookMapper.dtoIntoEntity(book));
//        ResponseEntity<Object> res = bookController.updateBook((long) book.getId(), book);
//        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    @Order(5)
    public void test_deleteBookById(){
        BookEntity book = BookStub.buildBook();
        Mockito.when(bookController.deleteBookById((long) book.getId()));

    }

    @Test
    @Order(6)
    public void test_deleteAllBook(){
        Mockito.when(bookController.deleteAllBook());

    }
}
