package com.example.start.jdbc;

import java.sql.*;

/**
 * @description:
 * @createDate: 2020/11/23
 * @author:
 */
public class Demo {
    public static void main(String[] args) {
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
//      Class.forName("oracle.jdbc.driver.OracleDriver");
            //2.建立连接
            //mysql
            String mysqlurl = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "123456";
            //oracel
//      String oracleurl = "jdbc:oracle:thin:@10.162.1.170:1521:test";
//      String username = "amar_bcfc";
//      String password = "amar";

            try {
                Connection connection = DriverManager.getConnection(mysqlurl, username, password);
                //3.创建对象执行sql语句
                Statement statement = connection.createStatement();
                //4.执行sql
                ResultSet resultSet = statement.executeQuery("select * from sys_user");
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    String createdate = resultSet.getString(4);
                    String info = resultSet.getString(5);
                    System.out.println("id: " + id + ", name: " + name + ", author: " + author + ", createdate: " + createdate + ",info: " + info); }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
