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
            switch (action) {
                case ADD -> extractedAddUserDescription();
                case DELETE -> extractedDeleteUserKey();
                case SHOW -> extractedShow();
                case EXIT -> exit();
            }

/*

            //Json Safe.
        }*/
        }
    }
    public void exit(){
        this.loop = false;
    }
private  void extractedShow(){
        try {
            taskManager.showTasks();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
        private void extractedAddUserDescription () {
            try {
                String description = userQuestions.userDescription();
                taskManager.add(description);
                System.out.println("Task successfully added");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        private void extractedDeleteUserKey () {
            try {
                taskManager.showTasks();
                int keyNumber = userQuestions.userKeyDelete();
                taskManager.delete(keyNumber);
                System.out.println("Key: " + keyNumber + " successful delete.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }


            System.out.println("Number not found. Try again.");
        }
    }
