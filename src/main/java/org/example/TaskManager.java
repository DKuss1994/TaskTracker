package org.example;

import java.util.TreeMap;

public class TaskManager {
    private final TreeMap<Integer, Task> taskMap = new TreeMap<>();
    private int id = 0;
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


    public void showTasks() {
        if (taskMap.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (int key : taskMap.keySet()) {
                System.out.println("Key: " + key + " Task: " + taskMap.get(key).getPrintout());
            }
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
}