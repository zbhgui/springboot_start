package com.example.demo0129;


import java.util.Observable;

/**
 * @description:
 * @createDate: 2021/1/29
 * @author:
 */
public class Demo extends Observable {
  public static void main(String[] args) {
    Demo  observer = new Demo();
    //添加观察者
    observer.addObserver((o,arg)->{
      System.out.println("发生变化");
    });
    observer.addObserver((o,arg)->{
      System.out.println("手动被观察者通知，准备改变");
    });

    observer.setChanged();    //数据变化
    observer.notifyObservers();//通知
  }

}
