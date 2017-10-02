package by.bsu.booksearchsoap.service;

import by.bsu.booksearchsoap.dao.DAOException;
import by.bsu.booksearchsoap.dao.IBookDAO;
import by.bsu.booksearchsoap.dao.impl.MySQLBookDAO;
import by.bsu.booksearchsoap.entity.Book;
import by.bsu.booksearchsoap.entity.BookDTO;

import javax.jws.WebService;

/**
 * Created by anyab on 16.09.2017.
 */

@WebService(endpointInterface = "by.bsu.booksearchsoap.service.IBookService")
public class BookServiceImpl implements IBookService {
    private static final IBookDAO BOOK_DAO = new MySQLBookDAO();

    public Book[] viewAllBooks() throws ServiceException {
        Book[] books;
        try{
            books = BOOK_DAO.viewAllBooks();
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
        return books;
    }

    public Book findBookById(long id) throws ServiceException{
        Book book;
        try {
            book =  BOOK_DAO.getBook(id);
        } catch (DAOException e) {
            throw new ServiceException("Exception is occurred", e);
        }
        return book;
    }

    public void addBook(BookDTO bookDTO) throws ServiceException{
        try {
            BOOK_DAO.addBook(bookDTO);
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
    }

    public void deleteBook(long bookId) throws ServiceException{
        try {
            BOOK_DAO.deleteBook(bookId);
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
    }

    public void updateBook(BookDTO bookDTO) throws ServiceException{
        try {
            BOOK_DAO.updateBook(bookDTO);
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
    }
}
