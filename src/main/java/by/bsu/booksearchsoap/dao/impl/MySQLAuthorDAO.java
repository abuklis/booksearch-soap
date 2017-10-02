package by.bsu.booksearchsoap.dao.impl;

import by.bsu.booksearchsoap.dao.DAOException;
import by.bsu.booksearchsoap.dao.IAuthorDAO;
import by.bsu.booksearchsoap.dao.pool.ConnectionPool;
import by.bsu.booksearchsoap.entity.Author;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by anyab on 23.09.2017.
 */
public class MySQLAuthorDAO implements IAuthorDAO{
    private static final String SQL_VIEW_ALL_BOOKS = "SELECT a.author_id, a.full_name, a.birth_year, a.birth_country," +
            " a.biography FROM booksearch.authors a";

    private static final String SQL_ADD_AUTHOR =
            "INSERT INTO  booksearch.authors(full_name, birth_year, birth_country, biography) VALUES (?,?,?,?)";

    private static final String SQL_EDIT_AUTHOR_INFO =
            "UPDATE authors SET full_name=? , birth_year=? , birth_country=?, " +
                    "biography=? WHERE author_id=?";

    private static final String SQL_VIEW_AUTHOR_BY_ID = "SELECT a.author_id, a.full_name, a.birth_year," +
            " a.birth_country, a.biography FROM booksearch.authors as a where a.author_id = ?";

    private static final String SQL_DELETE_AUTHOR =
            "DELETE FROM authors WHERE author_id = ?";

    private static final ConnectionPool POOL = ConnectionPool.getInstance();

    @Override
    public void addAuthor(Author author) throws DAOException {
        Connection connection = POOL.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_AUTHOR)){
            preparedStatement.setString(1, author.getFullName());
            preparedStatement.setInt(2, author.getBirthYear());
            preparedStatement.setString(3, author.getBirthCountry());
            preparedStatement.setString(4, author.getBiography());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Exception occurred during adding author.", e);
        } finally {
            returnConnectionToThePool(connection);
        }
    }

    @Override
    public void updateAuthor(Author author) throws DAOException {
        Connection connection = POOL.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_EDIT_AUTHOR_INFO)){
            preparedStatement.setString(1, author.getFullName());
            preparedStatement.setInt(2, author.getBirthYear());
            preparedStatement.setString(3, author.getBirthCountry());
            preparedStatement.setString(4, author.getBiography());
            preparedStatement.setLong(5, author.getAuthorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Exception occurred during updating author.", e);
        } finally {
            returnConnectionToThePool(connection);
        }
    }

    @Override
    public Author[] viewAllAuthors() throws DAOException {
        ArrayList<Author> authors = new ArrayList<>();
        Connection connection = POOL.takeConnection();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_VIEW_ALL_BOOKS)){
            Author author;
            while (resultSet.next()) {
                author = new Author(resultSet.getLong(1),
                        resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getString(4), resultSet.getString(5));
                authors.add(author);
            }
        } catch (SQLException e){
            throw new DAOException("Exception is occurred during finding total amount.", e);
        } finally {
            returnConnectionToThePool(connection);
        }
        return authors.toArray(new Author[authors.size()]);
    }

    @Override
    public Author getAuthor(long id) throws DAOException {
        Author author = new Author();
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_VIEW_AUTHOR_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                author = new Author(resultSet.getLong(1),
                        resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getString(4), resultSet.getString(5));
            }
        } catch (SQLException e){
            throw new DAOException("Exception is occurred during finding author by id .", e);
        } finally {
            returnConnectionToThePool(connection);
        }
        return author;
    }

    @Override
    public void deleteAuthor(long authorId) throws DAOException {
        Connection connection = POOL.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_AUTHOR)) {
            preparedStatement.setLong(1, authorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Exception is occurred during deleting author.", e);
        } finally {
            returnConnectionToThePool(connection);
        }
    }

}
