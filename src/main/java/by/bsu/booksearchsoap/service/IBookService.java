package by.bsu.booksearchsoap.service;


import by.bsu.booksearchsoap.entity.Book;
import by.bsu.booksearchsoap.entity.BookDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * Created by anyab on 16.09.2017.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IBookService {

    @WebMethod
    Book[] viewAllBooks() throws ServiceException;

    @WebMethod
    Book findBookById(long id) throws ServiceException;

    @WebMethod
    void addBook(BookDTO bookDTO) throws ServiceException;

    @WebMethod
    void deleteBook(long id) throws ServiceException;

    @WebMethod
    void updateBook(BookDTO bookDTO) throws ServiceException;

}
