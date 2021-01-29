package com.example.demo.handler;

import com.example.demo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @description:
 * @createDate: 2021/1/29
 * @author:
 */
public class Client {
  public static void main(String[] args) {
    //指定服务器调用地址
    WebClient webClient = WebClient.create("http://localhost:62227");
    //根据Id查询
    String id = "1";
    //get()请求，uri()请求方法和参数，block()订阅
    User user = webClient.get().uri("/user/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class)
      .block();
    System.out.println(user.getName());
    //查询所有
    Flux<User> userFlux = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
    //数据转换
    userFlux.map(stu->stu.getName()).buffer().doOnNext(System.out::println).blockFirst();


  }
}
