package com.example.Newsternews.SignIn;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


class member {
    public String topic;

    @Override
    public String toString() {
        return "member{" +
                "topic='" + topic + '\'' +
                '}';
    }
}

@RestController
@CrossOrigin(origins = "http://192.119.67.66:3000")
public class SignInController {
    @GetMapping ("/signin")
    public String getNews() {
        System.out.println("Got Get Request");
        return "This should be news";
    }
}
