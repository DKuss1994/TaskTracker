package org.example.Login;

public class User {
    private int id;
    private String user;
    private String passwordHash;
    public void User(int id,String user,String passwordHash){
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
