package org.example.Login.Interface;

import org.example.Login.User;

public class FakeUserMaxRepository implements UserRepository {

    @Override
    public User findePasswordUserIDByUserName(String userName) {
        if(userName.equals("Max")){
            User user = new User(1,"Max","123456");
            return user;
        }
       return null;
    }

    @Override
    public void createANewUserWithHashPassword(String userName, String hashPassword) {

    }
}
