package org.example.Login;

public class User {
    private final int id;
    private final String user;
    private final String passwordHash;
    public User(int id,String user,String passwordHash){
        this.id = id;
        this.user = user;
        this.passwordHash = passwordHash;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
