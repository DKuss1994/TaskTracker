package org.example.Task;

import org.example.Enum.TaskEnum;
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
                TaskEnum.Status statusEnum = TaskEnum.fromDb(status);
                Timestamp time = resultSet.getTimestamp("time");
                Timestamp updateTime = resultSet.getTimestamp("updateTime");
                int taskID = resultSet.getInt("taskID");
                Task description = new Task(description1, statusEnum, time, updateTime, taskID);
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
                    ("INSERT INTO task (status,description,time,updateTime,id) VALUES(?,?,?,?,?)");
            statement.setString(1, String.valueOf(task.getStatus()));
            statement.setString(2, task.getDescription());
            statement.setTimestamp(3, task.getTime());
            statement.setTimestamp(4, task.getUpdate());
            statement.setInt(5, userID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Task> findTasksByStatusAndUserId(int userID, TaskEnum.Status status) {
        List<Task> tasks = new ArrayList<>();
        String statusString = status.toString();
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM task WHERE status = ? AND id = ?");
            statement.setString(1, statusString);
            statement.setInt(2, userID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String description1 = resultSet.getString("description");
                String statusDB = resultSet.getString("status");
                TaskEnum.Status statusEnum = TaskEnum.fromDb(statusDB);
                Timestamp time = resultSet.getTimestamp("time");
                Timestamp updateTime = resultSet.getTimestamp("updateTime");
                int taskID = resultSet.getInt("taskID");
                Task description = new Task(description1, statusEnum, time, updateTime, taskID);
                tasks.add(description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public void changeStatusByUserIDAndTaskID(int userID, int taskID, TaskEnum.Status status, Timestamp update) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("UPDATE task SET status = ?,updateTime = ? WHERE id = ? AND taskID = ?");
            statement.setString(1, String.valueOf(status));
            statement.setTimestamp(2, update);
            statement.setInt(3, userID);
            statement.setInt(4, taskID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeTaskByUserIDAndTaskID(int userID, int taskID, String description, Timestamp update) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("UPDATE task SET description = ?,updateTime = ? WHERE id = ? AND taskID = ?");
            statement.setString(1, description);
            statement.setTimestamp(2, update);
            statement.setInt(3, userID);
            statement.setInt(4, taskID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task findeTaskByUserIDAndTaskID(int userID, int taskID) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM task WHERE taskID = ? AND id = ?");
            statement.setInt(1, taskID);
            statement.setInt(2, userID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                String description1 = resultSet.getString("description");
                String statusDB = resultSet.getString("status");
                TaskEnum.Status statusEnum = TaskEnum.fromDb(statusDB);
                Timestamp time = resultSet.getTimestamp("time");
                Timestamp updateTime = resultSet.getTimestamp("updateTime");
                int taskID1 = resultSet.getInt("taskID");
                return new Task(description1, statusEnum, time, updateTime, taskID1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTaskByUserIDAndTaskID(int userID, int taskID) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("DELETE FROM task WHERE id = ? AND taskID = ?");
            statement.setInt(1,userID);
            statement.setInt(2,taskID);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
