package com.example.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.example.advice.DemoDataListener;
import com.example.advice.MyexcelListener;
import com.example.pojo.DemoData;
import com.example.service.CreditInfoService;
import org.assertj.core.api.AbstractCompletableFutureAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.transaction.PlatformTransactionManagerCustomizer;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class SpringbootExcelApplicationTests {

  @Test
  void contextLoads() {



    String fileName = "C:\\Users\\zbh10\\Desktop\\demo.xlsx";
//    EasyExcel.read(fileName,DemoData.class,new MyexcelListener(new CreditInfoService())).sheet().doRead();
    ExcelReader excelread =null;
    try {
      excelread = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
      ReadSheet readSheet = EasyExcel.readSheet(0).build();
      excelread.read(readSheet);
    } finally {
      if(excelread != null){
        excelread.finish();
      }
    }
  }


  @Test
  public void simpleRead() {
    // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
    // 写法1：
    String fileName = "C:\\Users\\zbh10\\Desktop\\demo.xlsx";
    // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
    EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    //写法2：
//    String fileName = "C:\\Users\\zbh10\\Desktop\\demo.xlsx";
    ExcelReader excelReader = null;
    try {
      excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
      ReadSheet readSheet = EasyExcel.readSheet(0).build();
      excelReader.read(readSheet);
    } finally {
      if (excelReader != null) {
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
      }
    }
  }
  /**
   * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
   * <p>
   * 1. 创建excel对应的实体对象 参照{@link DemoData}
   * <p>
   * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
   * <p>
   * 3. 直接读即可
   */
  @Test
  public void repeatedRead() {
    String fileName = "C:\\Users\\zbh10\\Desktop\\demo.xlsx";
    // 读取全部sheet
    // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
    EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).doReadAll();

    // 读取部分sheet
//    String fileName = "C:\\Users\\zbh10\\Desktop\\demo.xlsx";
    ExcelReader excelReader = null;
    try {
      excelReader = EasyExcel.read(fileName).build();

      // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
      ReadSheet readSheet1 =
        EasyExcel.readSheet(0).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
      ReadSheet readSheet2 =
        EasyExcel.readSheet(1).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
      // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
      excelReader.read(readSheet1, readSheet2);
    } finally {
      if (excelReader != null) {
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
      }
    }
  }
}
