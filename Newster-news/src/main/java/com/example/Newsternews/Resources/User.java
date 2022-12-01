package com.example.Newsternews.Resources;

import java.util.Arrays;

public class User {
    private String userName;
    private String email;
    private String pw;
    private int[] topics = null;
    private int frequency = 0;
    private String token = null;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", topics=" + Arrays.toString(topics) +
                ", frequency=" + frequency +
                ", token='" + token + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public int[] getTopics() {
        return topics;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getToken() {
        return token;
    }

    public void User(String userName, String email, String pw){
        this.userName = userName;
        this.email = email;
        this.pw = pw;
    }

    public void setTopics(int[] topics){
        this.topics = topics;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public void setToken(String token){
        this.token = token;
    }


}
