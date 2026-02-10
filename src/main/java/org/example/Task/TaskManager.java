package org.example.Task;

import org.example.Enum.Enum;
import org.example.Login.User;
import org.example.Task.Interface.TaskRepository;

import java.util.List;

public class TaskManager {
    private int userID;
    private TaskRepository taskRepository;
    public TaskManager(User user,TaskRepository taskRepository){
        this.userID = user.id();
        this.taskRepository = taskRepository;
    }

    public TaskManager() {

    }

    public void add(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description invalid.");
        }
        Task task = new Task(description);
        task.setTime();
        task.setUpdate();
        taskRepository.addTaskDB(userID,task);
    }


    public void delete(int userID,int taskID) {
        Task task = taskRepository.findeTaskByUserIDAndTaskID(userID, taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        taskRepository.deleteTaskByUserIDAndTaskID(userID,taskID);

    }
    public void changeTask(int userID, int taskID, String description) {

        Task task = taskRepository.findeTaskByUserIDAndTaskID(userID,taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description invalid");
        }
        task.setUpdate();
        taskRepository.changeTaskByUserIDAndTaskID(userID,taskID,description,task.getUpdate());



        task.setDescription(description);
    }
    public void changeStatus(int userID, int taskID, Enum.Status status){
        Task task = taskRepository.findeTaskByUserIDAndTaskID(userID,taskID);
        if(task == null){
            throw new IllegalArgumentException("Task not Found");
        }
        if(status == null){
            throw new IllegalArgumentException("Status invalide");
        }
        task.setUpdate();
        taskRepository.changeStatusByUserIDAndTaskID(userID,taskID,status,task.getUpdate());

    }

    public List<Task> getAllTask(){
        return taskRepository.findTasksByUserId(userID);
    }
    public List<Task> getStatusTask(Enum.Status status){
        return taskRepository.findTasksByStatusAndUserId(userID, status);
    }

    public int getUserID() {
        return userID;
    }
}
