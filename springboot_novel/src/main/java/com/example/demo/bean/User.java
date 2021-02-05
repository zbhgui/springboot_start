package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @createDate: 2021/2/3
 * @author:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private String username;
  private String password;
  private Book book;
}
