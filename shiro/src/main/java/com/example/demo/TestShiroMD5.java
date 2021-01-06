package com.example.demo;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @description:
 * @createDate: 2020/12/30
 * @author: zbh
 */
public class TestShiroMD5 {
  public static void main(String[] args) {
    //创建一个md5算法
    Md5Hash md5Hash = new Md5Hash("123456");
    String 加密密码 = md5Hash.toHex();
    System.out.println("加密密码: " + 加密密码);
    //使用MD5+salt
    Md5Hash md5Hash1 = new Md5Hash("123456","x0*7df");
    String 加盐加盐密码 = md5Hash1.toHex();
    System.out.println("加盐加盐密码: " + 加盐加盐密码);
    //使用MD5+salt+hash散列
    Md5Hash md5Hash2 = new Md5Hash("123456","x0*7df",2048);
    String 加盐加盐j加散列密码 = md5Hash2.toHex();
    System.out.println("加盐加盐j加散列密码: " + 加盐加盐j加散列密码);
  }
}
