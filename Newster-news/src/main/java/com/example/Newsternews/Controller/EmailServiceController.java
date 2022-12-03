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
    //@Scheduled(cron = "0 0 8,12,18 * * ?") //At 8am, 12am, and 6pm
    @Scheduled(cron = "0 * * * * ?") //For testing every minute
    public ResponseEntity sendEmails() throws IOException, MessagingException
    {
        EmailTemplate emailBody1, emailBody2, emailBody3, emailBody4, emailBody5, emailBody6, emailBody7, emailBody8,
                emailBody9;
        emailBody1 = getSearchResults(Keys.SEARCHTERM1);
        emailBody2 = getSearchResults(Keys.SEARCHTERM2);
        emailBody3 = getSearchResults(Keys.SEARCHTERM3);
        emailBody4 = getSearchResults(Keys.SEARCHTERM4);
        emailBody5 = getSearchResults(Keys.SEARCHTERM5);
        emailBody6 = getSearchResults(Keys.SEARCHTERM6);
        emailBody7 = getSearchResults(Keys.SEARCHTERM7);
        emailBody8 = getSearchResults(Keys.SEARCHTERM8);
        emailBody9 = getSearchResults(Keys.SEARCHTERM9);

        sendEmail("wpr29@nau.edu", "Newster News - Check out the Latest News", emailBody1.getEmailBody() + emailBody4.getEmailBody());

        return ResponseEntity.ok("Emails have been sent.");
    }

    public void sendEmail(String user, String subject, String body) throws MessagingException
    {
        this.emailSendingService.sendEmail(user, subject, Keys.EMAIL_HEADER + body);
    }

    public EmailTemplate getSearchResults(String searchTerm) throws IOException
    {
        String jsonResult = API.SearchNews(searchTerm);
        ArticleClass searchResults = API.parsedResponse;

        EmailTemplate template = new EmailTemplate();
        template.setName1(searchResults.getHead().getName());
        template.setDescription1(searchResults.getHead().getDescription());
        template.setUrl1(searchResults.getHead().getUrl());

        searchResults.setHead(searchResults.getHead().getNextNode());

        template.setName2(searchResults.getHead().getName());
        template.setDescription2(searchResults.getHead().getDescription());
        template.setUrl2(searchResults.getHead().getUrl());

        searchResults.setHead(searchResults.getHead().getNextNode());

        template.setName3(searchResults.getHead().getName());
        template.setDescription3(searchResults.getHead().getDescription());
        template.setUrl3(searchResults.getHead().getUrl());

        return template;
    }

}
