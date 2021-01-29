package com.example.demo.service;

import com.example.demo.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @createDate: 2021/1/29
 * @author:
 */
public interface UserService {
  //一个元素用Mono
  Mono<User> getUserById(int id);
  //多个元素用Flux
  Flux<User> getAllUser();

  Mono<Void> addUser(Mono<User> userMono);
}
