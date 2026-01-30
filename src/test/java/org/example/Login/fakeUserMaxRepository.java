package org.example.Login;

public class fakeUserMaxRepository implements UserRepository {

    @Override
    public User findePasswordUserIDByUserName(String userName) {
        if(userName.equals("Max")){
            User user = new User(1,"Max","123456");
            return user;
        }
       return null;
    }
}
