package com.example.control;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: UserController用来测试访问，权限全部采用注解的方式。
 * @createDate: 2020/12/28
 * @author:
 */
@Controller
@RequestMapping("/user")
public class UserController {
  /**
   * 用户查询.
   * @return
   */
  @RequestMapping("/userList")
  @RequiresPermissions("user:view")//权限管理;
  public String userInfo(){
    return "userList";
  }

  /**
   * 用户添加;
   * @return
   */
  @RequestMapping("/userAdd")
  @RequiresPermissions("user:add")//权限管理;
  public String userInfoAdd(){
    return "userAdd";
  }

  /**
   * 用户删除;
   * @return
   */
  @RequestMapping("/userDel")
  @RequiresPermissions("user:del")//权限管理;
  public String userDel(){
    return "userDel";
  }
}
