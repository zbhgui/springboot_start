package com.example.config;

import com.example.dao.UserRepository;
import com.example.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @createDate: 2020/12/31
 * @author: zbh
 */
public class CustomerMd5Realm extends AuthorizingRealm {
  @Autowired
  UserRepository userRepository;
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    String primaryPrincipal = (String)principals.getPrimaryPrincipal();
    if("zbh".equals(primaryPrincipal)){
      SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
      //将数据库中查询的角色信息赋值
      authorizationInfo.addRole("admin");
      //权限控制符：
      authorizationInfo.addStringPermission("user:*:*");
      return authorizationInfo;
    }
    return null;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    System.out.println("身份认证CustomerMd5Realm.doGetAuthenticationInfo");
    String principal = (String)token.getPrincipal();
    String password = new String((char[]) token.getCredentials());
    System.out.println("原始password: "+password);

    User user = userRepository.findByUserName(principal);
    Md5Hash md5Hash = new Md5Hash(password,user.getSalt(),1024);
    password = md5Hash.toHex();
    System.out.println("password:" + password);
    if(user!=null && password.equals(user.getPassword())) {
      return new SimpleAuthenticationInfo(principal, user.getPassword(),ByteSource.Util.bytes(user.getSalt()),this.getName());
    }
    return null;
  }
}
