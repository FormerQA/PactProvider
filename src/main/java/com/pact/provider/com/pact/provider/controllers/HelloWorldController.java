package com.pact.provider.com.pact.provider.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.pact.provider.com.pact.provider.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public @ResponseBody
    Greeting sayHello(@RequestHeader(value="name", required=true) String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}