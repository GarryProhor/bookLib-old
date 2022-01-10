package by.prohor.booklib.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LIbrService<K> {

    List<K> list();

    K create(K k);

    K get(int id);

    K update(int id, K k);

    K delete(int id);

}
