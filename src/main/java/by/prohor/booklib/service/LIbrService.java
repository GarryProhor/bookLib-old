package by.prohor.booklib.service;

import java.util.List;


public interface LIbrService<K> {

    List<K> list();

    K create(K k);

    K get(int id);

    K update(int id, K k);

    K delete(int id);

}
