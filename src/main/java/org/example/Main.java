package org.example;

import java.util.Scanner;

class Main{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        taskManager.add("Hello");
        taskManager.add("Bye");
        taskManager.getTaskMap().get(2).setStatus(Enum.Status.DONE);
        taskManager.showTasks();
        taskManager.delete(1);
        taskManager.add("HEELO");
        taskManager.showTasks();

    }
}
