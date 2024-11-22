package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb1";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final Connection connection;
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .setProperty("hibernate.connection.url", URL)
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.username", USER)
                .setProperty("hibernate.connection.password", PASSWORD)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("show_sql", "true")
                .setProperty("format_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "none")
                .buildSessionFactory();

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}