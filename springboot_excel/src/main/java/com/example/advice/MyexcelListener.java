package com.example.advice;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.pojo.CreditResultExcel;
import com.example.service.CreditInfoService;

/**
 * @description: 监听批量处理数据
 * @createDate: 2021/1/20
 * @author:
 */
public class MyexcelListener extends AnalysisEventListener<CreditResultExcel> {

  private CreditInfoService creditInfoService;
//  private HttpServletRequest request;
  @Override
  public void invoke(CreditResultExcel creditResult, AnalysisContext analysisContext) {

  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {

  }
}
