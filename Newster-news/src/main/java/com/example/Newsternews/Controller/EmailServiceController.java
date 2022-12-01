package com.example.Newsternews.Controller;

import com.example.Newsternews.API.ArticleClass;
import com.example.Newsternews.API.Outbox;
import com.example.Newsternews.EmailService.EmailSendingService;
import com.example.Newsternews.Resources.EmailBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Newsternews.API.API;

import java.io.IOException;

@RestController
public class EmailServiceController {

    private final EmailSendingService emailSendingService;

    public EmailServiceController(EmailSendingService emailSendingService) {
        this.emailSendingService = emailSendingService;
    }

    @PostMapping("/emailTesting")
    public ResponseEntity sendEmail(@RequestBody EmailBody emailBody) {
        String test;
        try {
            test = API.SearchNews();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.emailSendingService.sendEmail(emailBody.getTo(), emailBody.getSubject(), test);

        return ResponseEntity.ok("email has been sent");
    }
}
