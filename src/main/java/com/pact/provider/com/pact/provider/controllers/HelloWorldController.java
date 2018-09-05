package com.pact.provider.com.pact.provider.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.pact.provider.com.pact.provider.entities.UserEntity;
import com.pact.provider.com.pact.provider.models.Greeting;
import com.pact.provider.com.pact.provider.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();
    private HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public @ResponseBody
    Greeting sayHello(@RequestHeader(value="name", required=true) String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping(value = "/register")
    public @ResponseBody
    ResponseEntity<UserEntity> createCourse(@RequestBody UserEntity userEntity) {
        return new ResponseEntity<UserEntity>(helloWorldService.createCourse(userEntity), HttpStatus.CREATED);
    }

}