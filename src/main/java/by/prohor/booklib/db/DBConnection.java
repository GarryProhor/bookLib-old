package by.prohor.booklib.db;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class DBConnection {

    private final String CONNECTION = "jdbc:h2:~/test";
    private final String LOGIN = "root";
    private final String PASSWORD = "";

    private Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException {

        return dbConnection = DriverManager.getConnection(CONNECTION, LOGIN, PASSWORD);
    }
}
