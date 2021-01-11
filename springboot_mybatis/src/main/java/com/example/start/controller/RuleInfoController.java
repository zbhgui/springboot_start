package com.example.start.controller;

import com.example.start.pojo.LoanRuleInfo;
import com.example.start.service.RuleInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/oracle")
public class RuleInfoController {
  @Resource
  private RuleInfoService ruleInfoService;

  @RequestMapping(value = "/selectByCallNo/{callNo}",method = RequestMethod.GET)
  public List<LoanRuleInfo> selectByCallNo(@PathVariable("callNo") String callNo) {
    return ruleInfoService.selectByCallNo(callNo);
  }
}
