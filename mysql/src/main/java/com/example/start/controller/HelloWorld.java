package com.example.start.controller;

import com.example.start.jdbc.Demo03;
import com.example.start.jdbc.SpringbootUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @description:
 * @createDate: 2020/11/23
 * @author:
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

  @RequestMapping("/getbean")
  public String getBean(){
    DataSource dataSource = (DataSource) SpringbootUtils.getBean("dataSource");
    Demo03 demo03 =new Demo03();
    try {
      demo03.sqlTest(dataSource);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return dataSource.toString();
  }
}
