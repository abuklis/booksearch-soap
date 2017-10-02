package by.bsu.booksearchsoap.service;

import by.bsu.booksearchsoap.dao.DAOException;
import by.bsu.booksearchsoap.dao.IAuthorDAO;
import by.bsu.booksearchsoap.dao.impl.MySQLAuthorDAO;
import by.bsu.booksearchsoap.entity.Author;

import javax.jws.WebService;
import java.util.ArrayList;

/**
 * Created by anyab on 27.09.2017.
 */
@WebService(endpointInterface = "by.bsu.booksearchsoap.service.IAuthorService")
public class AuthorServiceImpl implements IAuthorService{

    private static final IAuthorDAO AUTHOR_DAO = new MySQLAuthorDAO();

    public Author[] viewAllAuthors() throws ServiceException {
        Author[] authors;
        try{
            authors = AUTHOR_DAO.viewAllAuthors();
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
        return authors;
    }

    public Author findAuthorById(long id) throws ServiceException{
        Author author;
        try {
            author =  AUTHOR_DAO.getAuthor(id);
        } catch (DAOException e) {
            throw new ServiceException("Exception is occurred", e);
        }
        return author;
    }

    public void addAuthor(Author author) throws ServiceException{
        try {
            AUTHOR_DAO.addAuthor(author);
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
    }

    public void deleteAuthor(long id) throws ServiceException{
        try {
            AUTHOR_DAO.deleteAuthor(id);
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
    }

    public void updateAuthor(Author author) throws ServiceException{
        try {
            AUTHOR_DAO.updateAuthor(author);
        } catch (DAOException e){
            throw new ServiceException("Exception is occurred", e);
        }
    }
}
