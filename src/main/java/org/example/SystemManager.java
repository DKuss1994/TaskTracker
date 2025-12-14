package org.example;

import java.util.Scanner;

public class SystemManager {
    private final Scanner sc = new Scanner(System.in);
    private final UserQuestions userQuestions = new UserQuestions(sc);
    private final TaskManager taskManager = new TaskManager();
    private boolean loop = true;

    public void start() {
        while (loop) {
            Enum.Action action = userQuestions.userAction();
            if (action == Enum.Action.ADD) {
                extractedAddUserDescription();
            } else if (action == Enum.Action.DELETE) {
                extractedDeleteUserKey();

            } else if (action == Enum.Action.CHANGE) {
                extractedChangeUserDescription();

            } else if (action == Enum.Action.EXIT) {
                exit();
            } else if (action == Enum.Action.SHOW) {
                extractedShow();

            } else {
                System.out.println("Someone go wrong!");
            }
        }

    }

public void extractedChangeUserDescription(){
        extractedShow();
    int key = userQuestions.userKey("Take someone of the key number too change the task. ");
        String description = userQuestions.userDescription("What do u want to change? ");
        try {
            taskManager.changeTask(key,description);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
}
    public void exit() {
        this.loop = false;
    }

    private void extractedShow() {
        try {
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
