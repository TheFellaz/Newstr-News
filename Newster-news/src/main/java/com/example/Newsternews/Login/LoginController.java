package com.example.Newsternews.Login;


import com.example.Newsternews.Resources.User;
//import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    // endpoint for the controller

    // function the retrun type should be ResponseEntity<String>
    // ResponseEntity<String> is for the json string
    // SignupUserData is the class to get Json data
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userData) {
//        System.out.println("시발");
        System.out.println(userData.getEmail());
        System.out.println(userData.getPw());
        System.out.println(userData.getUserName());
        String jsonString = "{'element1':'value1','element2':{'id':0,'name':'testName'}}";
        // make httpheaders
        HttpHeaders headers = new HttpHeaders();
        // return Json
        return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);
    }
}
