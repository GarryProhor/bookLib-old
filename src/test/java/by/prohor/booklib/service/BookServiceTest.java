package by.prohor.booklib.service;


//import by.prohor.booklib.mappers.book.BookMapperImpl;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
        import org.junit.jupiter.api.TestMethodOrder;
        import org.springframework.boot.test.context.SpringBootTest;


        import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {BookServiceTest.class})
public class BookServiceTest {

//    @Mock
//    BookRepository bookRepository;
//
//    @InjectMocks
//    BookServiceImpl bookServiceImpl;
//
//    @InjectMocks
//    private BookMapperImpl mapper;
//
//    @Test
//    @Order(1)
//    public void test_getAllBooks(){
//        List<BookEntity> books = new ArrayList<>();
//        books.add(BookStub.buildBook());
//        when(bookRepository.findAll()).thenReturn(books);
//        assertEquals(1, bookServiceImpl.findAllBooks().size());
//    }
//
//    @Test
//    @Order(2)
//    public void test_getBookById(){
//        List<BookEntity> books = new ArrayList<>();
//        books.add(BookStub.buildBook());
//        int bookId=1;
//
//        when(bookRepository.findById((long) bookId)).thenReturn(BookStub.buildBook());
//        assertEquals(bookId, bookServiceImpl.findByIdBook((long) bookId).getId());
//    }
//
//    @Test
//    @Order(3)
//    public void test_saveBook(){
//        BookEntity book = BookStub.buildBook();
//        when(bookRepository.create(book)).thenReturn(book.getId());
//    }
//
//    @Test
//    @Order(4)
//    public void test_updateBook(){
//        BookEntity book = BookStub.buildBook();
//        when(bookRepository.update(book)).thenReturn(book.getId());
//        assertEquals(book, bookServiceImpl.updateBook(mapper.bookEntityToBook(book)));
//    }
//
//    @Test
//    @Order(5)
//    public void test_deleteBook(){
//        Book book = BookStub.buildBookDTO();
//        bookServiceImpl.deleteBook((long) book.getId());
//      //  verify(bookRepository.deleteById((long) book.getId()), times(1));
//    }

}
