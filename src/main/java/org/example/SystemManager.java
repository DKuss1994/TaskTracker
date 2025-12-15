package org.example;

import java.util.Objects;
import java.util.Scanner;

public class SystemManager {
    private final Scanner sc = new Scanner(System.in);
    private final UserQuestions userQuestions = new UserQuestions(sc);
    private final TaskManager taskManager = new TaskManager();
    private boolean loop = true;

    public void start() {
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


    private void extractedChangeStatus(int key){
        Enum.Status status = userQuestions.userStatusDescription("Description about Status.(DONE,PROGRESS,TODO) ");
        taskManager.changeStatus(key,status);

    }

    public void exit() {
        this.loop = false;
    }

    private void extractedShow() {
        try {
            userQuestions.userStatusDescription("What do u want see? Status: (DONE,PROGRESS,TODO) or (ALL) ");

            taskManager.showTasks();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            taskManager.showTasks();
            int keyNumber = userQuestions.userKey("Take someone of the key number too delete the task ");
            taskManager.delete(keyNumber);
            System.out.println("Key: " + keyNumber + " successful delete.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Number not found. Try again.");
    }
}
