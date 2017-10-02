/**
 * IAuthorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package by.bsu.booksearchsoap.client;

public interface IAuthorService extends java.rmi.Remote {
    public by.bsu.booksearchsoap.client.Author[] viewAllAuthors() throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public void deleteAuthor(long arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public by.bsu.booksearchsoap.client.Author findAuthorById(long arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public void addAuthor(by.bsu.booksearchsoap.client.Author arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
    public void updateAuthor(by.bsu.booksearchsoap.client.Author arg0) throws java.rmi.RemoteException, by.bsu.booksearchsoap.client.ServiceException;
}
