package com.example.start.mapper;

import com.example.start.pojo.LoanRuleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RuleInfoMapper {
  List<LoanRuleInfo> selectByCallNo(String callNo);
}
