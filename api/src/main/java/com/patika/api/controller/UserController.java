package com.patika.api.controller;


import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getUsers(){
        List<User> userList = userRepository.findAll();
        String string = "";
        for(User user: userList){
            string += user.getName() + "<br>";
            for(SaleAdvertisement advert: user.getAdvertisementList()){
                string += advert.toString() + "<br>";
            }
        }


        return string;
    }

    @PostMapping()
    public void createUser(@RequestBody User user){
        user.setAdvertisementList(new ArrayList<>());
        userRepository.save(user);
    }

}
