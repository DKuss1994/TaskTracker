package org.example.Login;

public class fakeUserNotMaxRepository implements UserRepository {

    @Override
    public User findePasswordUserIDByUserName(String userName) {
        if(userName.equals("Moritz")){
            User user = new User(1,"Moritz","123456");
            return user;
        }
       return null;
    }
}
