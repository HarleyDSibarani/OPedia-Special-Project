package com.example.newopedia;

public class user {
    public String fullname,username,email,gender;
    public Integer poin;

    public user(){

    }

    public user(String fullname, String username, String email, String gender, Integer poin) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.poin=poin;
    }
}
