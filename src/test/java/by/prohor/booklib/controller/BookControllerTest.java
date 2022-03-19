package by.prohor.booklib.controller;

//import by.prohor.booklib.mappers.book.BookMapperImpl;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
        import org.junit.jupiter.api.TestMethodOrder;
        import org.springframework.boot.test.context.SpringBootTest;

        import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {BookControllerTest.class})
public class BookControllerTest {
//
//    @Mock
//    BookServiceImpl bookServiceImpl;
//
//    @InjectMocks
//    private BookController bookController;
//
//    @InjectMocks
//    private BookMapperImpl mapper;
//
//
//    @Test
//    @Order(1)
//    public void test_getAllBooks(){
//        ArrayList<Book> bookList = new ArrayList<>();
//        bookList.add(mapper.bookEntityToBook(BookStub.buildBook()));
//        Mockito.when(bookServiceImpl.findAllBooks()).thenReturn(bookList);
//        ResponseEntity<Object> res = bookController.getAllBooks();
//        assertEquals(HttpStatus.OK, res.getStatusCode());
//    }
//
//    @Test
//    @Order(2)
//
//    public void test_getBookById(){
//        ArrayList<Book> bookList = new ArrayList<>();
//        bookList.add(mapper.bookEntityToBook(BookStub.buildBook()));
//        int countId = 1;
//        Mockito.when(bookServiceImpl.findByIdBook((long) countId)).thenReturn(mapper.bookEntityToBook(BookStub.buildBook()));
//        ResponseEntity<Object> res = bookController.getBookById((long) countId);
//        assertEquals(HttpStatus.OK, res.getStatusCode());    }
//
//    @Test
//    @Order(3)
//
//    public void test_createBook(){
//        Book book = BookStub.buildBookDTO();
//        Mockito.when(bookServiceImpl.saveBook(book)).thenReturn(book);
//        ResponseEntity<Object> res = bookController.createBook(book);
//        assertEquals(HttpStatus.CREATED, res.getStatusCode());
//    }
//    @Test
//    @Order(4)
//    public void test_updateBook(){
//        Book book = BookStub.buildBookDTO();
//        Mockito.when(bookServiceImpl.updateBook(book)).thenReturn(mapper.bookToBookEntity(book));
////        ResponseEntity<Object> res = bookController.updateBook((long) book.getId(), book);
////        assertEquals(HttpStatus.OK, res.getStatusCode());
//    }
//
//    @Test
//    @Order(5)
//    public void test_deleteBookById(){
//        BookEntity book = BookStub.buildBook();
//        Mockito.when(bookController.deleteBookById((long) book.getId()));
//
//    }
//
//    @Test
//    @Order(6)
//    @Disabled
//    public void test_deleteAllBook(){
//        Mockito.when(bookController.deleteAllBook());
//
//    }
}
