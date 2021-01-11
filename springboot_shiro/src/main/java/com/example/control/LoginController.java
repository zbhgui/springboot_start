package com.example.control;

import com.example.domain.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @createDate: 2020/12/31
 * @author:
 */
@Controller
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(String username, String password) {
    //获取主体对象
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(new UsernamePasswordToken(username, password));
      return "redirect:/index.jsp";
    } catch (UnknownAccountException e) {
      System.out.println("用户名错误");
    } catch (IncorrectCredentialsException e) {
      System.out.println("密码错误");
    }
    return "redirect:/login.jsp";
  }

  @GetMapping(value = "/logout")
  public String logout() {
    //获取主体对象
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return "redirect:/login.jsp";

  }

  @RequestMapping(value = "/register")
  public String register(String username, String password) {
    try {
      User user = new User();
      user.setUserName(username);
      user.setPassword(password);
      userService.save(user);
      System.out.println("注册成功");
    } catch (Exception e) {
      e.printStackTrace();
      return "redirect:/register.jsp";
    }
    return "redirect:/login.jsp";
  }
}
