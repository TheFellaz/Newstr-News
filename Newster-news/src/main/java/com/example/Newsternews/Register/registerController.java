package com.example.Newsternews.Register;

import com.example.Newsternews.Resources.RegisterUser;
import com.example.Newsternews.Resources.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Newsternews.userRepository.UserRepository;

@RestController
public class registerController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User userData) {
        System.out.println(userData.toString());
        User requestUser = userRepository.findByToken(userData.getToken());

        System.out.println(userData.getEmail());
        System.out.println(userData.getToken());
        System.out.println(userData.getFrequency());
        System.out.println(userData.getTopics());

        requestUser.setFrequency(userData.getFrequency());
        requestUser.setTopics(userData.getTopics());

        userRepository.save(requestUser);
        HttpHeaders headers = new HttpHeaders();
        String responseString = "{\"Correct\": \"Yes\"}";
        // return Json
        return new ResponseEntity<>(responseString, headers, HttpStatus.OK);
    }
}