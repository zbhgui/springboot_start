package com.example.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @createDate: 2021/1/20
 * @author:
 */
@Data
public class DemoData {
  @ExcelProperty(value = "名称",index = 0)
  private String name;
  @ExcelProperty(value = "类型",index = 1)
  private String type;
  @ExcelProperty(value = "注释",index = 2)
  private String comment;
  @ExcelProperty(value = "时间",index = 3)
  private Date date;
  @ExcelProperty(value = "数值",index = 4)
  private double count;
}

