package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @createDate: 2021/1/29
 * @author:
 */
@Service
public class UserServiceImpl implements UserService {
  private final Map<Integer,User> map= new HashMap<>();

  public UserServiceImpl(){
    this.map.put(1,new User("张三","123","22"));
    this.map.put(2,new User("李四","321","www"));
    this.map.put(3,new User("王五","231","vvv"));
    this.map.put(4,new User("钱六","132","bbb"));
  }
  @Override
  public Mono<User> getUserById(int id) {
    return Mono.justOrEmpty(this.map.get(id));
  }

  @Override
  public Flux<User> getAllUser() {
    return Flux.fromIterable(this.map.values());
  }

  @Override
  public Mono<Void> addUser(Mono<User> userMono) {
    return userMono.doOnNext(persion->{
      int id = map.size()+1;
      map.put(id,persion);
    }).thenEmpty(Mono.empty());
  }
}
