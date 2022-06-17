package com.patika.api.controller;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.producer.MessageProducerService;
import com.patika.api.service.AdvertService;
import com.patika.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(name = "/adverts")
public class AdvertController {

    private final AdvertService advertService;
    private final UserService userService;

    public AdvertController(AdvertService advertService, UserService userService) {
        this.advertService = advertService;
        this.userService = userService;
    }

    @GetMapping("/adverts/{userId}")
    public String getAdvertsByUserId(@PathVariable String userId){
        List<SaleAdvertisement> advertisementList = advertService.getAllByUser(Long.valueOf(userId));
        String str = "";
        for(SaleAdvertisement advertisement: advertisementList){
            str += "<br>" + advertisement.getUser().getName() + "<br>" + advertisement.toString();
        }
        return str;
    }

    @PostMapping("/adverts/{userId}")
    public void createAdvert(@RequestBody SaleAdvertisement advertisement,
                             @PathVariable String userId){
        SaleAdvertisement savedAdvert =  advertService.createAdvert(advertisement, Long.valueOf(userId));
    }

}
