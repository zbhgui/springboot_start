package com.example.start.service;

import com.example.start.pojo.LoanRuleInfo;

import java.util.List;

public interface RuleInfoService {
  List<LoanRuleInfo> selectByCallNo(String callNo);

}
