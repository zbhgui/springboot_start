package com.example.start.service.impl;

import com.example.start.mapper.RuleInfoMapper;
import com.example.start.pojo.LoanRuleInfo;
import com.example.start.service.RuleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RuleInfoServiceImpl implements RuleInfoService {
  @Resource
  private RuleInfoMapper ruleInfoMapper;

  @Override
  public List<LoanRuleInfo> selectByCallNo(String callNo) {
    return ruleInfoMapper.selectByCallNo(callNo);
  }
}