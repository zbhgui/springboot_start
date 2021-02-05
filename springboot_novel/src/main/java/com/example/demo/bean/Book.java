package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @createDate: 2020/11/24
 * @author:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
  private Integer id;
  private String name;
  private String author;
  private String createdate;
  private String info ;
}
