package com.pact.provider.com.pact.provider.services;

import com.pact.provider.com.pact.provider.entities.UserEntity;
import com.pact.provider.com.pact.provider.models.Greeting;
import com.pact.provider.com.pact.provider.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class HelloWorldService {

    @Autowired
    private UserRepository userRepository;

    public HelloWorldService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createCourse(UserEntity userEntity) {
        return userRepository.saveAndFlush(userEntity);
    }


}