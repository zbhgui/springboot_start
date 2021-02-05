package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @createDate: 2021/2/1
 * @author: zbh
 */
@RestController
public class HelloWorld {

  @GetMapping("/hello")
  public String helloDemo(@RequestParam(value = "name") String username){
    return "Hello,"+username;
  }
  @GetMapping("/hello/{id}")
  public String helloDemo1(@PathVariable(value = "id") String username){
    return "Hello,"+username;
  }
}

