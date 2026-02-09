package org.example.Task;

import org.example.Enum.Enum;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String description;
    private org.example.Enum.Enum.Status status;
    private Timestamp time;
    private Timestamp update;

    public Task(String description, Enum.Status status, Timestamp time, Timestamp update) {
        this.description = description;
        this.status = status;
        this.time = time;
        this.update = update;
    }

    public Task(String description) {
        this.description = description;
        this.status = org.example.Enum.Enum.Status.TODO;
    }
    public Timestamp getTime(){
        return this.time;
    }
    public Timestamp getUpdate(){
        return this.update;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public org.example.Enum.Enum.Status getStatus() {
        return status;
    }

    public void setStatus(org.example.Enum.Enum.Status status) {
        this.status = status;
    }

    public String getPrintout() {
        return "Description: " + description + ", Status: " + status + ", Create Time: " + time + ", Last change time: " + update;
    }

    public void setTime() {

        this.time = Timestamp.valueOf(LocalDateTime.now());
    }

    public void setUpdate() {
        this.update = Timestamp.valueOf(LocalDateTime.now());
    }

}
