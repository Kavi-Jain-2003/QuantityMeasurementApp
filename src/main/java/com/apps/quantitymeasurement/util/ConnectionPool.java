package com.apps.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.InputStream;

public class ConnectionPool {

    private String url;
    private String username;
    private String password;
    private String driver;

    public ConnectionPool() {

        try {

            Properties props = new Properties();

            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("application.properties");

            props.load(input);

            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
            driver = props.getProperty("db.driver");

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url, username, password);

            initializeDatabase(connection); // ⭐ create table

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void initializeDatabase(Connection connection) {
        try {
            InputStream input = getClass().getClassLoader()
                    .getResourceAsStream("db/schema.sql");

            String sql = new String(input.readAllBytes());

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
