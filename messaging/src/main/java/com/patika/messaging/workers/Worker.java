package com.patika.messaging.workers;


import com.patika.api.domain.User;
import com.patika.messaging.domain.UserDTO;
import com.patika.messaging.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Worker {

    private final RabbitTemplate rabbitTemplate;
    private final UserRepository userRepository;

    public Worker(RabbitTemplate rabbitTemplate, UserRepository userRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.userRepository = userRepository;
    }


    @RabbitListener(queues = "user-queue")
    public void listener(@Payload User user) throws InterruptedException {

        Thread.sleep(5000);

        System.out.println(user.toString());

        UserDTO newUser = new UserDTO();
        newUser.setName(user.getName());
        newUser.setMail(user.getMail());
        newUser.setAdvertisementList(new ArrayList<>());
        System.out.println(newUser.toString());
        userRepository.save(newUser);

    }

}
