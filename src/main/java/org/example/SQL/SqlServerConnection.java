package org.example.SQL;

import org.example.SQL.Interface.ConnectionProvider;
import org.example.SQL.Interface.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlServerConnection implements DatabaseConnection {
    private final ConnectionProvider connectionProvider;
    public SqlServerConnection(ConnectionProvider connectionProvider){
        this.connectionProvider = connectionProvider;
    }
    @Override
    public Connection getConnection(){
        try{
            return connectionProvider.getConnection();

        }
        catch (SQLException e){
            throw new RuntimeException("Connection to the database failed",e);
        }
    }
}
