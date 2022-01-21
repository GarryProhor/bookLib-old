package by.prohor.booklib.dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LIbrCRUD<K> {

    List<K> list();

    int create(K k);

    K update(int id, K k);

    K delete(int id);

}
