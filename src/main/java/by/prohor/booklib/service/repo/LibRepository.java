package by.prohor.booklib.service.repo;

import java.util.List;

public interface LibRepository<K> {
    int create(K k);
    int updateBook(K k);
    K findById(Long id);
    List<K> findByName(String author);
    List<K> findByBooks(K k);
    int deleteById(Long id);
    List<K> findAll();
    int deleteAll();

}
