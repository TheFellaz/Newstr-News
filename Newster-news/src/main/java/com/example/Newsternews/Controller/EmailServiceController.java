package com.example.Newsternews.Controller;

import com.example.Newsternews.API.ArticleClass;
import com.example.Newsternews.API.Outbox;
import com.example.Newsternews.EmailService.EmailSendingService;
import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.EmailBody;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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

//    @PostMapping("/emailTesting")
    //@Scheduled(cron = "0 0 8,12,18 * * ?")
    @Scheduled(cron = "0 * * * * ?")
    public ResponseEntity sendEmails() throws IOException {
        String jsonResult = API.SearchNews(Keys.SEARCHTERM1);
        ArticleClass search1Results = API.parsedResponse;
        String search1body = search1Results.getHead().getName();
        search1body += search1Results.getHead().getDescription();
        search1body += search1Results.getHead().getUrl();

        sendEmail("wpr29@nau.edu", "Your news", "<h1>THIS IS A TEST</h1>");

        return ResponseEntity.ok("Emails have been sent.");
    }

    public void sendEmail(String user, String subject, String body)
    {
        this.emailSendingService.sendEmail(user, subject, body);
    }

}
