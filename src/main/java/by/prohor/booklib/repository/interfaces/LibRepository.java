package by.prohor.booklib.repository.interfaces;

import java.util.List;

public interface LibRepository<K> {
    int create(K k);
    int update(K k);
    K findById(Long id);
    int deleteById(Long id);
    List<K> findAll();
    int deleteAll();

}
