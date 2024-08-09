package org.example.lifesyncemail.rabbitmqconsumer;

import io.netty.util.internal.SuppressJava6Requirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lifesyncemail.email.EmailReceiveDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQConsumer {

    private final Logger logger = Logger.getLogger(RabbitMQConsumer.class.getName());

    private final JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, Integer token) {
        String mailBody = "Your verfication token is" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(mailBody);
        javaMailSender.send(message);
        log.info("MESSAGE SENT SUCCESSFULLY");
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveMessage(EmailReceiveDTO message) {
       log.info(message.getEmail() + " " + message.getToken());
       sendEmail(message.getEmail(), "Email verfication code", message.getToken());
    }

}
