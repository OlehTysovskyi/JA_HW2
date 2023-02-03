package source;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        BookDAO bookDao= new BookDAO(ConnectionUtils.openConnection());
        bookDao.readAll().forEach(System.out::println);
        
        System.out.println("-----------------------------------------------------------------------");
        bookDao.insert(new Book("Red Hat","unknown",1982));
        System.out.println(bookDao.readById(1));
        
        System.out.println("-----------------------------------------------------------------------");
        bookDao.update(new Book(2,"Harry Potter","unknown",2000));
        bookDao.delete(new Book(2,"Harry Potter","unknown",2000));
        bookDao.readAll().forEach(System.out::println);
    }
}
