package com.example.domain;

/**
 * @description:
 * @createDate: 2020/12/28
 * @author:
 */
public class LoginResult {
  private boolean isLogin = false;
  private String result;

  public boolean isLogin() {
    return isLogin;
  }

  public void setLogin(boolean login) {
    isLogin = login;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}
