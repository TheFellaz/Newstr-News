package com.example.Newsternews.Controller;

import com.example.Newsternews.EmailService.EmailSendingService;
import com.example.Newsternews.Resources.EmailBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailServiceController {

    private final EmailSendingService emailSendingService;

    public EmailServiceController(EmailSendingService emailSendingService) {
        this.emailSendingService = emailSendingService;
    }

    @PostMapping("/emailTesting")
    public ResponseEntity sendEmail(@RequestBody EmailBody emailBody){
        this.emailSendingService.sendEmail(emailBody.getTo(), emailBody.getSubject(), emailBody.getBody());

        return ResponseEntity.ok("email has been sent");
    }
}
