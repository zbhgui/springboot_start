package com.example.demo.handler;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @description:  创建Handler
 * @createDate: 2021/1/29
 * @author:
 */
public class UserHandler {
  private final UserService userService;

  public UserHandler(UserService userService){
    this.userService = userService;
  }
  //查询单个
  public Mono<ServerResponse> getUserById(ServerRequest request){
    //获取id
    int id = Integer.valueOf(request.pathVariable("id"));
    //调用获取
    Mono<User> userMono = this.userService.getUserById(id);
    //空处理
    Mono<ServerResponse> notfind = ServerResponse.notFound().build();
    //把userMono使用操作符进行转换
    return  userMono.flatMap(persion->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
        .body(userMono,User.class))
        .switchIfEmpty(notfind);//为空返回


  }

  //查询多个
  public Mono<ServerResponse> getAllUser(ServerRequest request){
    //调用获取
    Flux<User> users = this.userService.getAllUser();
    //空处理
    Mono<ServerResponse> notfind = ServerResponse.notFound().build();
    //把userMono使用操作符进行转换
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users,User.class);
  }
  //保存
  public Mono<ServerResponse> saveUser(ServerRequest request){
    //获取数据转成Momo
    Mono<User> userMono = request.bodyToMono(User.class);
    return ServerResponse.ok().build(this.userService.addUser(userMono));
  }

}
