package com.example.demo.entity;

/**
 * @description:
 * @createDate: 2021/1/29
 * @author:
 */
public class User {
  private String Name;
  private String password;
  private String url;

  public User(String name, String password, String url) {
    Name = name;
    this.password = password;
    this.url = url;
  }

  public User() {
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
