package com.patika.webapp.controller;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/adverts")
public class AdvertController {

    private WebClient webClient;

    public AdvertController() {
        this.webClient = WebClient.create("http://localhost:8080/adverts");
    }

    @GetMapping("/{userId}")
    public String getAdvertsByUserId(@PathVariable String userId){

        WebClient.ResponseSpec spec = webClient.get()
                .uri("/" + userId)
                .retrieve();

        return spec.bodyToMono(String.class).block();
    }

    @PostMapping("/{userId}")
    public String createAdvert(@RequestBody SaleAdvertisement saleAdvertisement,
                               @PathVariable String userId){
        WebClient.ResponseSpec spec = webClient.post()
                .uri("/" + userId)
                .bodyValue(saleAdvertisement)
                .retrieve();

        return spec.bodyToMono(String.class).block();
    }


}
