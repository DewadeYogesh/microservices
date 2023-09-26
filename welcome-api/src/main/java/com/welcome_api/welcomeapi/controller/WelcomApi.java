package com.welcome_api.welcomeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomApi {
     @Autowired
    private Environment environment;

    @GetMapping("/welcome")
    public String message(){
        String port = environment.getProperty("server.port");
        String msg= "Hello Yogesh " + "( port :: " + port +  ")";
        return msg;
    }

}
