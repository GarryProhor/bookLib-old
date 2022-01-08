package by.prohor.booklib.service.impl;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.service.LIbrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements LIbrService<Book> {

    private static Map<Integer, Book> books = new HashMap<>();

    private static int index = 2;
    static {
        Book book1 = new Book(1, "ISBN 978-5-55555-333-1", "GarryPotter", "G.Rolling", 500, 0.96, 15.15);
        books.put(1, book1);
        Book book2 = new Book(2, "ISBN 978-3-77777-2-5", "StarWars", "G.Lucas", 1000, 1.66, 29.99);
        books.put(2, book2);
    }


    @Override
    public List<Book> list() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book create(Book book) {
        index += index;
        book.setId(index);
        books.put(index, book);
        return book;
    }

    @Override
    public Book get(int id) {
        return books.get(id);
    }

    @Override
    public Book update(int id, Book book) {
        books.put(id, book);
        return book;
    }

    @Override
    public Book delete(int id) {
        return books.remove(id);
    }
}
