package com.example.service;

import com.example.domain.User;

public interface UserService {

  User findByUserName(String userName);

  void save(User user);

}
