package com.example.advice;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.DemoDAO;
import com.example.pojo.DemoData;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @createDate: 2021/1/20
 * @author:
 */
@Slf4j
// DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class DemoDataListener extends AnalysisEventListener<DemoData> {
  /**
   * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
   */
  private static final int BATCH_COUNT = 5;
  List<DemoData> list = new ArrayList<>();

  /**
   * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
   */
  private DemoDAO demoDAO;
  public DemoDataListener() {
    // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
    demoDAO = new DemoDAO();
  }
  /**
   * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
   *
   * @param demoDAO
   */
  public DemoDataListener(DemoDAO demoDAO) {
    this.demoDAO = demoDAO;
  }
  /**
   * 这个每一条数据解析都会来调用
   *
   * @param demoData
   * @param analysisContext
   */
  @Override
  public void invoke(DemoData demoData, AnalysisContext analysisContext) {
    log.info("解析到一条数据 {}", JSONObject.toJSONString(demoData));
    list.add(demoData);
    if(list.size() >= BATCH_COUNT){
      saveData();
      // 存储完成清理 list
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
    demoDAO.save(list);
    log.info("存储数据库成功！");
  }
  /**
   * 这里会一行行的返回头
   *
   * @param headMap
   * @param context
   */
  @Override
  public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
    log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
  }
}
