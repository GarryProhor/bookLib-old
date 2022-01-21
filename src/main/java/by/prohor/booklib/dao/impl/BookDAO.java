package by.prohor.booklib.dao.impl;

import by.prohor.booklib.dao.BookCRUD;
import by.prohor.booklib.db.DBConnection;
import by.prohor.booklib.entity.Book;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class BookDAO implements BookCRUD<Book> {

    private final DBConnection dbConnection;

    public BookDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Book get(int id) {
        return null;
    }

    @Override
    public List<Book> list() {
        return null;
    }

    @Override
    public int create(Book book) {
        try{
            String query = "INSERT INTO `book` (isbn, name, author, page, weight, price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = dbConnection.getDbConnection().prepareStatement(query);
            pst.setString(1, book.getIsbn());
            pst.setString(2, book.getName());
            pst.setString(3, book.getAuthor());
            pst.setInt(4, book.getPage());
            pst.setDouble(5, book.getWeight());
            pst.setBigDecimal(6, book.getPrice());
            pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return book.getId();
    }

    @Override
    public Book update(int id, Book book) {
        return null;
    }

    @Override
    public Book delete(int id) {
        return null;
    }
}
