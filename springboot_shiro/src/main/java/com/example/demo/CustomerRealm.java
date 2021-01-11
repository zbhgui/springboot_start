package com.example.demo;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.logging.SimpleFormatter;

/**
 * @description: 自定义Realm
 * @createDate: 2020/12/30
 * @author: zbh
 */
public class CustomerRealm extends AuthorizingRealm {
  //授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    return null;
  }

  //认证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    //获取用户名
    String principal = (String) token.getPrincipal();
    if ("admin".equals(principal)) {
      //1.用户名 2.正确密码3、提供当前realm
      SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, "admin", this.getName());
      return authenticationInfo;
    }
    return null;

  }
}
