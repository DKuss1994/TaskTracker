package org.example.Task.Interface;

import org.example.Enum.Enum;
import org.example.Task.Task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeTaskRepository implements TaskRepository {
    private final Map<Integer, List<Task>> data = new HashMap<>();
    @Override
    public List<Task> findTasksByUserId(int userID) {
        return data.getOrDefault(userID, new ArrayList<>());
    }

    @Override
    public void addTaskDB(int userID, Task task) {
            data.computeIfAbsent(userID, k -> new ArrayList<>()).add(task);

    }
}
