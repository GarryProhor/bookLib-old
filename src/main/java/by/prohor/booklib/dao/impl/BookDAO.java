package by.prohor.booklib.dao.impl;

import by.prohor.booklib.dao.BookCRUD;
import by.prohor.booklib.db.DBConnection;
import by.prohor.booklib.entity.Book;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO implements BookCRUD<Book> {

    private final DBConnection dbConnection;

    public BookDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Book get(int id) {
        ResultSet resultSet = null;
        Book book = new Book();
        String query = "SELECT * FROM book WHERE id = ?";
        try(Connection connection = dbConnection.getDbConnection();
        PreparedStatement pst = connection.prepareStatement(query)) {

          //  PreparedStatement pst = dbConnection.getDbConnection().prepareStatement(query);
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if(resultSet.next()){
                book.setId(resultSet.getInt("id"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPage(resultSet.getInt("page"));
                book.setWeight(resultSet.getDouble("weight"));
                book.setPrice(resultSet.getBigDecimal("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return book;
    }

    @Override
    public List<Book> list() {
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book";
        try(PreparedStatement pst = dbConnection.getDbConnection().prepareStatement(query)) {
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPage(resultSet.getInt("page"));
                book.setWeight(resultSet.getDouble("weight"));
                book.setPrice(resultSet.getBigDecimal("price"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return books;
    }

    @Override
    public int create(Book book) {
        try{
            String query = "INSERT INTO book (isbn, name, author, page, weight, price) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = dbConnection.getDbConnection().prepareStatement(query);
            pst.setString(1, book.getIsbn());
            pst.setString(2, book.getName());
            pst.setString(3, book.getAuthor());
            pst.setInt(4, book.getPage());
            pst.setDouble(5, book.getWeight());
            pst.setBigDecimal(6, book.getPrice());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return book.getId();
    }

    @Override
    public Book update(int id, Book book) {
        String query = "UPDATE book SET isbn = ?, name = ?, author = ?, page = ?, weight = ?, price = ?, WHERE id = ?";
        try (PreparedStatement pst = dbConnection.getDbConnection().prepareStatement(query)){
            pst.setInt(1, book.getId());
            pst.setString(2, book.getIsbn());
            pst.setString(3, book.getName());
            pst.setString(4, book.getAuthor());
            pst.setInt(5, book.getPage());
            pst.setDouble(6, book.getWeight());
            pst.setBigDecimal(7, book.getPrice());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public Book delete(int id) {
        String  query = "DELETE FROM book WHERE id = ?";
        try(PreparedStatement pst = dbConnection.getDbConnection().prepareStatement(query)){
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
