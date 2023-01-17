package First_Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static String READ_ALL = "select * from books";
    private static String CREATE = "insert into books (book_name, author, pub_date) values (?, ?, ?)";
    private static String READ_BY_ID = "select * from books where idbooks = ?";
    private static String UPDATE_BY_ID = "update book set book_name = ?, author = ?, pub_date = ? where idbooks = ?";
    private static String DELETE_BY_ID="delete from books where idbook = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BookDAO (Connection connection) {
        this.connection = connection;
    }
    public  void insert(Book book) throws SQLException {
        preparedStatement=connection.prepareStatement(CREATE);
        preparedStatement.setString(1,book.getBook_name());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setInt(3,book.getPub_date());
        preparedStatement.executeUpdate();
    }
    public Book readById(int id) throws SQLException{
        preparedStatement=connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return BookMapper.bookMapper(resultSet);
    }
    public void update(Book book) throws SQLException{
        preparedStatement=connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setString(1,book.getBook_name());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setInt(3, book.getPub_date());
        preparedStatement.setInt(4,book.getIdbooks());
        preparedStatement.executeUpdate();
    }
    public void delete(Book book) throws SQLException{
        preparedStatement=connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1,book.getIdbooks());
        preparedStatement.executeUpdate();
    }
    public List<Book> readAll() throws SQLException{
        List<Book> books = new ArrayList<>();
        preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            books.add(BookMapper.bookMapper(resultSet));
        }
        return books;
    }
}
