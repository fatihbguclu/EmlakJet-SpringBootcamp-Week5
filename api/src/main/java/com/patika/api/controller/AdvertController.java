package com.patika.api.controller;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.repository.AdvertRepository;
import com.patika.api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(name = "/adverts")
public class AdvertController {

    private final AdvertRepository advertRepository;
    private final UserRepository userRepository;

    public AdvertController(AdvertRepository advertRepository, UserRepository userRepository) {
        this.advertRepository = advertRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/adverts/{userId}")
    public String getAdvertsByUserId(@PathVariable String userId){
        User user = userRepository.getById(Long.valueOf(userId));
        System.out.println(user.getName());
        List<SaleAdvertisement> advertisementList = advertRepository.getAllByUser(user);
        String str = "";

        for(SaleAdvertisement advertisement: advertisementList){
            str += "<br>" + advertisement.getUser().getName() + "<br>" + advertisement.toString();
        }


        return str;
    }

    @PostMapping("/adverts/{userId}")
    public void createAdvert(@RequestBody SaleAdvertisement advertisement,
                             @PathVariable String userId){
        User user = userRepository.getById(Long.valueOf(userId));
        advertisement.setUser(user);

        advertRepository.save(advertisement);
    }

}
