package com.example.Newsternews.SignIn;


import com.example.Newsternews.Resources.SignupUserData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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
    // endpoint for the controller
    @PostMapping("/signup")
    // function the retrun type should be ResponseEntity<String>
    // ResponseEntity<String> is for the json string
    // SignupUserData is the class to get Json data
    public ResponseEntity<String> reply(@RequestBody SignupUserData userData) {
        System.out.println(userData.getEmail());
        System.out.println(userData.getPassword());
        System.out.println(userData.getUsername());
        // example json string
        String jsonString = "{'element1':'value1','element2':{'id':0,'name':'testName'}}";
        // make httpheaders
        HttpHeaders headers = new HttpHeaders();
        // return Json
        return new ResponseEntity<>(jsonString, headers, HttpStatus.NOT_FOUND);
    }
}
