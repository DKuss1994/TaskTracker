package org.example.Task;

import org.example.Enum.Enum;
import org.example.SQL.Interface.DatabaseConnection;
import org.example.SQL.SqlServerConnection;
import org.example.Task.Interface.TaskRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskService implements TaskRepository {
    DatabaseConnection databaseConnection;
    StringBuilder st = new StringBuilder();

    public TaskService(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public List<Task> findTasksByUserId(int userID) {
        List<Task> tasks = new ArrayList<>();
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT description FROM task WHERE id = ?");
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String description1 = resultSet.getString("description");
                String status = resultSet.getString("status");
                Enum.Status statusEnum = Enum.Status.valueOf(status);
                String time = resultSet.getString("time");
                String updateTime = resultSet.getString("updateTime");
                Task description = new Task(description1,statusEnum,time,updateTime);
                tasks.add(description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
