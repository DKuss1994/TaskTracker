package org.example.Login;

import org.example.Login.Interface.UserRepository;
import org.example.SQL.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUserRepository implements UserRepository {
    private DatabaseConnection databaseConnection;

    public SqlUserRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public User findePasswordUserIDByUserName(String userName) {

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE userName = ?");
            stmt.setString(1, userName);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            return new User(resultSet.getInt("userID"), resultSet.getString("userName"), resultSet.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createANewUserWithHashPassword(String userName, String hashPassword) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    //INSERT INTO users(userID,userName,password,role)
                    //VALUES(1,'Max','123456','Admin');
                    "INSERT INTO users(userName,password) VALUES(?,?)");
            stmt.setString(1, userName);
            stmt.setString(2, hashPassword);
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

