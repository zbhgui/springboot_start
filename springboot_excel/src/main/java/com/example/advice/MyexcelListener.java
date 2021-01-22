package com.example.advice;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.pojo.CreditResultExcel;
import com.example.pojo.DemoData;
import com.example.service.CreditInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 监听器
 * @createDate: 2021/1/20
 * @author:
 */
@Slf4j
//MyexcelListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class MyexcelListener extends AnalysisEventListener<DemoData> {

  //数据量
  private static final  int  BATCH_COUNT=3000;
  List<DemoData> list = new ArrayList<DemoData>();

  private CreditInfoService creditInfoService;
  //构造
  public MyexcelListener(CreditInfoService creditInfoService){
    this.creditInfoService = creditInfoService;
  }
  /**
   * 这个每一条数据解析都会来调用
   *
   * @param demoData
   * @param analysisContext
   */
  @Override
  public void invoke(DemoData demoData, AnalysisContext analysisContext) {
    log.info("解析数据{}", JSON.toJSONString(demoData));
    list.add(demoData);
    if(list.size() >= BATCH_COUNT){
      saveData();
      //清除
      list.clear();
    }
  }

  /**
   * 所有数据解析完成了 都会来调用
   *
   * @param analysisContext
   */
  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    // 这里也要保存数据，确保最后遗留的数据也存储到数据库
    saveData();
  }

  /**
   * 加上存储数据库
   */
  private void saveData() {
    log.info("{}条数据，开始存储数据库！", list.size());
    creditInfoService.save(list);
    log.info("存储数据库成功！");
  }
}
