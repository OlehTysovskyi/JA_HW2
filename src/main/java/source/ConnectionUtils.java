package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static String USER_NAME="root";
    private static String USER_PASSWORD="asdf2005";
    private static String URL="jdbc:mysql://localhost/book_shop";
    
    public static Connection openConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
    }
}
