package com.patika.api.service;


import com.patika.api.domain.User;
import com.patika.api.producer.MessageProducerService;
import com.patika.api.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    public static final String API_URL = "https://random-data-api.com/api/users/random_user?size=50";
    private final UserRepository userRepository;
    private final MessageProducerService messageProducerService;
    private final WebClient webClient;


    public UserServiceImpl(UserRepository userRepository, MessageProducerService messageProducerService) {
        this.userRepository = userRepository;
        this.messageProducerService = messageProducerService;
        this.webClient = WebClient.create(API_URL);
    }

    @Override
    public void createRandomUser() {

        String jsonString = webClient.get()
                .uri("")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);

                User newUser = new User();
                newUser.setName(object.getString("first_name"));
                newUser.setMail(object.getString("email"));
                newUser.setAdvertisementList(new ArrayList<>());

                messageProducerService.sendUserMessage(newUser);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
