package org.example;


import org.example.SQL.ConnectionProvider;
import org.example.SQL.DatabaseConnection;
import org.example.SQL.JdbcConnectionProvider;
import org.example.SQL.SqlServerConnection;

public class Main{
    public static void connectionDB(){
        ConnectionProvider connectionProvider = new JdbcConnectionProvider();
        DatabaseConnection databaseConnection = new SqlServerConnection(connectionProvider);
        databaseConnection.getConnection();

    }
   public static void main (String[] args){
        connectionDB();
        SystemManager systemManager = new SystemManager();
        systemManager.start();

    }
}
