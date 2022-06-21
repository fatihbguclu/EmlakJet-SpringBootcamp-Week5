package com.patika.messaging.service;


import com.patika.messaging.domain.UserDTO;
import com.patika.messaging.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createRandomUsers(UserDTO user) {
        userRepository.save(user);
    }
}
