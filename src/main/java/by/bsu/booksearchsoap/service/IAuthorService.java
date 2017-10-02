package by.bsu.booksearchsoap.service;

import by.bsu.booksearchsoap.entity.Author;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by anyab on 27.09.2017.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IAuthorService {

    @WebMethod
    Author[] viewAllAuthors() throws ServiceException;

    @WebMethod
    Author findAuthorById(long id) throws ServiceException;

    @WebMethod
    void addAuthor(Author author) throws ServiceException;

    @WebMethod
    void deleteAuthor(long id) throws ServiceException;

    @WebMethod
    void updateAuthor(Author author) throws ServiceException;

}
