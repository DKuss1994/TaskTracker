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
    private int autoIncrement = 1;
    @Override
    public List<Task> findTasksByUserId(int userID) {
        return data.getOrDefault(userID, new ArrayList<>());
    }

    @Override
    public void addTaskDB(int userID, Task task) {
        if(task.getTaskID() == 0){
            task.setTaskID(autoIncrement++);
        }
            data.computeIfAbsent(userID, k -> new ArrayList<>()).add(task);

    }

    @Override
    public List<Task> findTasksByStatusAndUserId(int userID, Enum.Status status) {
        return findTasksByUserId(userID).stream()
                .filter(t->t.getStatus()==status)
                .toList();
    }

    @Override
    public void changeStatusByUserIDAndTaskID(int userID, int taskID, Enum.Status status, Timestamp update) {
        Task task = findeTaskByUserIDAndTaskID(userID,taskID);
        if(task!=null){
            task.setStatus(status);
            task.setUpdate(update);
        }

    }

    @Override
    public void changeTaskByUserIDAndTaskID(int userID, int taskID, String description, Timestamp update) {
        Task task = findeTaskByUserIDAndTaskID(userID,taskID);
        if(task != null){
            task.setDescription(description);
            task.setUpdate(update);
        }
    }

    @Override
    public Task findeTaskByUserIDAndTaskID(int userID, int taskID) {
        return findTasksByUserId(userID).stream().filter(t->t.getTaskID()==taskID).findFirst()
                .orElse(null);
    }

    @Override
    public void deleteTaskByUserIDAndTaskID(int userID, int taskID) {
        List<Task> tasks = findTasksByUserId(userID);
        if (tasks!= null){
            tasks.removeIf(t->t.getTaskID()==taskID);
        }
        if(tasks == null){
            data.remove(userID);
        }

    }


}
