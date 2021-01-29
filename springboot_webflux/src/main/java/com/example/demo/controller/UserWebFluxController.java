package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @createDate: 2021/1/29
 * @author:
 */
//@RestController 注解式
public class UserWebFluxController {
  @Autowired
  private UserService userService;

  @GetMapping("/user/{id}")
  public Mono<User> getUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @GetMapping("/user")
  public Flux<User> getAllUser() {
    return userService.getAllUser();
  }

  @GetMapping("/saveUser")
  public Mono<Void> saveUser(@RequestBody User user) {
    Mono<User> just = Mono.just(user);
    return userService.addUser(just);
  }

}