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
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUser requestedUserData) {

        User emailVerificaiton;
        HttpStatus returnStatus = HttpStatus.BAD_REQUEST;
        HttpHeaders headers = new HttpHeaders();
        Gson gsonObj = new Gson();
        String response = "default";

        System.out.println(requestedUserData.getEmail());
        System.out.println(requestedUserData.getToken());
        System.out.println(requestedUserData.getFrequency());
        System.out.println(requestedUserData.getTopics());
        System.out.println(requestedUserData.isBusiness());
        System.out.println(requestedUserData.isEntertainment_MovieAndTV());
        System.out.println(requestedUserData.isEntertainment_Music());
        System.out.println(requestedUserData.isPolitics());
        System.out.println(requestedUserData.isScienceAndTechnology());
        System.out.println(requestedUserData.isUS());


        //search for user in database from email
        emailVerificaiton = userRepository.findByEmail(requestedUserData.getEmail());
        if(emailVerificaiton != null)
        {
            User updatedUser = new User(requestedUserData);

            if(updatedUser.getToken().equals(emailVerificaiton.getToken())) {
                response = "";
                returnStatus = HttpStatus.OK;
                //create new user object from request data

                //add old password
                updatedUser.setPw(emailVerificaiton.getPw());

                //save new user object to db
                userRepository.save(updatedUser);
            }
        }
        else
        {
            response = "lick my bals";
            returnStatus = HttpStatus.NOT_FOUND;
        }
        //if token match, send back full user data
        //construct topic string

        //otherwise give 404

        // make httpheaders
//        HttpHeaders headers = new HttpHeaders();

        // return Json
        return new ResponseEntity<>(response, headers, returnStatus);
    }
}