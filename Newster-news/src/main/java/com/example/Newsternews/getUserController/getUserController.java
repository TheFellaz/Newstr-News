package com.example.Newsternews.getUserController;

import com.example.Newsternews.Resources.User;
import com.example.Newsternews.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getUserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/userInfo")
    public ResponseEntity<String> getUser(@RequestBody User userData){
        User user = userRepository.findByToken(userData.getToken());
        HttpHeaders headers = new HttpHeaders();
        String responseString = "{\"topics\": \""+user.getTopics().trim()+"\", \"freq\": "+String.valueOf(user.getFrequency())+"}";
        // return Json
        return new ResponseEntity<>(responseString, headers, HttpStatus.OK);
    }
}
