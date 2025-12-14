package org.example;

public class Task {
    private String description;
    private Enum.Status status;
    private String time;
    private String update;
    private String printout;

    public Task(String description){
        this.description = description;
        this.status = Enum.Status.TODO;
        this.time = "12.11.2025";//Muss noch eine classe angelegt werden.
        this.update = "12.11.2025";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum.Status getStatus() {
        return status;
    }

    public void setStatus(Enum.Status status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getPrintout() {
        return "Description: "+description+", Status: "+status+", Create Time: "+time+", Last change time: "+ update;
    }
}
