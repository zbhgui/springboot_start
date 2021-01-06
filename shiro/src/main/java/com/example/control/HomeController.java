package com.example.control;

import com.example.domain.LoginResult;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @description: HomeController用来处理登录
 * @createDate: 2020/12/28
 * @author:
 */
@Controller
public class HomeController {
  @Autowired
  private LoginService loginService;

  @RequestMapping({"/","/index"})
  public String index(){
    return"/index";
  }

  @RequestMapping("/403")
  public String unauthorizedRole(){
    System.out.println("------没有权限-------");
    return "/user/403";
  }

  @RequestMapping(value = "/login",method = RequestMethod.GET)
  public String toLogin(Map<String, Object> map, HttpServletRequest request)
  {
    loginService.logout();
    return "/user/login";
  }

  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public String login(Map<String, Object> map, HttpServletRequest request) throws Exception{
    System.out.println("login()");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    LoginResult loginResult = loginService.login(userName,password);
    if(loginResult.isLogin())
    {
      return "/index";
    }
    else {
      map.put("msg",loginResult.getResult());
      map.put("userName",userName);
      return "/user/login";
    }
  }

  @RequestMapping("/logout")
  public String logOut(HttpSession session) {
    loginService.logout();
    return "/user/login";
  }
}
