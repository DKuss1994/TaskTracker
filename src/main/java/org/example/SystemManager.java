package org.example;

import java.util.Scanner;

public class SystemManager {
    Scanner sc = new Scanner(System.in);
    UserQuestions userQuestions = new UserQuestions(sc);
    TaskManager taskManager = new TaskManager();

    public void start() {
        while (true) {


            Enum.Action action = userQuestions.userAction();
            if (action == Enum.Action.ADD) {
                String description = userQuestions.userDescription();
                taskManager.add(description);
            } else if (action == Enum.Action.SHOW) {
                taskManager.showTasks();
            } else if (action == Enum.Action.DELETE) {
                int keyNumber = userQuestions.userKeyDelete();
                taskManager.delete(keyNumber);
            } else if (action == Enum.Action.EXIT) {
                break;
                //Json Safe.
            }
        }
    }
}