package com.patika.messaging.workers;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.repository.AdvertRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Worker {

    private final RabbitTemplate rabbitTemplate;
    private final AdvertRepository advertRepository;


    public Worker(RabbitTemplate rabbitTemplate, AdvertRepository advertRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.advertRepository = advertRepository;
    }

    public SaleAdvertisement receive(){
        return (SaleAdvertisement) rabbitTemplate.receiveAndConvert("adverts");
    }

    @RabbitListener(queues = "adverts")
    public void listener() throws InterruptedException {
        SaleAdvertisement saleAdvertisement = receive();
        Thread.sleep(30000);

        saleAdvertisement.setGraphPath("/asd.png");
        advertRepository.save(saleAdvertisement);

    }

}
