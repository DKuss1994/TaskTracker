package org.example.Login;

import org.example.Login.Interface.UserRepository;
import org.example.SQL.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUserRepository implements UserRepository {
    private DatabaseConnection databaseConnection;
    SqlUserRepository(DatabaseConnection databaseConnection){
        this.databaseConnection = databaseConnection;
    }
    @Override
    public User findePasswordUserIDByUserName(String userName) {

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement stmt =connection.prepareStatement(
                    "SELECT" +
                            "*" +
                            "FROM users" +
                            "WHERE userName = ?");
            stmt.setString(1,userName);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            return new User(resultSet.getInt("id"),resultSet.getString("userName"),resultSet.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
