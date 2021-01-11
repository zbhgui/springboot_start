package com.example.start.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @createDate: 2020/11/23
 * @author:
 */
@Component
public class Demo01 {
  @Autowired
  private static DataSource dataSource;

  public void sqlTest() throws SQLException {
    Connection connection = dataSource.getConnection();
    PreparedStatement ps =connection.prepareStatement("select * from book");
    ResultSet resultSet = ps.executeQuery();
    while (resultSet.next()){
      String id = resultSet.getString("callno");
      String name = resultSet.getString(2);
      String author = resultSet.getString(3);
      String createdate = resultSet.getString(4);
      String info = resultSet.getString(5);
      System.out.println("id: " + id +", name: "+name+", author: "+ author+", createdate: " + createdate +",info: "+ info);
      break;
    }
  }
}
