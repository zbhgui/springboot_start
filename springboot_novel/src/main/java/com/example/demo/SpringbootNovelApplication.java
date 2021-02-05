package com.example.demo;

import com.example.demo.bean.Book;
import com.example.demo.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example")

public class SpringbootNovelApplication {

  public static void main(String[] args) {
    //1.IOC容器
    ConfigurableApplicationContext context = SpringApplication.run(SpringbootNovelApplication.class, args);
    String[] beanNames = context.getBeanDefinitionNames();
    for (String name:  beanNames
         ) {
      System.out.println(name);
    }
    Book book = context.getBean("getBook01", Book.class);
    User user = context.getBean("张三", User.class);
    System.out.println(book == user.getBook());

    String[] users = context.getBeanNamesForType(User.class);
    for (String s : users) {
      System.out.println(s);
    }
  }
}
