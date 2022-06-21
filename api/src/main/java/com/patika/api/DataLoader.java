package com.patika.api;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.repository.AdvertRepository;
import com.patika.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;


public class DataLoader implements CommandLineRunner {

    UserRepository userRepository;
    AdvertRepository advertRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    public DataLoader(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("fatih");

        SaleAdvertisement advert1 = new SaleAdvertisement();
        advert1.setTitle("Advert 1");
        advert1.setPrice("1222");
        advert1.setUser(user);

        SaleAdvertisement advert2 = new SaleAdvertisement();
        advert2.setTitle("Advert 2");
        advert2.setPrice("1000");
        advert2.setUser(user);

        ArrayList<SaleAdvertisement> advertisementArrayList = new ArrayList<>();
        advertisementArrayList.add(advert1);
        advertisementArrayList.add(advert2);

        user.setAdvertisementList(advertisementArrayList);

        userRepository.save(user);
        advertRepository.saveAll(advertisementArrayList);
    }


}
