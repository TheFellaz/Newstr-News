package com.example.Newsternews.UserPage;

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

import java.util.ArrayList;

@RestController
public class UserPageController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/user")
    public ResponseEntity<String> user(@RequestBody User requestedUserData) {
        User emailVerificaiton;
        HttpStatus returnStatus = HttpStatus.BAD_REQUEST;
        HttpHeaders headers = new HttpHeaders();
        Gson gsonObj = new Gson();
        String response = "default";

        //search for user in database from username
        emailVerificaiton = userRepository.findByEmail(requestedUserData.getEmail());
        if(emailVerificaiton != null){
            response = "";
            returnStatus = HttpStatus.FORBIDDEN;
            //verify with token
            if(requestedUserData.getToken().equals(emailVerificaiton.getToken()))
            {
                //send back full user data
                response = gsonObj.toJson(emailVerificaiton);
                returnStatus = HttpStatus.OK;

                //System.out.println("before response");
                //return new ResponseEntity<>(response, headers, HttpStatus.OK);
            }

        }
        else {
            response = "";
            returnStatus = HttpStatus.NOT_FOUND;
        }


//        //otherwise give 404
//        String jsonString = "{'element1':'value1','element2':{'id':0,'name':'testName'}}";
//        // make httpheaders
//        // return Json
//        return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);
        return new ResponseEntity<>(response, headers, returnStatus);
    }
}