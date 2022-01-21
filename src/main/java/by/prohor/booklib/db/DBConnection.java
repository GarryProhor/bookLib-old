package by.prohor.booklib.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String HOST = "localhost";
    private final String PORT = "8080";
    private final String DB_NAME = "Library_DB";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    private Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException {
        String connection = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        return dbConnection = DriverManager.getConnection(connection, LOGIN, PASSWORD);
    }
}
