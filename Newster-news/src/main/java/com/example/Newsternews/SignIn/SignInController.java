package com.example.Newsternews.SignIn;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Newsternews.API.API;


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
public class SignInController {
    @GetMapping ("/signin")
    public String getNews() {
        // System.out.println("Got Get Request");
        String newsResponse = SearchNews();
        return newsResponse;
    }
}
