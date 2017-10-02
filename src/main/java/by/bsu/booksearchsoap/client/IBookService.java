/**
 * IBookService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package by.bsu.booksearchsoap.client;

public interface IBookService extends java.rmi.Remote {
    public by.bsu.booksearchsoap.client.Book[] viewAllBooks() throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public void deleteBook(long arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public void updateBook(by.bsu.booksearchsoap.client.BookDTO arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public void addBook(by.bsu.booksearchsoap.client.BookDTO arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public by.bsu.booksearchsoap.client.Book findBookById(long arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
}
