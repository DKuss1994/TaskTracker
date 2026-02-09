package org.example.Task.Interface;

import org.example.Enum.Enum;
import org.example.Task.Task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FakeTaskRepositoryMoreTask implements TaskRepository {
    @Override
    public List<Task> findTasksByUserId(int userID) {
        List<Task> taskList = new ArrayList<>();

        Timestamp timestamp = Timestamp.valueOf("2026-12-12 10:12:58");
        Task task = new Task("Cook water", Enum.Status.DONE,timestamp,timestamp);
        Task task2 = new Task("Cook milk", Enum.Status.DONE,timestamp,timestamp);
        taskList.add(task);
        taskList.add(task2);
        return taskList;
    }

    @Override
    public void addTaskDB(int userID, Task task) {

    }
}
