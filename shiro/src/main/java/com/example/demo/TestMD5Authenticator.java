package com.example.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * @description: 练习Demo03
 * @createDate: 2020/12/30
 * @author:
 */
public class TestMD5Authenticator {
  public static void main(String[] args) {
    //1.创建安全管理器
    DefaultSecurityManager securityManager = new DefaultSecurityManager();
    //2.设置realm使用hash凭证匹配器--start
    CustomerMd5Realm customerMd5Realm = new CustomerMd5Realm();
    //更换凭证匹配器使用算法
    HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
    //设置加密方式
    matcher.setHashAlgorithmName("md5");
    //设置散列值
    matcher.setHashIterations(1024);

    customerMd5Realm.setCredentialsMatcher(matcher);
    //3.注入Realm
    securityManager.setRealm(customerMd5Realm);
    //4.通过安全管理器注入安全工具
    SecurityUtils.setSecurityManager(securityManager);
    //5.通过安全工具类获取subject
    Subject subject = SecurityUtils.getSubject();

    //加密+加盐+hash散列
    Md5Hash md5Hash = new Md5Hash("admin", "x0*7df", 1024);
    String password = md5Hash.toHex();
    System.out.println(password);
    UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
    try{
      subject.login(token);
      System.out.println("登录成功");
    } catch (UnknownAccountException e){
      System.out.println("用户名错误");
    } catch (IncorrectCredentialsException e){
      System.out.println("密码输入错误");
    } catch (Exception e){
      e.printStackTrace();
    }

    //认证用户进行授权,通过认证
    if(subject.isAuthenticated()){
      //1.基于角色权限控制
      System.out.println( subject.hasRole("admin"));
      //2.基于多角色权限控制
      System.out.println(subject.hasAllRoles(Arrays.asList("admin","user","test")));
      //3.是否具有其中一个角色
      boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user", "test"));
      for(boolean b :booleans){
        System.out.println(b);
      }
      //4、基于权限字符串的访问控制 资源标识符:操作：资源类型
      System.out.println("权限控制"+subject.isPermitted("user:create:01"));
    }
  }
}
