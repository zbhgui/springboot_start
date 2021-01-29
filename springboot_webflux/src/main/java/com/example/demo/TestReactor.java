package com.example.demo;

import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:
 * @createDate: 2021/1/29
 * @author:
 */
public class TestReactor {
  public static void main(String[] args) {
    //方式一:just方法直接声明
    Flux.just(1,2,3,4);
    Flux.just(1);
    //方式二：数组
    Integer[] arr = {1,2,3,4};
    Flux.fromArray(arr);
    //方式三：集合
    List<Integer> list = new ArrayList<>();
    Flux.fromIterable(list);
    // 方式四：流
    Stream<Integer> stream = list.stream();
    Flux.fromStream(stream);

    Flux.just(1,2,3,4).subscribe(System.out::println);

  }
}
