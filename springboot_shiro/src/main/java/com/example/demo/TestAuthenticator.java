package com.example.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import java.util.ServiceConfigurationError;

/**
 * @description: 单机版学习shiro的权限认证练习Demo01
 * @createDate: 2020/12/30
 * @author: zbh
 */
public class TestAuthenticator {

  public static void main(String[] args) {
    //1.创建安全管理对象
    DefaultSecurityManager securityManager = new DefaultSecurityManager();
    //2.给安全管理器设置Realm
    securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
    //3.SecurityUtils 全局安全工具类 设置安全管理器
    SecurityUtils.setSecurityManager(securityManager);
    //4.Subject 关键对象
    Subject subject = SecurityUtils.getSubject();
    //5.创建安全令牌
    UsernamePasswordToken token = new UsernamePasswordToken("admin", "321");
    try {
      System.out.println("认证状态:" + subject.isAuthenticated());
      subject.login(token);
      System.out.println("校验后认证状态：" + subject.isAuthenticated());
    } catch (UnknownAccountException e) {
      System.out.println("用户不存在");
    } catch (IncorrectCredentialsException e) {
      System.out.println("密码错误");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
