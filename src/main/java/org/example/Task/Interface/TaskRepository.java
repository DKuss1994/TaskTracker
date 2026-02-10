package org.example.Task.Interface;

import org.example.Enum.Enum;
import org.example.Task.Task;

import java.sql.Timestamp;
import java.util.List;

public interface TaskRepository {
    List<Task> findTasksByUserId(int userID);
    void addTaskDB(int userID,Task task);
    List<Task> findTasksByStatusAndUserId(int userID, Enum.Status status);
    void changeStatusByUserIDAndTaskID(int userID, int taskID,Enum.Status status, Timestamp update);
    void changeTaskByUserIDAndTaskID(int userID, int taskID,String description, Timestamp update);
    Task findeTaskByUserIDAndTaskID(int userID, int taskID);
    void deleteTaskByUserIDAndTaskID(int userID, int taskID);
}
