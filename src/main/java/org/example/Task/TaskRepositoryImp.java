package org.example.Task;

import org.example.Enum.Enum;
import org.example.SQL.Interface.DatabaseConnection;
import org.example.Task.Interface.TaskRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImp implements TaskRepository {
    DatabaseConnection databaseConnection;

    public TaskRepositoryImp(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public List<Task> findTasksByUserId(int userID) {
        List<Task> tasks = new ArrayList<>();
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM task WHERE id = ?");
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String description1 = resultSet.getString("description");
                String status = resultSet.getString("status");
                Enum.Status statusEnum = Enum.fromDb(status);
                Timestamp time = resultSet.getTimestamp("time");
                Timestamp updateTime = resultSet.getTimestamp("updateTime");
                Task description = new Task(description1, statusEnum, time, updateTime);
                tasks.add(description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public void addTaskDB(int userID, Task task) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO task (status,description,time,updateTime,id) VALUES('?','?''?','?','?')");
            statement.setString(1, String.valueOf(task.getStatus()));
            statement.setString(2,task.getDescription());
            statement.setTimestamp(3,task.getTime());
            statement.setTimestamp(4,task.getUpdate());
            statement.setInt(5,userID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
