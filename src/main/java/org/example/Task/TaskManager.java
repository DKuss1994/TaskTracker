package org.example.Task;

import org.example.Enum.Enum;
import org.example.Login.User;
import org.example.Task.Interface.TaskRepository;

import java.util.Map;
import java.util.TreeMap;

public class TaskManager {
    private TreeMap<Integer, Task> taskMap = new TreeMap<>();
    private int id = 0;
    private int userID;
    private TaskRepository taskRepository;
    public TaskManager(User user,TaskRepository taskRepository){
        this.userID = user.getId();
        this.taskRepository = taskRepository;
    }

    public TaskManager() {

    }

    public Map<Integer,Task> getMap(){
        return this.taskMap;
    }
    public int mapSize(){
        return taskMap.size();
    }
    public Task getTask(int key){
        return taskMap.get(key);
    }
    public boolean containsKey (int key){
        return taskMap.containsKey(key);
    }

    public void add(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description invalid.");
        }
        Task task = new Task(description);
        task.setTime();
        task.setUpdate();
        id++;
        taskMap.put(id, task);

    }

    public void delete(int key) {
        if (taskMap.containsKey(key)) {
            taskMap.remove(key);
        } else {
            throw new IllegalArgumentException("Description invalid");
        }
    }


    public void changeTask(int key, String description) {
        Task task = taskMap.get(key);
        if (task == null) {
            throw new IllegalArgumentException("Key not found");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description invalid");
        }
        task.setDescription(description);
        task.setUpdate();
    }
    public void changeStatus(int key, Enum.Status status){
        taskMap.get(key).setStatus(status);
        taskMap.get(key).setUpdate();

    }
    public void setTaskMap(Map<Integer, Task> map) {
        taskMap = new TreeMap<>(map);

        int maxId = 0;
        for (int id : taskMap.keySet()) {
            if (id > maxId) {
                maxId = id;
            }
        }
        this.id = maxId;
    }

    public int getUserID() {
        return userID;
    }
}
