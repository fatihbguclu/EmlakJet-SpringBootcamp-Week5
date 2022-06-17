package com.patika.api.producer;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerServiceImpl implements MessageProducerService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public MessageProducerServiceImpl(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void sendAdvertMessage(SaleAdvertisement saleAdvertisement) {

    }

    @Override
    public void sendUserMessage(User user) {
        rabbitTemplate.convertAndSend(this.queue.getName(), user);
    }
}
