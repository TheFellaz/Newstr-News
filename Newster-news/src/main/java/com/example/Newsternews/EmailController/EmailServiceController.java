package com.example.Newsternews.EmailController;

import com.example.Newsternews.EmailService.EmailSendingService;
import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.EmailTemplate;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.User;
import com.example.Newsternews.newsRepository.NewsRepository;
import com.example.Newsternews.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Newsternews.API.API;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDateTime;
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

    @GetMapping("/emailTesting")
    @Scheduled(cron = "0 0 8,12,18 * * ?") //At 8am, 12am, and 6pm
//    @Scheduled(cron = "0 * * * * ?") //For testing every minute
    public ResponseEntity sendEmails() throws IOException, MessagingException, InterruptedException {
//        EmailTemplate emailBody = getSearchResults()
        List<User> userList = userRepository.findAll();
        List<User> userList1 = userRepository.findByFrequency(1);
        List<User> userList2 = userRepository.findByFrequency(2);
        List<User> userList3 = userRepository.findByFrequency(3);
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

            LinkedList<EmailTemplate> emailTemplatList = new LinkedList<>();
            //Testing
            for (int j = 0; j < topicIntList.size(); j++) {
                String searchTerm = Keys.SearchTermList[topicIntList.get(j)-1];
                emailTemplatList.add(getSearchResults(searchTerm));
                Thread.sleep(5000);
            }
            String body1 = "";
            for (int j = 0; j < emailTemplatList.size(); j++) {
                body1 += emailTemplatList.get(j).getEmailBody();
            }
            sendEmail(user.getEmail(), "Newster News - Check out the Latest News", body1);

            if(hour == 8){
                for (int j = 0; j < topicIntList.size(); j++) {
                    String searchTerm = Keys.SearchTermList[topicIntList.get(j)-1];
                    emailTemplatList.add(getSearchResults(searchTerm));
                    Thread.sleep(5000);
                }
                String body = "";
                for (int j = 0; j < emailTemplatList.size(); j++) {
                    body += emailTemplatList.get(j).getEmailBody();
                }
                sendEmail(user.getEmail(), "Newster News - Check out the Latest News", body);

            }else if(hour == 18){
                if(frequency != 1){
                    for (int j = 0; j < topicIntList.size(); j++) {
                        String searchTerm = Keys.SearchTermList[topicIntList.get(j)-1];
                        emailTemplatList.add(getSearchResults(searchTerm));
                        Thread.sleep(5000);
                    }
                    String body = "";
                    for (int j = 0; j < emailTemplatList.size(); j++) {
                        body += emailTemplatList.get(j).getEmailBody();
                    }
                    sendEmail(user.getEmail(), "Newster News - Check out the Latest News", body);
                }
            }else if(hour == 12){ //hour == 12
                if(frequency == 3){
                    for (int j = 0; j < topicIntList.size(); j++) {
                        String searchTerm = Keys.SearchTermList[topicIntList.get(j)-1];
                        emailTemplatList.add(getSearchResults(searchTerm));
                        Thread.sleep(5000);
                    }
                    String body = "";
                    for (int j = 0; j < emailTemplatList.size(); j++) {
                        body += emailTemplatList.get(j).getEmailBody();
                    }
                    sendEmail(user.getEmail(), "Newster News - Check out the Latest News", body);
                }
            }
        }


//        EmailTemplate emailBody1, emailBody2, emailBody3, emailBody4, emailBody5, emailBody6, emailBody7, emailBody8,
//                emailBody9;
//        emailBody1 = getSearchResults(Keys.SEARCHTERM1);
//        Thread.sleep(5000);
//        emailBody2 = getSearchResults(Keys.SEARCHTERM2);
        //emailBody3 = getSearchResults(Keys.SEARCHTERM3);
        //emailBody4 = getSearchResults(Keys.SEARCHTERM4);
        //emailBody5 = getSearchResults(Keys.SEARCHTERM5);
        //emailBody6 = getSearchResults(Keys.SEARCHTERM6);
        //emailBody7 = getSearchResults(Keys.SEARCHTERM7);
        //emailBody8 = getSearchResults(Keys.SEARCHTERM8);
        //emailBody9 = getSearchResults(Keys.SEARCHTERM9);

//        sendEmail("wpr29@nau.edu", "Newster News - Check out the Latest News", emailBody1.getEmailBody() +
//                emailBody2.getEmailBody());

        return ResponseEntity.ok("Emails have been sent.");
    }

    public void sendEmail(String emaillAddress, String subject, String body) throws MessagingException
    {
        this.emailSendingService.sendEmail(emaillAddress, subject, Keys.EMAIL_HEADER + body);
        System.out.println("Mail is Sent");
    }

    public EmailTemplate getSearchResults(String searchTerm) throws IOException
    {
        int topic = 0;
        if (searchTerm.equals("Business")){
            topic = 1;
        }else if (searchTerm.equals("Entertainment_MovieAndTV")){
            topic = 2;
        }else if (searchTerm.equals("Entertainment_Music")){
            topic = 3;
        }else if (searchTerm.equals("Politics")){
            topic = 4;
        }else if (searchTerm.equals("ScienceAndTechnology")){
            topic = 5;
        }else if (searchTerm.equals("Sports_NBA")){
            topic = 6;
        }else if (searchTerm.equals("Sports_NFL")){
            topic = 7;
        }else if (searchTerm.equals("US")){
            topic = 8;
        }else{
            topic = 9;
        }
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