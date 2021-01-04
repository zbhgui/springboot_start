package com.example.start.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @createDate: 2020/11/24
 * @author: zbh
 */
@Configuration
@PropertySource(value = "classpath:druid.properties")
public class DruidConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource(){
    return new DruidDataSource();
  }
  //配置Druid的监控
  //1.配置一个管理后台的Servlet
  @Bean
  public ServletRegistrationBean druidStatViewServlet(){
    ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
    Map<String,String> initParams = new HashMap<>();
    //设置servlet初始化参数
    initParams.put("loginUsername","admin");//登录名
    initParams.put("loginPassword","1234567");//密码
    initParams.put("allow","127.0.0.1");//默认就是允许所有访问。白名单
    initParams.put("deny","192.168.15.12");//IP黑名单
    //是否能够重置数据.
    bean.addInitParameter("resetEnable","false");
    bean.setInitParameters(initParams);
    //加载到容器中
    return bean;
  }
  //2.配置一个web监控的filter
  @Bean
  public FilterRegistrationBean webStatFilter(){
    FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
    bean.setFilter(new WebStatFilter());
    Map<String,String> initParams = new HashMap<>();
    //设置filter的初始化查数
    initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");//排除静态资源和请求
    bean.setInitParameters(initParams);
    //添加过滤规则.
    bean.addUrlPatterns("/*");
    //加载到容器中
    return bean;

  }
}
