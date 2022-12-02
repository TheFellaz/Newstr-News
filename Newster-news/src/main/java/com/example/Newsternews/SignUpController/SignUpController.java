package com.example.Newsternews.SignUpController;

import com.example.Newsternews.Resources.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
<<<<<<< Updated upstream:Newster-news/src/main/java/com/example/Newsternews/SignUpController/SignUpController.java
public class SignUpController {
=======
public class SingUpController {

//    private final UserRepository userRepository;
//
//    public SingUpController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

>>>>>>> Stashed changes:Newster-news/src/main/java/com/example/Newsternews/SignUpController/SingUpController.java
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User userData){
        HttpHeaders headers = new HttpHeaders();
        String responseString = "{'token':'hash'}";
        System.out.println(userData.toString());
//        System.out.println(userRepository.findAll());
        return new ResponseEntity<>(responseString, headers, HttpStatus.OK);
    }
}
