package First_Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookMapper {
    public static Book bookMapper(ResultSet result) throws SQLException {
        int idbooks = result.getInt("idbooks");
        String book_name= result.getString("book_name");
        String author= result.getString("author");
        int pub_date = result.getInt("pub_date");
        return new Book(idbooks, book_name, author, pub_date);
    }
}
