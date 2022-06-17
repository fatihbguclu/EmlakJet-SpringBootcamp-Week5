package com.patika.api.service;

import com.patika.api.domain.User;
import com.patika.api.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        user.setAdvertisementList(new ArrayList<>());
        userRepository.save(user);
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
