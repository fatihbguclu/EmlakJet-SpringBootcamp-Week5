package com.patika.api.producer;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;


public interface MessageProducerService {
    void sendAdvertMessage(SaleAdvertisement saleAdvertisement);
    void sendUserMessage(User user);
}
