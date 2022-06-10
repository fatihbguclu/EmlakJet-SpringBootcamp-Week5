package com.patika.webapp.controller;


import com.patika.api.domain.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping("/users")
public class UserController {

    private WebClient webClient;

    public UserController() {
        this.webClient = WebClient.create("http://localhost:8080/users");
    }

    @GetMapping
    public String getUsers(){

        WebClient.ResponseSpec spec = webClient.get()
                .uri("")
                .retrieve();

        return spec.bodyToMono(String.class).block();
    }

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable String userId){

        WebClient.ResponseSpec spec = webClient.get()
                .uri("/" + userId)
                .retrieve();

        return spec.bodyToMono(String.class).block();
    }

    @PostMapping
    public String createUser(@RequestBody User user){

        WebClient.ResponseSpec spec = webClient.post()
                .uri("")
                .bodyValue(user)
                .retrieve();

        return spec.bodyToMono(String.class).block();
    }

}
