package com.example.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @description: 导入导出
 * @createDate: 2021/1/20
 * @author: zbh
 */
public class ExcelUtils {
  public static void main(String[] args) {

  }

  /**
   * 导出
   *
   * @param response
   * @param data
   * @param fileName
   * @param sheetName
   * @param clazz
   * @throws Exception
   */
  public static void writeExcel(HttpServletResponse response, List<? extends Object> data, String fileName, String sheetName, Class clazz) throws Exception {
    //表头样式
    WriteCellStyle headWriteCellStyle = new WriteCellStyle();
    //设置表头居中对齐
    headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
    //内容样式
    WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
    //设置内容靠左对齐
    contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
    HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    EasyExcel.write(getOutputStream(fileName, response), clazz).excelType(ExcelTypeEnum.XLSX).sheet(sheetName).registerWriteHandler(horizontalCellStyleStrategy).doWrite(data);
  }

  private static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
    fileName = URLEncoder.encode(fileName, "UTF-8");
    response.setContentType("application/vnd.ms-excel");
    response.setCharacterEncoding("utf8");
    response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
    return response.getOutputStream();
  }
}

