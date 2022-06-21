package com.patika.messaging.service;

import org.springframework.stereotype.Service;

@Service
public interface AdvertService {

    void createRandomAdvert() throws InterruptedException;

}
