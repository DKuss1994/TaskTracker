package org.example.SQL;


import org.example.SQL.Interface.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionProvider implements ConnectionProvider {
    @Override
    public Connection getConnection() throws SQLException {
        String url = readEnv("DB_URL");
        String user = readEnv("DB_USER");
        String password = readEnv("DB_PASSWORD");
        return DriverManager.getConnection(
                url,
                user,
                password);
    }
    private String readEnv(String key){
        String value = System.getenv(key);
        if(value == null|| value.isEmpty()){
            throw new IllegalArgumentException("Environment variable is missing" + key);
        }
        return value;
    }
}
