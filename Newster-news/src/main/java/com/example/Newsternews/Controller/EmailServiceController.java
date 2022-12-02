package com.example.Newsternews.Controller;

import com.example.Newsternews.API.ArticleClass;
import com.example.Newsternews.API.Outbox;
import com.example.Newsternews.EmailService.EmailSendingService;
import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.EmailBody;
import com.example.Newsternews.Resources.EmailTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Newsternews.API.API;

import javax.mail.MessagingException;
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
    public ResponseEntity sendEmails() throws IOException, MessagingException {
        String jsonResult = API.SearchNews(Keys.SEARCHTERM1);
        ArticleClass search1Results = API.parsedResponse;

        EmailTemplate template = new EmailTemplate();
        template.setName1(search1Results.getHead().getName());
        template.setDescription1(search1Results.getHead().getDescription());
        template.setUrl1(search1Results.getHead().getUrl());

        search1Results.setHead(search1Results.getHead().getNextNode());

        template.setName2(search1Results.getHead().getName());
        template.setDescription2(search1Results.getHead().getDescription());
        template.setUrl2(search1Results.getHead().getUrl());

        search1Results.setHead(search1Results.getHead().getNextNode());

        template.setName3(search1Results.getHead().getName());
        template.setDescription3(search1Results.getHead().getDescription());
        template.setUrl3(search1Results.getHead().getUrl());

        sendEmail("wpr29@nau.edu", "Your news", template.getEmailBody());

        return ResponseEntity.ok("Emails have been sent.");
    }

    public void sendEmail(String user, String subject, String body) throws MessagingException {
        this.emailSendingService.sendEmail(user, subject, body);
    }

}
