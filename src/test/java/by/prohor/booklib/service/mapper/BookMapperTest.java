package by.prohor.booklib.service.mapper;


import by.prohor.booklib.entity.Book;
import by.prohor.booklib.service.dto.BookDTO;
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
    private BookMapper bookMapper;

    @Test
    @Order(1)
    public void test_entityIntoDTO(){
        Book book = BookStub.buildBook();
        BookDTO bookDTO = BookStub.buildBookDTO();
        assertEquals(bookDTO, bookMapper.bookToBookDTO(book));
    }

    @Test
    @Order(2)
    public void test_dtoIntoEntity(){
        Book book = BookStub.buildBook();
        BookDTO bookDTO = BookStub.buildBookDTO();
        assertEquals(book, bookMapper.bookDTOtoBook(bookDTO));
    }
}
