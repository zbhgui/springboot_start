package com.example.demo;

import com.alibaba.excel.EasyExcel;

/**
 * @description:
 * @createDate: 2021/1/20
 * @author: zbh
 */
public class EasyExcelDemo {
  public static void main(String[] args) {
   String fileName = "demo.xlsx";
    /**
     * 这里需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
     * 参数一：读取excel文件路径
     * 参数二：读取sheet的一行，将参数封装在DemoData实体类中
     * 参数三L：读取每一行的时候都会执行DemoDataListener监听器
     */
    EasyExcel.write(fileName, EasyExcelDemo.class).sheet("模板测试");
  }
}
