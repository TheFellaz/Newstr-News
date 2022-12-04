package com.example.Newsternews.Login;


import com.example.Newsternews.Resources.User;
//import org.springframework.data.repository.query.Param;
import com.example.Newsternews.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;
    // endpoint for the controller

    // function the retrun type should be ResponseEntity<String>
    // ResponseEntity<String> is for the json string
    // SignupUserData is the class to get Json data
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userData) {
        System.out.println(userData.getEmail());
        System.out.println(userData.getPw());
        String responseString = "";
        User requestUser = userRepository.findByEmail(userData.getEmail());
        if(requestUser.getPw().equals(userData.getPw())){
            responseString = "{\"Correct\": \"YES\",\"userName\": \""+requestUser.getUserName()+"\",\"token\": \""+requestUser.getToken()+"\"}";
        }else {
            responseString = "{\"Correct\": \"NO\",\"userName\": \"NO\"}";
        }

        // make httpheaders
        HttpHeaders headers = new HttpHeaders();
        // return Json
        return new ResponseEntity<>(responseString, headers, HttpStatus.OK);
    }
}
