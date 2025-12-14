package org.example;

import java.util.TreeMap;

public class TaskManager {
    private final TreeMap<Integer, Task> taskMap = new TreeMap<>();
    private int id = 0;


    TreeMap<Integer, Task> getTaskMap() {
        return taskMap;
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
}


/*
 description: Eine kurze Beschreibung der Aufgabe

status: Der Status der Aufgabe (todo, in-progress, done)

createdAt: Datum und Uhrzeit, zu der die Aufgabe erstellt wurde

updatedAt: Datum und Uhrzeit, zu der die Aufgabe zuletzt aktualisiert wurde

        SEARCH,
        CHANGE,
        INFO,
        SHOW*/
