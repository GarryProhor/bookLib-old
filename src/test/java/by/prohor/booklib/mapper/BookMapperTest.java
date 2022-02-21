package by.prohor.booklib.mapper;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.mappers.book.BookMapperImpl;
import by.prohor.booklib.stub.BookStub;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {BookMapperTest.class})
public class BookMapperTest {

    @InjectMocks
    private BookMapperImpl mapper;

    @Test
    @Order(1)
    public void test_entityIntoDTO(){
        BookEntity bookEntity = BookStub.buildBook();
        Book book = BookStub.buildBookDTO();
        assertEquals(book, mapper.bookEntityToBook(bookEntity));
    }

    @Test
    @Order(2)
    public void test_dtoIntoEntity(){
        BookEntity bookEntity = BookStub.buildBook();
        Book book = BookStub.buildBookDTO();
        assertEquals(bookEntity, mapper.bookToBookEntity(book));
    }
}
