package by.prohor.booklib.service.repo;

import by.prohor.booklib.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Page<Book> findAllByAuthor (String name, Pageable entity);
    Boolean existsByName (String name);
    List<Book> findByName(String author);

}
