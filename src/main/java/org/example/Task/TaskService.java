package org.example.Task;

import org.example.Task.Interface.TaskRepository;

import java.util.List;

public class TaskService implements TaskRepository {
    @Override
    public List<Task> findTasksByUserId(int userID) {
        return List.of();
    }
}
