package org.example.Login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {
       @Test
    void testLoginTrueIfUserAndPasswordTrue(){
           UserService userService = new UserService(new fakeUserMaxRepository(),new fakePasswordService());

           Assertions.assertTrue(userService.login("Max","123456"));

    }
    @Test
    void testLoginFalseIfUserNotFound(){
        UserService userService = new UserService(new fakeUserNotMaxRepository(),new fakePasswordService());
        Assertions.assertFalse(userService.login("Max","123456"));
    }
    @Test
    void testLoginFalseIfPasswordFalse(){
        UserService userService = new UserService(new fakeUserMaxRepository(),new fakePasswordServiceFalse());
        Assertions.assertFalse(userService.login("Max","123456"));
    }
}
