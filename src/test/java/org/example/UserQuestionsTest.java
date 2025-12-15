package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;


public class UserQuestionsTest {

    @Test
    public void AddTest() {
        String simultan = "add\n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Action result = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
        Assertions.assertEquals(Enum.Action.ADD, result);


    }

    @Test
    public void WrongThanADDTest() {
        String simultan = "wrong\nadd\n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Action result = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
        Assertions.assertEquals(Enum.Action.ADD, result);

    }

    @Test
    public void ADDThanWrongTest() {
        String simultan = "add\nwrong\n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Action result = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
        Assertions.assertEquals(Enum.Action.ADD, result);

    }

    @Test
    public void DeleteTest() {
        String simultan = "DeLeTe\n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Action result = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
        Assertions.assertEquals(Enum.Action.DELETE, result);

    }


    @Test
    public void ChangeTest() {
        String simultan = "change\n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Action result = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
        Assertions.assertEquals(Enum.Action.CHANGE, result);

    }

    @Test
    public void ExitTest() {
        String simultan = "exIt\n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Action result = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
        Assertions.assertEquals(Enum.Action.EXIT, result);

    }

    @Test
    public void showTest() {
        String simultan = "            show       \n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Action result = userQuestions.userAction("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
        Assertions.assertEquals(Enum.Action.SHOW, result);

    }

    @Test
    public void userDescriptionTest() {
        String simultan = "Hello!";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        String result = userQuestions.userDescription(simultan);
        Assertions.assertEquals("Hello!", result);

    }

    @Test
    public void userDescriptionTestMoreText() {
        String simultan = "Hello World!";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        String result = userQuestions.userDescription(simultan);
        Assertions.assertEquals("Hello World!", result);

    }


    @Test
    public void userStatusDescriptionTest() {
        String simultan = "done\n";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Status result = userQuestions.userStatusDescription("Description about Status.(DONE,PROGRESS,TODO) ");
        Assertions.assertEquals(Enum.Status.DONE, result);


    }

    @Test
    public void userStatusDescriptionWrongTest() {
        String simultan = "WASWS\nPROGRESS";
        Scanner fake = new Scanner(simultan);
        UserQuestions userQuestions = new UserQuestions(fake);
        Enum.Status result = userQuestions.userStatusDescription("Description about Status.(DONE,PROGRESS,TODO) ");
        Assertions.assertEquals(Enum.Status.PROGRESS, result);


    }

}

