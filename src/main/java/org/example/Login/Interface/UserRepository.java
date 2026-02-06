package org.example.Login.Interface;
import org.example.Login.User;
public interface UserRepository {
    User findePasswordUserIDByUserName(String userName);
    void createANewUserWithHashPassword(String userName, String hashPassword);
}
