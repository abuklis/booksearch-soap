package by.bsu.booksearchsoap.dao;

import by.bsu.booksearchsoap.entity.Book;
import by.bsu.booksearchsoap.entity.BookDTO;

/**
 * Created by anyab on 22.09.2017.
 */
public interface IBookDAO extends IDAO {

    void addBook(BookDTO bookDTO) throws DAOException;

    Book[] viewAllBooks() throws DAOException;

    Book getBook(long id) throws DAOException;

    void deleteBook(long id) throws DAOException;

    void updateBook(BookDTO bookDTO) throws DAOException;
}
