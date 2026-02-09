package org.example.Task.Interface;

import org.example.Task.Task;

import java.util.ArrayList;
import java.util.List;

public class FakeTaskRepository implements TaskRepository {
    @Override
    public List<Task> findTasksByUserId(int userID) {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("Cook water");
        taskList.add(task);
        return taskList;
    }
}
