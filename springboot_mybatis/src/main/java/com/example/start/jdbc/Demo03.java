package com.example.start.jdbc;

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
public class Demo03 {
  public void sqlTest(DataSource dataSource) throws SQLException {
    Connection conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement("select  * from book");
    ResultSet rs = ps.executeQuery();
    while (rs.next()){
      String id = rs.getString("id");
      String name = rs.getString(2);
      String author = rs.getString(3);
      String createdate = rs.getString(4);
      String info = rs.getString(5);
      System.out.println("id: " + id +", name: "+name+", author: "+ author+", createdate: " + createdate +",info: "+ info);
    }
    rs.close();
    ps.close();
    conn.close();
  }
}
