package by.prohor.booklib.db;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class DBConnection {
    private Connection dbConnection = null;
    public Connection getDbConnection() throws SQLException {
        try{
            if(dbConnection==null){
                Class.forName("org.h2.Driver");
                dbConnection = DriverManager.getConnection("jdbc:h2:~/test", "root", "");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return dbConnection;
    }
}
