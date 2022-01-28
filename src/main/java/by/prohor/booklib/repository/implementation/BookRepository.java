package by.prohor.booklib.repository.implementation;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import by.prohor.booklib.repository.interfaces.LibRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements LibRepository<BookEntity> {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(BookEntity book) {
        return jdbcTemplate.update("INSERT INTO book (isbn, name, author, page, weight, price) VALUES (?, ?, ?, ?, ?, ?)",
                new Object[]{book.getIsbn(), book.getName(), book.getAuthor(), book.getPage(), book.getWeight(), book.getPrice()});
    }

    @Override
    public int update(BookEntity book) {
        return jdbcTemplate.update("UPDATE book SET isbn = ?, name = ?, author = ?, page = ?, weight = ?, price = ?, WHERE id = ?",
                new Object[]{book.getId(), book.getIsbn(), book.getName(), book.getAuthor(), book.getPage(), book.getWeight(), book.getPrice()});
    }

    @Override
    public BookEntity findById(Long id) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?", new BeanPropertyRowMapper<>(BookEntity.class), id);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

    @Override
    public List<BookEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM book", new  BeanPropertyRowMapper<>(BookEntity.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM book");
    }
}
