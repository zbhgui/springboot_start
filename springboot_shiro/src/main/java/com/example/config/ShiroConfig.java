package com.example.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 用来整合shrio框架相关的配置类
 * @createDate: 2020/12/31
 * @author: zbh
 */
@Configuration
public class ShiroConfig {

  //1.创建shiroFilter  负责拦所有请求
  @Bean
  public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    //给filter设置安全管理器
    shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
    //配置系统受限资源
    //配置系统公告资源
    Map<String,String> map = new HashMap<>();
    //不受限的资源放在上面
    map.put("/user/login","anon");//设置为公共资源
    map.put("/user/logout","anon");//设置为公共资源
    map.put("/user/register","anon");//设置为公共资源
    map.put("/login.jsp","anon");//设置为公共资源
    map.put("/logout.jsp","anon");//设置为公共资源
    map.put("/register.jsp","anon");//设置为公共资源

//    map.put("/index.jsp","authc");//authc 请求这个资源需要认证
    map.put("/**","authc");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

    //设置登录界面
    shiroFilterFactoryBean.setLoginUrl("login.jsp");
    return shiroFilterFactoryBean;
  }
  //2.创建安全管理器
  @Bean
  public DefaultWebSecurityManager getDeafaultWebSecurityManager(CustomerMd5Realm realm){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //给安全管理器设置
    securityManager.setRealm(realm);

    return securityManager;
  }

  //3.创建realm
  @Bean
  public CustomerMd5Realm getCustomerMd5Realm(){
    CustomerMd5Realm realm = new CustomerMd5Realm();
    //修改凭证校验匹配器
    HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
    matcher.setHashAlgorithmName("MD5");
    matcher.setHashIterations(1024);
    realm.setCredentialsMatcher(matcher);
    return realm;
  }

}
