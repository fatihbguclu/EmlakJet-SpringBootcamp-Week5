package com.patika.api.controller;


import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.repository.UserRepository;
import com.patika.api.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(){
        List<User> userList = userService.findAll();
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
        userService.createUser(user);
    }

}
