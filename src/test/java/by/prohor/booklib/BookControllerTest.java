package by.prohor.booklib;


import by.prohor.booklib.controller.BookController;
import by.prohor.booklib.entity.Book;
import by.prohor.booklib.repository.BookRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;


public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    private Book bookStub;
    private MockMvc mockMvc;
}
