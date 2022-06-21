package com.patika.messaging.workers;


import com.patika.api.domain.User;
import com.patika.messaging.domain.UserDTO;
import com.patika.messaging.service.AdvertService;
import com.patika.messaging.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

@Component
public class Worker {

    private final RabbitTemplate rabbitTemplate;
    private final UserService userService;
    private final AdvertService advertService;
    private final RabbitAdmin rabbitAdmin;

    public Worker(RabbitTemplate rabbitTemplate, UserService userService, AdvertService advertService) {
        this.rabbitTemplate = rabbitTemplate;
        this.userService = userService;
        this.advertService = advertService;
        this.rabbitAdmin = new RabbitAdmin(rabbitTemplate);
    }


    @RabbitListener(queues = "user-queue")
    public void listener(@Payload User user) throws InterruptedException {

        UserDTO newUser = new UserDTO();
        newUser.setName(user.getName());
        newUser.setMail(user.getMail());
        newUser.setAdvertisementList(new ArrayList<>());

        userService.createRandomUsers(newUser);

        if (Objects.requireNonNull(rabbitAdmin.getQueueInfo("user-queue")).getMessageCount() == 0){
            advertService.createRandomAdvert();
        }

    }

}
