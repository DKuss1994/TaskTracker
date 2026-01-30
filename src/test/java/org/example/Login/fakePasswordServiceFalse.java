package org.example.Login;

public class fakePasswordServiceFalse implements PasswordCreate {

    @Override
    public String hash(String password) {
        return password;
    }

    @Override
    public boolean verify(String password, String hash) {
        return false;
    }
}