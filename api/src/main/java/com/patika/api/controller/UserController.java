package com.patika.api.controller;


import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.repository.AdvertRepository;
import com.patika.api.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    public UserController(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String getUsers(){
        User user = userRepository.findAll().get(0);
        String string = user.getName();

        for(SaleAdvertisement advert: user.getAdvertisementList()){
            string += "<br>" + advert.toString() + "<br>";
        }

        return string;
    }

}
