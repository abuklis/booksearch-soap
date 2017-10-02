package by.bsu.booksearchsoap.dao.impl;


import by.bsu.booksearchsoap.dao.DAOException;
import by.bsu.booksearchsoap.dao.IBookDAO;
import by.bsu.booksearchsoap.dao.pool.ConnectionPool;
import by.bsu.booksearchsoap.entity.Author;
import by.bsu.booksearchsoap.entity.Book;
import by.bsu.booksearchsoap.entity.BookDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by anyab on 22.09.2017.
 */
public class MySQLBookDAO implements IBookDAO {

    private static final String SQL_VIEW_ALL_BOOKS = "SELECT b.book_id, b.title, b.publishing_year, " +
            "b.description, b.genre, a.author_id, a.full_name, a.birth_year, a.birth_country, a.biography " +
            "FROM booksearch.books as b join booksearch.authors as a on b.author_id = a.author_id";

    private static final String SQL_VIEW_BOOK_BY_ID = "SELECT b.book_id, b.title, b.publishing_year, " +
            "b.description, b.genre, a.author_id, a.full_name, a.birth_year, a.birth_country, a.biography " +
            "FROM booksearch.books as b join booksearch.authors as a on b.author_id = a.author_id where b.book_id = ?";

    private static final String SQL_ADD_BOOK =
            "INSERT INTO booksearch.books(title, publishing_year, description, genre, author_id) values (?,?,?,?,?)";

    private static final ConnectionPool POOL = ConnectionPool.getInstance();
    private static final String SQL_DELETE_BOOK = "DELETE FROM books WHERE books.book_id = ?" ;
    private static final java.lang.String SQL_UPDATE_BOOK = "UPDATE books SET title=? , description=? ," +
            " publishing_year=?, genre =? WHERE book_id=?";;

    @Override
    public void addBook(BookDTO bookDTO) throws DAOException {
        Connection connection = POOL.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_BOOK)) {
            preparedStatement.setString(1, bookDTO.getTitle());
            preparedStatement.setInt(2, bookDTO.getPublishingYear());
            preparedStatement.setString(3, bookDTO.getDescription());
            preparedStatement.setString(4, bookDTO.getGenre());
            preparedStatement.setLong(5, bookDTO.getAuthorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            returnConnectionToThePool(connection);
        }
    }

    @Override
    public Book[] viewAllBooks() throws DAOException {
        ArrayList<Book> books = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_VIEW_ALL_BOOKS)){
            Book book;
            while (resultSet.next()) {
                book = new Book(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4),
                        resultSet.getString(5));
                Author author = new Author(resultSet.getLong(6),
                        resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getString(9), resultSet.getString(10));
                book.setAuthor(author);
                books.add(book);
            }
        } catch (SQLException e){
            throw new DAOException("Exception is occurred during finding all books.", e);
        } finally {
            returnConnectionToThePool(connection);
        }
        return books.toArray(new Book[books.size()]);
    }

    @Override
    public Book getBook(long id) throws DAOException {
        Book book = new Book();
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_VIEW_BOOK_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4),
                        resultSet.getString(5));
                Author author = new Author(resultSet.getLong(6),
                        resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getString(9), resultSet.getString(10));
                book.setAuthor(author);
            }
        } catch (SQLException e){
            throw new DAOException("Exception is occurred during finding book by id .", e);
        } finally {
            returnConnectionToThePool(connection);
        }
        return book;
    }
    
    @Override
    public void deleteBook(long bookId) throws DAOException {
        Connection connection = POOL.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BOOK)) {
            preparedStatement.setLong(1, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Exception is occurred during deleting author.", e);
        } finally {
            returnConnectionToThePool(connection);
        }
    }

    @Override
    public void updateBook(BookDTO bookDTO) throws DAOException{
        Connection connection = POOL.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BOOK)) {
            preparedStatement.setString(1, bookDTO.getTitle());
            preparedStatement.setString(2, bookDTO.getDescription());
            preparedStatement.setInt(3, bookDTO.getPublishingYear());
            preparedStatement.setString(4, bookDTO.getGenre());
            preparedStatement.setLong(5, bookDTO.getBookId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Exception is occurred during updating book.", e);
        } finally {
            returnConnectionToThePool(connection);
        }
    }
}
