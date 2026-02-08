package org.example.Task.Interface;

import org.example.Task.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findTasksByUserId(int userID);
}
