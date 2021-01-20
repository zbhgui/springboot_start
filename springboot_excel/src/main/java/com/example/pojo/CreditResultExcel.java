package com.example.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @createDate: 2021/1/20
 * @author: zbh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditResultExcel implements Serializable {
  @ExcelProperty(value = "报告编号",index = 0)
  @ColumnWidth(value = 15)
  private String reportNo;
  @ExcelProperty(value = "文件名称",index = 1)
  @ColumnWidth(value = 30)
  private String fileName;
  @ExcelProperty(value = "结果",index = 2)
  @ColumnWidth(value = 500)
  private String Result;
}
