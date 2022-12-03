package com.example.Newsternews.Resources;

import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

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