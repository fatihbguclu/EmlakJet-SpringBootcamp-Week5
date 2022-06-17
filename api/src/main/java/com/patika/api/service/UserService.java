package com.patika.api.service;

import com.patika.api.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String createUser(User user);

    User getById(Long valueOf);

    List<User> findAll();


}
