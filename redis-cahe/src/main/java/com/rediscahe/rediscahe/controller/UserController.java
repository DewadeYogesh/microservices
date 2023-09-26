package com.rediscahe.rediscahe.controller;

import com.rediscahe.rediscahe.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

private HashOperations<String,Integer, User> hashops;


public UserController (RedisTemplate<String,User> redisTemplate){
    hashops=redisTemplate.opsForHash();
}

    @PostMapping("/user")
public  String storeData(@RequestBody User user){
  hashops.put("PERSON",user.getUid(),user);
    return "Data Stored sucesfully..... \n" + user.getName()+ " " + user.getUid();
}


    @GetMapping("/user/{uid}")
public  User getData(@PathVariable Integer uid){
    User  value=(User)hashops.get("PERSON",uid);
    return value;
    }

      @GetMapping("/user")
    public List<User> getAllUser(){
    return  hashops.values("PERSON");
    }


       @DeleteMapping("/user/{uid}")
      public  String deleteUser(@PathVariable Integer uid){
    hashops.delete("PERSONS",uid);
    return  "User Deleted";

      }







}
