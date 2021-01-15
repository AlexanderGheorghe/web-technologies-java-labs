package com.alexandru.videogamedistribution.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {
    final private JavaMailSender javaMailSender;

    @Async
    public void sendEmail(SimpleMailMessage mail) { javaMailSender.send(mail); }
}
