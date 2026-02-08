package org.example.Task;

import org.example.Enum.Enum;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String description;
    private org.example.Enum.Enum.Status status;
    private String time;
    private String update;

    private Task(String description, org.example.Enum.Enum.Status status, String time, String update) {
        this.description = description;
        this.status = status;
        this.time = time;
        this.update = update;
    }

    public Task(String description) {
        this.description = description;
        this.status = org.example.Enum.Enum.Status.TODO;
        this.time = "";
        this.update = "";
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
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        this.time = nowTime.format(formatter);
    }

    public void setUpdate() {
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        this.update = nowTime.format(formatter);
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("description", description);
        json.put("status", status.name());
        json.put("time", time);
        json.put("update", update);
        return json;
    }

    public static Task fromJson(JSONObject json) {
        return new Task(
                json.getString("description"),
                Enum.Status.valueOf(json.getString("status")),
                json.getString("time"),
                json.getString("update"));
    }
}
