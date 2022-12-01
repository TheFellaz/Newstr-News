package com.example.Newsternews.SignUpController;

import com.example.Newsternews.Resources.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingUpController {
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User userData){
        HttpHeaders headers = new HttpHeaders();
        String responseString = "{'token':'hash'}";
        System.out.println(userData.toString());
        return new ResponseEntity<>(responseString, headers, HttpStatus.OK);
    }
}
