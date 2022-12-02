package com.example.Newsternews.Resources;

import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@ToString
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TB")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    public User(String userName, String email, String pw){
        this.userName = userName;
        this.email = email;
        this.pw = pw;
    }
    @Column(name="USER_NAME", nullable = false)
    private String userName;

    @Column(name="USER_EMAIL", nullable = false)
    private String email;

    @Column(name="USER_PASSWORD", nullable = false)
    private String pw;

    @Column(name = "USER_TOPICS", nullable = true)
    private String topics = null;

    @Column(name = "USER_FREQUENCY", nullable = true)
    private int frequency = 0;

    @Column(name = "USER_TOKEN", nullable = true)
    private String token = null;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
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
