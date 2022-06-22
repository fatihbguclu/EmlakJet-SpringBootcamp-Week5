package com.patika.api.controller;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.producer.MessageProducerService;
import com.patika.api.service.AdvertService;
import com.patika.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(name = "/api/adverts")
public class AdvertController {

    private final AdvertService advertService;
    private final UserService userService;

    public AdvertController(AdvertService advertService, UserService userService) {
        this.advertService = advertService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public String getAdvertsByUserId(@PathVariable String userId){
        List<SaleAdvertisement> advertisementList = advertService.getAllByUser(Long.valueOf(userId));
        String str = "";
        for(SaleAdvertisement advertisement: advertisementList){
            str += "<br>" + advertisement.getUser().getName() + "<br>" + advertisement.toString();
        }
        return str;
    }

    @PostMapping("/{userId}")
    public void createAdvert(@RequestBody SaleAdvertisement advertisement,
                             @PathVariable String userId){
        SaleAdvertisement savedAdvert =  advertService.createAdvert(advertisement, Long.valueOf(userId));
    }

    @GetMapping("/filter/price/")
    public List<SaleAdvertisement> findSaleAdvertisementsByPriceBetween(@RequestParam("p1") String price1,
                                                                        @RequestParam("p2") String price2){
        return advertService.findSaleAdvertisementsByPriceBetween(price1, price2);
    }


    @GetMapping("/filter/title/")
    public List<SaleAdvertisement> findSaleAdvertisementsByTitleContainingIgnoreCase(@RequestParam("title") String title){
        return findSaleAdvertisementsByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/filter/detail/")
    public List<SaleAdvertisement> findSaleAdvertisementsByDetailsContainingIgnoreCase(@RequestParam("detail") String detail){
        return advertService.findSaleAdvertisementsByDetailsContainingIgnoreCase(detail);
    }

    @GetMapping("/filter/timedesc/")
    public List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtAsc(@RequestParam("time")LocalDateTime time){
        return advertService.findSaleAdvertisementsByCreatedAtOrderByCreatedAtAsc(time);
    }

    @GetMapping("/filter/timeasc/")
    public List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtDesc(@RequestParam("time")LocalDateTime time){
        return advertService.findSaleAdvertisementsByCreatedAtOrderByCreatedAtDesc(time);
    }




}
