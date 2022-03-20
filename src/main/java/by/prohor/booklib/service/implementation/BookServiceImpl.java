package by.prohor.booklib.service.implementation;

import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;
import by.prohor.booklib.service.BookService;
import by.prohor.booklib.service.dto.BookDTO;
import by.prohor.booklib.entity.Book;
import by.prohor.booklib.exception.NoSuchBookException;
import by.prohor.booklib.service.mapper.BookMapper;

import by.prohor.booklib.service.external.openlibrary.OpenLibraryService;
import by.prohor.booklib.service.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final BookMapper bookMapper;
    private final OpenLibraryService openLibraryService;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo, OpenLibraryService openLibraryService, BookMapper bookMapper) {
        this.bookRepo = bookRepo;
        this.openLibraryService = openLibraryService;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> findAllBooks(){
        List<Book> bookEntities = bookRepo.findAll();
        List<BookDTO> bookList = new ArrayList<>();
        for (Book book : bookEntities) {
            BookDTO bookDTO = bookMapper.bookToBookDTO(book);
            bookList.add(bookDTO);
        }
        return bookList;
    }


    @Override
    public List<BookOpenLibrary> findByAuthorName(String author){
        List<Book> bookList = bookRepo.findByName(author);
        List<BookOpenLibrary> openLibraryList = openLibraryService.findBooksByAuthor(author);
        List<BookOpenLibrary> bookOpenLibraryList = bookList.stream()
                .map(book -> bookMapper.bookToBookOpenLibrary(book)).collect(Collectors.toList());
        bookOpenLibraryList.addAll(openLibraryList);
        return bookOpenLibraryList;
    }

    public BookDTO getBook(Long bookId){
        Book book = bookRepo.findById(bookId).orElseThrow(()-> new NoSuchBookException("This book doesn't exist. Book id: " + bookId));

        return bookMapper.bookToBookDTO(book);
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO){
        Boolean isExist = bookRepo.existsByName(bookDTO.getName());

        if (isExist) {
            throw new RuntimeException(); // книга уже существует
        }

        bookRepo.save(bookMapper.bookDTOtoBook(bookDTO));

        return bookDTO;
    }


    @Override
    public String deleteBook(Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(()-> new NoSuchBookException("This book doesn't exist. Book id: " + bookId));
        bookRepo.delete(book);
        return "Book with id " + bookId + " was deleted";
    }

    @Override
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        Book book = bookRepo.findById(bookId).orElseThrow(()-> new NoSuchBookException("This book doesn't exist. Book id: " + bookId));
        bookMapper.updateBookFromDTO(bookDTO, book);
        Book updatedBook = bookRepo.save(book);
        return bookMapper.bookToBookDTO(updatedBook);
    }
}
