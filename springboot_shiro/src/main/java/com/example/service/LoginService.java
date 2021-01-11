package com.example.service;

import com.example.domain.LoginResult;
import org.springframework.stereotype.Service;

public interface LoginService {
  LoginResult login(String userName, String password);

  void logout();

}
