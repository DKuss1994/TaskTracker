package org.example.Task.Interface;

import org.example.Task.Task;

import java.util.ArrayList;
import java.util.List;

public class FakeTaskRepositoryMoreTask implements TaskRepository {
    @Override
    public List<Task> findTasksByUserId(int userID) {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("Cook water");
        Task task2 = new Task("Cook milk");
        taskList.add(task);
        taskList.add(task2);
        return taskList;
    }
}
