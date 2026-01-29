package org.example.Login;

public interface UserRepository {
    User findePasswordUserIDByUserName(String userName);
}
