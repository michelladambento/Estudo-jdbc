package com.michell.Estudo_jdbc.database;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;

@Configuration
public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            try{
                InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("application.properties");
                Properties properties = new Properties();
                properties.load(input);
                Class.forName(properties.getProperty("jdbc.driverClassName"));
                connection = DriverManager.getConnection(
                        properties.getProperty("jdbc.url"),
                        properties.getProperty("jdbc.username"),
                        properties.getProperty("jdbc.password")
                );
            }catch (SQLException e){
                throw  new SQLException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
