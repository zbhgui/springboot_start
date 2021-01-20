package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.StringUtils;
import com.example.pojo.CreditResultExcel;
import com.example.utils.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @createDate: 2021/1/20
 * @author: zbh
 */
@Controller
@RequestMapping("/download")
public class DownloadController {

  /**
   * 下载Excel模板
   * @param response
   */
  @RequestMapping(value = "/excel/template",method = RequestMethod.GET)
  public void downloadTemplate(HttpServletResponse response){
    String fileName = "导入用户模板";
    String sheetName = "导入用户模板";

    List<CreditResultExcel> creditList = new ArrayList<>();
    creditList.add(new CreditResultExcel("C00001","C00001.xml","Error"));
    creditList.add(new CreditResultExcel("C00002","C00002.xml","Error"));
    try {
      ExcelUtils.writeExcel(response,creditList,fileName,sheetName,CreditResultExcel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /**
   * 导出数据
   */
  @RequestMapping(value = "/excel/export",method = RequestMethod.GET)
  public void exportData(HttpServletResponse response){
    String fileName = "结果列表";
    String sheetName = "结果列表";
    List<CreditResultExcel> creditList = new ArrayList<>();
    creditList.add(new CreditResultExcel("C00001","C00001.xml","Error"));
    creditList.add(new CreditResultExcel("C00002","C00002.xml","Error"));
    try {
      ExcelUtils.writeExcel(response,creditList,fileName,sheetName,CreditResultExcel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @PostMapping("/excel/import")
  public void importData(MultipartFile file) throws Exception {
    List<CreditResultExcel> creditList = null;
    //1、excel同步读取数据
    try {
      creditList = EasyExcel.read(new BufferedInputStream(file.getInputStream())).head(CreditResultExcel.class).sheet()
  .doReadSync();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // 2.检查是否大于1000条
    if (creditList.size() > 1000){
      throw new RuntimeException();
    }
    // 3.导入校验所有行列格式
    checkImportData(creditList);
    // 4.将 userExcelList 转成 userList
//    List<User> userList = userExcelList2UserList(userExcelList);
    // 5.入库操作
//    userService.batchInsertOrUpdate(userList);
  }
  private void checkImportData(List<CreditResultExcel> creditResultExcelList) {
    // 行号从第2行开始
    int rowNo = 2;
    // 遍历校验所有行和列
    for (CreditResultExcel resultExcel : creditResultExcelList) {
      // 1.校验用户名
      String username = resultExcel.getReportNo();
      if (StringUtils.isEmpty(username)) {
//        throw new GlobalException(CodeMsg.IMPORT_FIELD_IS_EAMPTY.fillArgs(rowNo, "用户名"));
      }
      if (username.length() > 20 || username.length() < 4) {
//        throw new GlobalException(CodeMsg.IMPORT_FIELD_FORMAT_ERROR.fillArgs(rowNo, "用户名"));
      }
      // 2.校验密码
      String fileName = resultExcel.getFileName();
      if (StringUtils.isEmpty(fileName)) {
//        throw new GlobalException(CodeMsg.IMPORT_FIELD_IS_EAMPTY.fillArgs(rowNo, "密码"));
      }
      if (fileName.length() > 100 || fileName.length() < 6) {
//        throw new GlobalException(CodeMsg.IMPORT_FIELD_FORMAT_ERROR.fillArgs(rowNo, "密码"));
      }
      // 3.校验昵称
      String result = resultExcel.getResult();
      if (StringUtils.isEmpty(result)) {
//        throw new GlobalException(CodeMsg.IMPORT_FIELD_IS_EAMPTY.fillArgs(rowNo, "昵称"));
      }
      if (result.length() > 20 || result.length() < 2) {
//        throw new GlobalException(CodeMsg.IMPORT_FIELD_FORMAT_ERROR.fillArgs(rowNo, "昵称"));
      }
      /** // 4.校验Email
      String email = userExcel.getEmail();
      if (StringUtils.isEmpty(email)) {
        throw new GlobalException(CodeMsg.IMPORT_FIELD_IS_EAMPTY.fillArgs(rowNo, "邮箱"));
      }
      if (!EMAIL_PATTERN.matcher(email).matches()) {
        throw new GlobalException(CodeMsg.IMPORT_FIELD_FORMAT_ERROR.fillArgs(rowNo, "邮箱"));
      }
      // 5.校验状态
      String status = userExcel.getStatus();
      if (StringUtils.isEmpty(status)) {
        throw new GlobalException(CodeMsg.IMPORT_FIELD_IS_EAMPTY.fillArgs(rowNo, "状态"));
      }
      if (!"0".equals(status) && !"1".equals(status)) {
        throw new GlobalException(CodeMsg.IMPORT_FIELD_FORMAT_ERROR.fillArgs(rowNo, "状态"));
      }
      // 6.校验注册时间
      String createdTime = userExcel.getCreatedTime();
      if (StringUtils.isEmpty(createdTime)) {
        throw new GlobalException(CodeMsg.IMPORT_FIELD_IS_EAMPTY.fillArgs(rowNo, "注册时间"));
      }
      try {
        DATE_TIME_FORMAT.parse(createdTime);
      } catch (ParseException e) {
        throw new GlobalException(CodeMsg.IMPORT_FIELD_FORMAT_ERROR.fillArgs(rowNo, "注册时间"));
      }
       */
    }
  }
  /**
   * userExcelList转成userList
   *
   * @return
   */
//  private List<CreditResultExcel> userExcelList2UserList(List<UserExcel> userExcelList) throws ParseException {
////    Date now = new Date();
////    List<User> userList = new ArrayList<>();
////    for (UserExcel userExcel : userExcelList) {
////      User user = User.builder()
////        .username(userExcel.getUsername())
////        .password(userExcel.getPassword())
////        .nickname(userExcel.getNickname())
////        .email(userExcel.getEmail())
////        .avatar(userExcel.getAvatar())
////        .status(Integer.valueOf(userExcel.getStatus()))
////        .createdTime(DATE_TIME_FORMAT.parse(userExcel.getCreatedTime())).build();
////      user.setCreatedBy("import");
////      user.setUpdatedBy("import");
////      user.setUpdatedTime(now);
////      userList.add(user);
////    }
////    return userList;
////  }
  @PostMapping("/excel/Moreimport")
  public void importDataByMoreSheet(MultipartFile file) throws ParseException, IOException {
    List<CreditResultExcel> userExcelList = new ArrayList<>();
    // 1.excel同步读取数据
    try {
      ExcelReader excelReader = EasyExcel.read(new BufferedInputStream(file.getInputStream())).head(CreditResultExcel.class).build();
      List<ReadSheet> sheetList = excelReader.excelExecutor().sheetList();
      List<CreditResultExcel> childUserExcelList = new ArrayList<>();
      for (ReadSheet sheet : sheetList) {
        childUserExcelList = EasyExcel.read(new BufferedInputStream(file.getInputStream())).head(CreditResultExcel.class).sheet(sheet.getSheetNo()).doReadSync();
      }
      userExcelList.addAll(childUserExcelList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 2.检查是否大于1000条
    if (userExcelList.size() > 1000) {
//      throw new GlobalException(CodeMsg.OVER_MAX_USER_IMPORT_LIMIT.fillArgs(MAX_USER_IMPORT));
    }
    // 3.导入校验所有行列格式
    checkImportData(userExcelList);
    // 4.将 userExcelList 转成 userList
//    List<User> userList = userExcelList2UserList(userExcelList);
    // 5.入库操作
//    userService.batchInsertOrUpdate(userList);
  }
}
