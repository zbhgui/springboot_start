package com.example.utils;

import java.util.Random;

/**
 * @description:
 * @createDate: 2020/12/31
 * @author: zbh
 */
public class SaltUtil {

  public static String getSalt(int n){
    char[] chars = "ABCDEFGHIJKLMNOPQRSQTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char achar = chars[new Random().nextInt(chars.length)];
      str.append(achar);
    }
    return str.toString();
  }

  public static void main(String[] args) {
    String salt = getSalt(4);
    System.out.println(salt);
  }
}
