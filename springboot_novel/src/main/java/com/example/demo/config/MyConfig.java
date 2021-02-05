package com.example.demo.config;

import com.example.demo.bean.Book;
import com.example.demo.bean.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、@Configuration 告诉SpringBoot这是一个配置类 == 配置文件
 * 2、配置类使用@Bean标注在方法上是在容器注册组件，默认是单实例的
 *  2.1、@Bean标注在方法上，以方法名作为组件的id,返回类型就是组件类型
 *  2.2、更改注册组件的id，@Bean("组件id")
 * 3、配置类本身也是组件
 * 4、proxyBeanMethods属性,代理Bean的方法
 *  4.1、@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件是否在容器中偶遇，保持组件单实例
 *  4.2、@Configuration(proxyBeanMethods = false)本实例调用方法，会创建多个对象，
 *  4.3、解决组件依赖
 */
@Import({User.class,Book.class})  //给容器中自动创建出这两个类型的组件
@Configuration(proxyBeanMethods = true)
public class MyConfig {

  @Bean
  public Book getBook01(){
    Book book = new Book();
    book.setId(100);
    book.setName("火与剑");
    return book;
  }

  /**
   * 外部无论
   * @return
   */
  @Bean("张三")
  public User user01(){
    User user = new User();
    user.setUsername("张三");
    user.setPassword("123456");
    user.setBook(getBook01());
    return user;
  }
}
