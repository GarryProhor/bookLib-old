package by.prohor.booklib.dao;

import by.prohor.booklib.entity.Book;

public interface BookCRUD<B> extends LIbrCRUD<Book>{
    Book get(int id);
}
