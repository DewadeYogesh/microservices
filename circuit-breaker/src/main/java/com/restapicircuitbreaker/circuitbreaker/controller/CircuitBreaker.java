package com.restapicircuitbreaker.circuitbreaker.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CircuitBreaker {

    @GetMapping("/")
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name="",fallbackMethod = "")
    public String getMessage(){
        System.out.println("Method1() executing");
        String msg ="hello";
        try {
            int i=10/0;
        }
        catch (Exception e){
            return  msg=getMessage1();


        }


        return msg;
    }


    public  String getMessage1(){

        System.out.println("Method()2 executing ");

        String msg="Hi";
        return msg;



    }
}
