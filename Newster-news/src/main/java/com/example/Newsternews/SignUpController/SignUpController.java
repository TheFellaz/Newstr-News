package com.example.Newsternews.SignUpController;

import com.example.Newsternews.Resources.User;
import com.example.Newsternews.Resources.token;
import com.example.Newsternews.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User userData){
        HttpHeaders headers = new HttpHeaders();
        String responseString = "";
        token TokenCreator = new token();
        String newToken = TokenCreator.createToken(userData.getEmail()+userData.getUserName());
        User newUser = new User(userData.getUserName(), userData.getEmail(), userData.getPw());
        newUser.setToken(newToken);
        if(userRepository.findByEmail(userData.getEmail()) != null){
            responseString = "Duplicate";
        }
        userRepository.save(newUser);
        return new ResponseEntity<>(responseString, headers, HttpStatus.OK);
    }
}
