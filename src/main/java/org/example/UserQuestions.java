package org.example;

import java.awt.*;
import java.util.Scanner;

import org.example.Enum;


public class UserQuestions {
    private final Scanner sc;
    TaskManager taskManager = new TaskManager();


    public UserQuestions(Scanner sc) {
        this.sc = sc;
    }

    public Enum.Action userAction() {
        while (true) {
            System.out.print("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
            String input = sc.nextLine().trim().toUpperCase();
            try {
                return Enum.Action.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }
        }
    }



    public String userDescription() {
        System.out.println("Description about it. ");
        return sc.nextLine().trim();
    }



    public Enum.Status userStatusDescription() {
        while (true) {
            System.out.print("Description about Status.(DONE,PROGRESS,TODO) ");
            String input = sc.nextLine().trim().toUpperCase();
            try {
                return Enum.Status.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }
        }
    }



    public int userKeyDelete() {
        while (true) {
            System.out.println("Take someone of the key number too delete the task ");
            int input = sc.nextInt();
            try {
                if (input < 0) {
                    System.out.println("Number are negativ.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    public int userKeyChange() {
        while (true) {
            System.out.println("Take someone of the key number too change the task. ");
            int input = sc.nextInt();
            try {
                if (input < 0) {
                    System.out.println("Number are negativ.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

}