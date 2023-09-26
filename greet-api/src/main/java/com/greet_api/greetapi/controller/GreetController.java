package com.greet_api.greetapi.controller;


import com.greet_api.greetapi.client.WelcomeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @Autowired
    private WelcomeApiClient welcomeApiClient;

       @GetMapping("/greet")
    public String greetMsg(){
        String msg="Good Morning, ";
        String welmsg = welcomeApiClient.invokeWelcomeApi();
        return  msg + welmsg;

    }


}
