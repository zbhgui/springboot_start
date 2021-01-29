package com.example.demo.handler;

import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @description:  初始化服务器，编写路由Router
 * @createDate: 2021/1/29
 * @author:
 */
public class Server {
  //1.创建Router路由
  public RouterFunction<ServerResponse> routerFunction() {
    UserService userService = new UserServiceImpl();
    UserHandler userHandler = new UserHandler(userService);

    return RouterFunctions.route(
      //设置路由
      GET("/user/{id}").and(accept(MediaType.APPLICATION_JSON)),userHandler::getUserById)
      .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::getAllUser);
  }
  //2.创建服务器完成适配
  public void createReactorServer(){
    //路由和handler适配
    RouterFunction<ServerResponse> route = routerFunction();
    HttpHandler httpHandler = toHttpHandler(route);
    ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

    //创建服务器
    HttpServer httpServer = HttpServer.create();
    httpServer.handle(adapter).bindNow();//现在进行构建

  }
  //、服务器调用,获取 [id: 0xb6e81006, L:/0:0:0:0:0:0:0:0:62227] 的端口62227
  public static void main(String[] args) {
    Server server = new Server();
    server.createReactorServer();
    System.out.println("enter to exit");
    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
