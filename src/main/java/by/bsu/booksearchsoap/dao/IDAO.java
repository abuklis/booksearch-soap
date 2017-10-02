package by.bsu.booksearchsoap.dao;

import by.bsu.booksearchsoap.dao.pool.ConnectionPool;

import java.sql.Connection;

/**
 * Created by anyab on 23.09.2017.
 */
public interface IDAO {
    default void returnConnectionToThePool(Connection connection){
        if (connection != null){
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }
}
