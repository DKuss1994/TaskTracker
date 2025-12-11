package org.example;

import java.util.ArrayList;
import java.util.TreeMap;

public class TaskManager extends Enum {
    private final TreeMap<Integer, Task> taskMap = new TreeMap<>();
    private int id = 0;


    public TreeMap<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void add(String description) {
        Task task = new Task(description);
        id++;
        taskMap.put(id, task);
    }

    public void delete(int key) {

    }
}

/*
 description: Eine kurze Beschreibung der Aufgabe

status: Der Status der Aufgabe (todo, in-progress, done)

createdAt: Datum und Uhrzeit, zu der die Aufgabe erstellt wurde

updatedAt: Datum und Uhrzeit, zu der die Aufgabe zuletzt aktualisiert wurde
 ADD,
        DELETE,
        SEARCH,
        CHANGE,
        EXIT,
        INFO,
        SHOW*/
