package com.example.demo;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @description: 自定义加密Realm
 * @createDate: 2020/12/30
 * @author: zbh
 */
public class CustomerMd5Realm extends AuthorizingRealm {
  //授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    //1.获取主身份信息
    System.out.println("主身份信息：" + principals.getPrimaryPrincipal());
    //2.根据身份信息 用户名 获取当前用户的角色信息，以及权限信息
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    //3.赋值查询的角色信息
    authorizationInfo.addRole("admin");
    //4.权限控制符：
    authorizationInfo.addStringPermission("user:*:*");
    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    //1.从token获取用户输入用户名
    String principal = (String) token.getPrincipal();
    if ("admin".equals(principal)) {
      //加密+加盐+hash散列
      //1.用户名 2.密码 3加salt
      SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("admin","e6542b39d28fff4027a7d01c46fd2cb2",
       ByteSource.Util.bytes("x0*7df"), this.getName());
      return authenticationInfo;
    }
    return null;
  }
}
