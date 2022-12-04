package com.example.Newsternews.EmailController;

import com.example.Newsternews.EmailService.EmailSendingService;
import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.EmailTemplate;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.Topic;
import com.example.Newsternews.Resources.User;
import com.example.Newsternews.newsRepository.NewsRepository;
import com.example.Newsternews.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class EmailServiceController {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;

    private final EmailSendingService emailSendingService;

    public EmailServiceController(EmailSendingService emailSendingService) {
        this.emailSendingService = emailSendingService;
    }

    @Scheduled(cron = "0 0 8,12,18 * * ?") //At 8am, 12am, and 6pm
    public ResponseEntity sendEmails() throws IOException, MessagingException, InterruptedException {
        List<User> userList = userRepository.findAll();
        LocalTime ArizonaNow = LocalTime.now(ZoneId.of("America/Phoenix"));
        int hour = ArizonaNow.getHour();

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            int frequency = user.getFrequency();
            ArrayList<Integer> topicIntList = new ArrayList<>();
            String topicStr = user.getTopics();
            String[] topicStrList = topicStr.split(" ");
            for (int j = 0; j < topicStrList.length; j++) {
                topicIntList.add(Integer.parseInt(topicStrList[j]));
            }

            LinkedList<EmailTemplate> emailTemplateList = new LinkedList<>();

            if(hour == 8){
                for (int j = 0; j < topicIntList.size(); j++) {
                    String searchTerm = Topic.SearchTermList[topicIntList.get(j)-1];
                    emailTemplateList.add(getSearchResults(searchTerm));
                    Thread.sleep(5000);
                }
                String body = "";
                for (int j = 0; j < emailTemplateList.size(); j++) {
                    body += emailTemplateList.get(j).getEmailBody();
                }
                sendEmail(user.getEmail(), body);

            }else if(hour == 18){
                if(frequency != 1){
                    for (int j = 0; j < topicIntList.size(); j++) {
                        String searchTerm = Topic.SearchTermList[topicIntList.get(j)-1];
                        emailTemplateList.add(getSearchResults(searchTerm));
                        Thread.sleep(5000);
                    }
                    String body = "";
                    for (int j = 0; j < emailTemplateList.size(); j++) {
                        body += emailTemplateList.get(j).getEmailBody();
                    }
                    sendEmail(user.getEmail(), body);
                }
            }else if(hour == 12){ //hour == 12
                if(frequency == 3){
                    for (int j = 0; j < topicIntList.size(); j++) {
                        String searchTerm = Topic.SearchTermList[topicIntList.get(j)-1];
                        emailTemplateList.add(getSearchResults(searchTerm));
                        Thread.sleep(5000);
                    }
                    String body = "";
                    for (int j = 0; j < emailTemplateList.size(); j++) {
                        body += emailTemplateList.get(j).getEmailBody();
                    }
                    sendEmail(user.getEmail(), body);
                }
            }
        }

        return ResponseEntity.ok("Emails have been sent.");
    }

    public void sendEmail(String emaillAddress, String body) throws MessagingException
    {
        this.emailSendingService.sendEmail(emaillAddress, "Newster News - Check out the Latest News",
                Keys.EMAIL_HEADER + body);
        System.out.println("Mail is Sent");
    }

    public EmailTemplate getSearchResults(String searchTerm)
    {
        int topic = Topic.getSearchTermValue(searchTerm);

        LinkedList<News> searchResults = newsRepository.findByTopics(topic);

        EmailTemplate template = new EmailTemplate();
        template.setName1(searchResults.get(0).getNewsTitle());
        template.setDescription1(searchResults.get(0).getDesc());
        template.setUrl1(searchResults.get(0).getNewsUrl());

        template.setName2(searchResults.get(1).getNewsTitle());
        template.setDescription2(searchResults.get(1).getDesc());
        template.setUrl2(searchResults.get(1).getNewsUrl());

        template.setName3(searchResults.get(2).getNewsTitle());
        template.setDescription3(searchResults.get(2).getDesc());
        template.setUrl3(searchResults.get(2).getNewsUrl());

        return template;
    }

}