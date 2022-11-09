package com.example.Newsternews.EmailService.impl;

import com.example.Newsternews.EmailService.EmailSendingService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderIMPL implements EmailSendingService{

    private final JavaMailSender emailSender;

    public EmailSenderIMPL(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("newsterteam386@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        this.emailSender.send(simpleMailMessage);
    }
}
