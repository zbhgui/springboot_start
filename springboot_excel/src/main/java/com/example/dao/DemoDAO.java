package com.example.dao;

import com.example.pojo.DemoData;

import java.util.List;

/**
 * @description:
 * @createDate: 2021/1/20
 * @author:
 */
public class DemoDAO {
  public void save(List<DemoData> list) {
    // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
  }
}
