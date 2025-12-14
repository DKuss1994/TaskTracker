package org.example;

import org.junit.jupiter.api.Test;

public class MainTest {


    @Test
    void Test() {
        TaskManager taskManager = new TaskManager();
        String description = "Hello Task";
        taskManager.add(description);
        taskManager.showTasks();
        description = "Wein";
        taskManager.add(description);
        int keyNumber = 1;
        taskManager.delete(keyNumber);
        taskManager.delete(keyNumber);


    }
}
/*


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
        }*/