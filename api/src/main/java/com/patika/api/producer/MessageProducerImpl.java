package com.patika.api.producer;

import com.patika.api.domain.SaleAdvertisement;


import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Service;

@Service
public class MessageProducerImpl implements MessageProducerService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public MessageProducerImpl(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void sendMessage(SaleAdvertisement saleAdvertisement) {

        rabbitTemplate.convertAndSend(queue.getName(), saleAdvertisement,
                message -> {
                    MessageProperties properties = message.getMessageProperties();
                    properties.setHeader("MESSAGE_SOURCE", "WEBAPP");
                    return message;
                });

    }
}
