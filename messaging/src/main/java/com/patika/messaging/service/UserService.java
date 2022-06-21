package com.patika.messaging.service;

import com.patika.messaging.domain.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createRandomUsers(UserDTO user);

}
