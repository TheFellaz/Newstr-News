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
@CrossOrigin(origins = "http://localhost:3000")
public class SignInController {
    @GetMapping("/signin")
    public String getNews() {
        return "This should be news";
    }
}
