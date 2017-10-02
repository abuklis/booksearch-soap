package by.bsu.booksearchsoap.dao;

import by.bsu.booksearchsoap.entity.Author;

/**
 * Created by anyab on 23.09.2017.
 */
public interface IAuthorDAO extends IDAO{

    void updateAuthor(Author author) throws DAOException;

    void addAuthor(Author author) throws DAOException;

    Author getAuthor(long id) throws DAOException;

    void deleteAuthor(long id) throws DAOException;

    Author[] viewAllAuthors() throws DAOException;
}
