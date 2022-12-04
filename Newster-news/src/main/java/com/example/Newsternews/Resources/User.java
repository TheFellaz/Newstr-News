package com.example.Newsternews.Resources;

import com.google.gson.Gson;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@ToString
@Getter
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "USER_TB")
public class User {

    @Id
    @Column(name="user_email", nullable = false)
    private String email;

    public User(String userName, String email, String pw, String topics, int frequency, String token) {
        this.userName = userName;
        this.email = email;
        this.pw = pw;
        this.topics = topics;
        this.frequency = frequency;
        this.token = token;
    }

    public User(String userName, String email, String pw){
        this.userName = userName;
        this.email = email;
        this.pw = pw;
    }

    public User(RegisterUser regUser){
        Gson gsonObj = new Gson();
        ArrayList<Integer> topicsArray = new ArrayList<>();

        this.userName = regUser.getUserName();
        this.email = regUser.getEmail();
        this.pw = regUser.getPw();
        this.token = regUser.getToken();

        if(regUser.Business){
            topicsArray.add(1);
        }
        if(regUser.Entertainment_MovieAndTV){
            topicsArray.add(2);
        }
        if(regUser.Entertainment_Music){
            topicsArray.add(3);
        }
        if(regUser.Politics){
            topicsArray.add(4);
        }
        if(regUser.ScienceAndTechnology){
            topicsArray.add(5);
        }
        if(regUser.Sports_NBA){
            topicsArray.add(6);
        }
        if(regUser.Sports_NFL){
            topicsArray.add(7);
        }
        if(regUser.US){
            topicsArray.add(8);
        }
        if(regUser.World){
            topicsArray.add(9);
        }
        String strTopics = "";
        for (int i = 0; i < topicsArray.size(); i++) {
            String tmp = topicsArray.get(i).toString();
            if(i != topicsArray.size()-1){
                strTopics += tmp + " ";
            }else{
                strTopics += tmp;
            }
        }

        this.topics = strTopics;

        this.frequency = regUser.getFrequency();


    }
    @Column(name="USER_NAME", nullable = false)
    private String userName;


    @Column(name="USER_PASSWORD", nullable = false)
    private String pw;

    @Column(name = "USER_TOPICS", nullable = true)
    private String topics = null;

    @Column(name = "USER_FREQUENCY", nullable = true)
    private int frequency = 0;

    @Column(name = "USER_TOKEN", nullable = true)
    private String token = null;

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", pw='" + pw + '\'' +
                ", topics='" + topics + '\'' +
                ", frequency=" + frequency +
                ", token='" + token + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}