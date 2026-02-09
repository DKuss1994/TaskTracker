package org.example.Task;
import org.example.Enum.Enum;
import org.example.Login.User;
import org.example.SQL.JdbcConnectionProvider;
import org.example.SQL.SqlServerConnection;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SystemManager {
    private final Scanner sc = new Scanner(System.in);
    private final UserQuestions userQuestions = new UserQuestions(sc);
    private boolean loop = true;
    private User user;
    private final TaskManager taskManager ;
    public SystemManager(User user){
        this.user = user;

        TaskRepositoryImp taskService = new TaskRepositoryImp(new SqlServerConnection(new JdbcConnectionProvider()));
        this.taskManager = new TaskManager(user, taskService);
    }

    public void start() {
        while (loop) {
            org.example.Enum.Enum.Action action = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
            switch (action) {
                case ADD -> extractedAddUserDescription();
                case CHANGE -> extractedChangeUserDescription();
                case DELETE -> extractedDeleteUserKey();
                case SHOW -> extractedShow();
                case EXIT -> exit();

            }
        }
    }


    public void extractedChangeUserDescription() {
        extractedShow();
        int key = userQuestions.userKey("Take someone of the key number too change the task. ");
        String description = userQuestions.userDescription("What do u want to change? ");


        try {
            taskManager.changeTask(key, description);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        org.example.Enum.Enum.Action action = userQuestions.userAction("Do u want change Status ?(YES/NO)");
        if (Objects.requireNonNull(action) == org.example.Enum.Enum.Action.YES) {
            extractedChangeStatus(key);
        }
    }


    private void extractedChangeStatus(int key) {
        org.example.Enum.Enum.Status status = userQuestions.userStatusDescription("Description about Status.(DONE,PROGRESS,TODO) ");
        taskManager.changeStatus(key, status);

    }

    public void exit() {
        this.loop = false;
    }

    private void showTasks() {
        Map<Integer, Task> allTask = taskManager.getMap();
        if (allTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (int key : allTask.keySet()) {
                System.out.println("Key: " + key + " Task: " + allTask.get(key).getPrintout());
            }
        }
    }

    private void extractedShow() {
        try {
            org.example.Enum.Enum.Status status = userQuestions.userStatusDescription("What do u want see? Status: (DONE,PROGRESS,TODO) or (ALL) ");
            switch (status) {
                case ALL -> showTasks();
                case TODO -> showTODO();
                case DONE -> showDONE();
                case PROGRESS -> showPROGRESS();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showTODO() {
        Map<Integer, Task> allTask = taskManager.getMap();
        if (allTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (int key : allTask.keySet()) {
                if (taskManager.getTask(key).getStatus() == org.example.Enum.Enum.Status.TODO) {
                    System.out.println("Key: " + key + " Task: " + allTask.get(key).getPrintout());
                }
            }
        }

    }

    private void showDONE() {
        Map<Integer, Task> allTask = taskManager.getMap();
        if (allTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (int key : allTask.keySet()) {
                if (taskManager.getTask(key).getStatus() == org.example.Enum.Enum.Status.DONE) {
                    System.out.println("Key: " + key + " Task: " + allTask.get(key).getPrintout());
                }
            }
        }

    }

    private void showPROGRESS() {
        Map<Integer, Task> allTask = taskManager.getMap();
        if (allTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (int key : allTask.keySet()) {
                if (taskManager.getTask(key).getStatus() == Enum.Status.PROGRESS) {
                    System.out.println("Key: " + key + " Task: " + allTask.get(key).getPrintout());
                }
            }
        }

    }

    private void extractedAddUserDescription() {

        String description = userQuestions.userDescription("Description about it. ");
        try {
            taskManager.add(description);
            System.out.println("Task successfully added");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void extractedDeleteUserKey() {
        try {
            showTasks();
            int keyNumber = userQuestions.userKey("Take someone of the key number too delete the task ");
            taskManager.delete(keyNumber);
            System.out.println("Key: " + keyNumber + " successful delete.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Number not found. Try again.");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

