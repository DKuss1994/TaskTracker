package org.example;

import java.util.Scanner;

enum Action {
    ADD,
    DELETE,
    SEARCH,
    CHANGE,
    EXIT,
    INFO,
    SHOW


}

public class UserQuestions {
    private final Scanner sc;

    public UserQuestions(Scanner sc) {
        this.sc = sc;
    }

    public Action userAction(Scanner sc) {
        while (true) {
            System.out.print("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
            String input = sc.next().trim().toUpperCase();
            try {
                return Action.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }

        }


    }

    public String userDescription() {


        System.out.print("Description about it. ");
        return sc.next();


    }


}

