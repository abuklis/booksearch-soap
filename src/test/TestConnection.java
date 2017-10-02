import by.bsu.booksearchsoap.dao.IBookDAO;
import by.bsu.booksearchsoap.dao.impl.MySQLBookDAO;
import by.bsu.booksearchsoap.dao.pool.ConnectionPool;
import by.bsu.booksearchsoap.entity.Book;
import by.bsu.booksearchsoap.entity.BookDTO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by anyab on 24.09.2017.
 */
public class TestConnection {

    @Test
    public void testConnection() throws SQLException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        assert !connection.isClosed();
    }

    @Test
    public void testViewAllBooks() throws Exception {
        IBookDAO dao = new MySQLBookDAO();
        int expectedResult = 4;
        int actualResult = dao.viewAllBooks().length;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
