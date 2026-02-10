package org.example.Task;

import org.example.Enum.TaskEnum;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Task {
    private String description;
    private TaskEnum.Status status;
    private Timestamp time;
    private Timestamp update;
    private int taskID;

    public Task(String description, TaskEnum.Status status, Timestamp time, Timestamp update, int taskID) {
        this.description = description;
        this.status = status;
        this.time = time;
        this.update = update;
        this.taskID = taskID;
    }

    public Task(String description) {
        this.description = description;
        this.status = TaskEnum.Status.TODO;
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

    public TaskEnum.Status getStatus() {
        return status;
    }

    public void setStatus(TaskEnum.Status status) {
        this.status = status;
    }

    public String getPrintout() {
        return "TaskID: "+taskID+", Description: " + description + ", Status: " + status + ", Create Time: " + time + ", Last change time: " + update;
    }

    public void setTime() {

        this.time = Timestamp.valueOf(LocalDateTime.now());
    }

    public void setUpdate() {
        this.update = Timestamp.valueOf(LocalDateTime.now());
    }

    public void setUpdate(Timestamp time) {
        this.update = time;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getTaskID() {
        return taskID;
    }
}
