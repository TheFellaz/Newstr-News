package com.example.Newsternews.EmailService.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import com.example.Newsternews.EmailService.EmailSendingService;
import com.example.Newsternews.Keys.Keys;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderIMPL implements EmailSendingService{

    private final JavaMailSender emailSender;

    public EmailSenderIMPL(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @Override
    public void sendEmail(String to, String subject, String body) throws MessagingException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(body, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(Keys.EMAIL);
        this.emailSender.send(mimeMessage);

    }
}
