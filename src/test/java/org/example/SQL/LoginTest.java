package org.example.SQL;

import org.example.Login.Login;
import PasswordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    void loginSuccessful(){
        String name = "Dennis";
        String password = "123456A!";
        String passwordHash = PasswordService.hash(password);
       
        Assertions.assertTrue(Login.login(name,password));
    }
    @Test
    void loginNotExist(){
        String name = "Das";
        String password = "123456A!";
        Assertions.assertFalse(Login.login(name,password));
    }
    @Test
    void loginNPasswordFalse(){
        String name = "Dennis";
        String password = "123456A!";
        String passwordWrong="Wrong";
        Assertions.assertFalse(Login.login(name,passwordWrong));
    }
}
