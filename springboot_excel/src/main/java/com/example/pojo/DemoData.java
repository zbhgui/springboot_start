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
  @ExcelProperty(index = 0)
  private String name;
  @ExcelProperty(index = 1)
  private String type;
  @ExcelProperty(index = 2)
  private String comment;
  @ExcelProperty(index = 3)
  private Date date;
}
