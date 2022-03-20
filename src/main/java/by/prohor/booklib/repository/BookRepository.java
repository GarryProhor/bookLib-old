package by.prohor.booklib.repository;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.service.repo.LibRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements LibRepository<Book> {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(Book book) {
        return jdbcTemplate.update("INSERT INTO book (isbn, name, author, page, weight, price) VALUES (?, ?, ?, ?, ?, ?)",
                new Object[]{book.getIsbn(), book.getName(), book.getAuthor(), book.getPage(), book.getWeight(), book.getPrice()});
    }

    @Override
    public int updateBook(Book book) {
        return jdbcTemplate.update("UPDATE book SET isbn = ?, name = ?, author = ?, page = ?, weight = ?, price = ?, WHERE id = ?",
                new Object[]{book.getId(), book.getIsbn(), book.getName(), book.getAuthor(), book.getPage(), book.getWeight(), book.getPrice()});
    }

    @Override
    public Book findById(Long id) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?", new BeanPropertyRowMapper<>(Book.class), id);
        }catch (Exception e){
            return null;
        }
    }


    @Override
    public List<Book> findByName(String author) {
        try{
            return jdbcTemplate.query("SELECT * FROM book WHERE author = ?", new BeanPropertyRowMapper<>(Book.class), author);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Book> findByBooks(Book book) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book", new  BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM book");
    }
}
