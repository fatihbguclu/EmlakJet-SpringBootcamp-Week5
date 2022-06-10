package com.patika.api.producer;

import com.patika.api.domain.SaleAdvertisement;


public interface MessageProducerService {
    void sendMessage(SaleAdvertisement saleAdvertisement);
}
