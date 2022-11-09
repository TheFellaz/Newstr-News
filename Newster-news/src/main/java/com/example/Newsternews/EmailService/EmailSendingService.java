package com.example.Newsternews.EmailService;

public interface EmailSendingService {
    void sendEmail(String to, String subject, String body);
}
