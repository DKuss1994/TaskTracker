package org.example;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SystemManager {
    private final Scanner sc = new Scanner(System.in);
    private final UserQuestions userQuestions = new UserQuestions(sc);
    private final TaskManager taskManager = new TaskManager();
    private boolean loop = true;
    private static final Path FILE = Path.of("tasks.json");

    public void start() {
        loadTasks();
        while (loop) {
            Enum.Action action = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
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
        Enum.Action action = userQuestions.userAction("Do u want change Status ?(YES/NO)");
        if (Objects.requireNonNull(action) == Enum.Action.YES) {
            extractedChangeStatus(key);
        }
    }


    private void extractedChangeStatus(int key) {
        Enum.Status status = userQuestions.userStatusDescription("Description about Status.(DONE,PROGRESS,TODO) ");
        taskManager.changeStatus(key, status);

    }

    public void exit() {
        shutdown();
        this.loop = false;
    }

    private void showTasks() {
        Map<Integer, Task> allTask = taskManager.getAllTask();
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
            Enum.Status status = userQuestions.userStatusDescription("What do u want see? Status: (DONE,PROGRESS,TODO) or (ALL) ");
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
        Map<Integer, Task> allTask = taskManager.getAllTask();
        if (allTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (int key : allTask.keySet()) {
                if (taskManager.getTask(key).getStatus() == Enum.Status.TODO) {
                    System.out.println("Key: " + key + " Task: " + allTask.get(key).getPrintout());
                }
            }
        }

    }

    private void showDONE() {
        Map<Integer, Task> allTask = taskManager.getAllTask();
        if (allTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (int key : allTask.keySet()) {
                if (taskManager.getTask(key).getStatus() == Enum.Status.DONE) {
                    System.out.println("Key: " + key + " Task: " + allTask.get(key).getPrintout());
                }
            }
        }

    }

    private void showPROGRESS() {
        Map<Integer, Task> allTask = taskManager.getAllTask();
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
    private void loadTasks() {
        if (!Files.exists(FILE)) {
            return;
        }

        try {
            String content = Files.readString(FILE);
            JSONObject root = new JSONObject(content);

            Map<Integer, Task> map = new HashMap<>();

            for (String key : root.keySet()) {
                int id = Integer.parseInt(key);
                Task task = Task.fromJson(root.getJSONObject(key));
                map.put(id, task);
            }

            taskManager.setTaskMap(map);

        } catch (Exception e) {
            System.out.println("Failed load!");
        }
    }

    public void shutdown() {
        saveTasks();
    }

    private void saveTasks() {
        JSONObject root = new JSONObject();

        try {
            for (Map.Entry<Integer, Task> entry : taskManager.getAllTask().entrySet()) {
                root.put(
                        String.valueOf(entry.getKey()),
                        entry.getValue().toJson()
                );
            }

            Files.writeString(FILE, root.toString(4));

        } catch (Exception e) {
            System.out.println("Failed save.");
        }
    }
}

