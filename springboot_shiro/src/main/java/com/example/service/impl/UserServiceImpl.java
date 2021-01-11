package com.example.service.impl;

import com.example.dao.UserRepository;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @createDate: 2020/12/28
 * @author: zbh
 */
@Service
public class UserServiceImpl implements UserService {
  @Resource
  private UserRepository userRepository;

  @Override
  public User findByUserName(String userName) {
    return userRepository.findByUserName(userName);
  }

  @Override
  public void save(User user) {
    //明文的密码进行Md5加密+salt+hash散列
    //生成随机salt
    String salt = SaltUtil.getSalt(8);
    user.setSalt(salt);
    Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
    user.setPassword(md5Hash.toHex());
    user.setName("管理员");
    user.setState(Byte.valueOf("1"));
    userRepository.save(user);
  }
}
