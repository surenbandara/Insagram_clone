package com.apolloosiris.instagram;

import java.io.Serializable;

public class User implements Serializable {
    private String password;
    private String username;
    private String email;
    private String name;

    public User(String password,String username,String email,String name){
        this.password=password;
        this.username =username;
        this.email=email;
        this.name=name;
    }

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getname() {
        return name;
    }
}
