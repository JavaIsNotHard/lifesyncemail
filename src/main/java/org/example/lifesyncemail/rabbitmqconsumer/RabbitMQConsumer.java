package org.example.lifesyncemail.rabbitmqconsumer;

import org.example.lifesyncemail.email.EmailReceiveDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.logging.Logger;

@Service
public class RabbitMQConsumer {

    private final Logger logger = Logger.getLogger(RabbitMQConsumer.class.getName());

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveMessage(EmailReceiveDTO message) {
        System.out.println(message.getEmail() + message.getToken());
    }

}
