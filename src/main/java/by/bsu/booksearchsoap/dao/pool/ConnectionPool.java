package by.bsu.booksearchsoap.dao.pool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by anyab on 23.09.2017.
 */
public class ConnectionPool {
    private BlockingQueue<Connection> availableConnectionsQueue;
    private BlockingQueue<Connection> usedConnectionsQueue;
    private int connectionAmount;
    private static final String KEY_BUNDLE = "db";
    private static final String KEY_URL = "DB_URL";
    private static final String KEY_USER = "DB_USERNAME";
    private static final String KEY_PASSWORD = "DB_PASSWORD";
    private static final String KEY_LOCATION_OF_DRIVER = "DB_DRIVER_CLASS";
    private static final String KEY_CONNECTION_AMOUNT = "DB_CONNECTION_AMOUNT";
    private static final int DEFAULT_AMOUNT = 5;
    private static ReentrantLock lock = new ReentrantLock();

    private static ConnectionPool instance;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    public static ConnectionPool getInstance() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    instanceCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    private ConnectionPool() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(KEY_BUNDLE);
            String url = bundle.getString(KEY_URL);
            String user = bundle.getString(KEY_USER);
            String password = bundle.getString(KEY_PASSWORD);
            String locationOfDriver = bundle.getString(KEY_LOCATION_OF_DRIVER);
            try {
                this.connectionAmount = Integer.parseInt(bundle.getString(KEY_CONNECTION_AMOUNT));
            } catch (NumberFormatException e) {
                this.connectionAmount = DEFAULT_AMOUNT;
            }
            this.availableConnectionsQueue = new ArrayBlockingQueue<>(connectionAmount);
            this.usedConnectionsQueue = new ArrayBlockingQueue<>(connectionAmount);
            logger.info("Trying to create connection pool");
            try {
                Class.forName(locationOfDriver);
                for (int i = 0; i < connectionAmount; i++) {
                    Connection connection = DriverManager.getConnection(url, user, password);
                    availableConnectionsQueue.put(connection);
                    logger.info("Connection " + i + " is created and put into the queue.");
                }
            } catch (ClassNotFoundException e) {
                logger.fatal(locationOfDriver + " driver not found", e);
                throw new RuntimeException(locationOfDriver + " driver not found", e);
            } catch (SQLException | InterruptedException e) {
                throw new ConnectionPoolException("SQL or InterruptedException is occurred in ConnectionPool", e);
            }
        } catch (MissingResourceException e) {
            logger.fatal("Resource bundle not found. ");
            throw new RuntimeException("Resource bundle not found.", e);
        } catch (ConnectionPoolException e) {
            logger.fatal("Wrong init of connection pool.");
            throw new RuntimeException("JDBC: Wrong init of connection pool class.", e);
        }
    }

    public Connection takeConnection(){
        Connection connection = null;
        try {
            connection = availableConnectionsQueue.take();
            try {
                if (connection != null && !connection.isClosed()) {
                    usedConnectionsQueue.put(connection);
                } else {
                    ResourceBundle bundle = ResourceBundle.getBundle(KEY_BUNDLE);
                    String url = bundle.getString(KEY_URL);
                    String user = bundle.getString(KEY_USER);
                    String password = bundle.getString(KEY_PASSWORD);
                    connection = DriverManager.getConnection(url, user, password);
                    usedConnectionsQueue.put(connection);
                }
            } catch (SQLException e){
                logger.error("SQLException is occurred.", e);
            }
        } catch (InterruptedException e) {
            logger.error("Time is out. Cannot take connection from the pool.", e);
        }
        return connection;
    }

    public void returnConnection(Connection connection) {
        try {
            availableConnectionsQueue.put(connection);
            usedConnectionsQueue.remove(connection);
        } catch (InterruptedException e) {
            logger.error("Time is out. Cannot put connection into the pool.", e);
        }
    }

    public void destroyConnectionPool() throws ConnectionPoolException {
        try {
            for (int i = 0; i < availableConnectionsQueue.size(); i++) {
                Connection connection = ConnectionPool.getInstance().takeConnection();
                connection.close();
                logger.info("Connection " + i + " is destroyed.");
            }
            logger.info("Connections destroyed.");
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                logger.info("Deregistering jdbc driver: " + driver);
                DriverManager.deregisterDriver(driver);
                logger.info("Deregistered.");
            }
        }catch (SQLException e) {
            logger.warn("Exception in destroy connection pool.", e);
            throw new ConnectionPoolException("Exception is occurred during destroying connection pool", e);
        }
    }
}
