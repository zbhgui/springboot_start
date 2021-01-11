package com.example.start.pojo;

import javax.xml.bind.annotation.*;

/**
 * 实体类
 * @author zbh
 * @date 2020-08-06 10:39
 */
@XmlRootElement(name = "AmarRuleService")
@XmlAccessorType(XmlAccessType.FIELD)
public class AmarRuleService {

  @XmlAttribute(name = "TradeCode")
  private String tradeCode;
  @XmlElement(name ="CallNo")
  private String callNo;
  @XmlElement(name ="CallTime")
  private String callTime;
  @XmlElement(name ="CallUserID")
  private String callUserID;
  @XmlElement(name ="SerialNo")
  private String serialNo;
  @XmlElement(name ="CertType")
  private String certType;
  @XmlElement(name ="CertID")
  private String certID;
  @XmlElement(name ="CustomerName")
  private String customerName;
  @XmlElement(name ="Age")
  private String age;
  @XmlElement(name ="Term")
  private String term;
  @XmlElement(name ="Sex")
  private String sex;
  @XmlElement(name ="Marriage")
  private String marriage;
  @XmlElement(name ="Degree")
  private String degree;
  @XmlElement(name ="Mobile")
  private String mobile;
  @XmlElement(name ="ProductCode")
  private String productCode;
  @XmlElement(name ="InnerLoanCurDue")
  private String innerLoanCurDue;
  @XmlElement(name ="InnerLoanStatus")
  private String innerLoanStatus;
  @XmlElement(name ="InnerLoan24Due")
  private String innerLoan24Due;
  @XmlElement(name ="InnerLoan24DueTime")
  private String innerLoan24DueTime;
  @XmlElement(name ="BusinessSum")
  private String businessSum;
  @XmlElement(name ="DebitCard")
  private String debitCard;
  @XmlElement(name ="CustLabel")
  private String custLabel;
  @XmlElement(name ="VerifyDegree")
  private String verifyDegree;
  @XmlElement(name ="Vscore")
  private String vscore;
  @XmlElement(name ="Cscore")
  private String cscore;
  @XmlElement(name ="RelationShip1")
  private String relationShip1;
  @XmlElement(name ="HomeAddr")
  private String homeAddr;
  @XmlElement(name ="LoanSum")
  private String loanSum;
  @XmlElement(name ="UserLabel")
  private String userLabel;
  @XmlAttribute(name ="Status")
  private String status;
  @XmlElement(name ="FinalSum")
  private String finalSum;
  @XmlElement(name ="RuleID")
  private String ruleID;
  @XmlElement(name ="RuleResult")
  private String ruleResult;
  @XmlElement(name ="RuleName")
  private String ruleName;

  /**
   * 测试专用字段
   * @return
   */
  @XmlElement(name ="TestNifa")
  private String testNifa;
  @XmlElement(name ="TestBh")
  private String testBh;
  @XmlElement(name ="TestRh")
  private String testRh;
  @XmlElement(name ="TestAli")
  private String testAli;
  @XmlElement(name ="TestTencent")
  private String testTencent;
  @XmlElement(name ="TestTemp1")
  private String testTemp1;
  @XmlElement(name ="TestTemp2")
  private String testTemp2;

  public String getTradeCode() {
    return tradeCode;
  }

  public AmarRuleService setTradeCode(String tradeCode) {
    this.tradeCode = tradeCode;
    return this;
  }

  public String getCallNo() {
    return callNo;
  }

  public AmarRuleService setCallNo(String callNo) {
    this.callNo = callNo;
    return this;
  }

  public String getCallTime() {
    return callTime;
  }

  public AmarRuleService setCallTime(String callTime) {
    this.callTime = callTime;
    return this;
  }

  public String getCallUserID() {
    return callUserID;
  }

  public AmarRuleService setCallUserID(String callUserID) {
    this.callUserID = callUserID;
    return this;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public AmarRuleService setSerialNo(String serialNo) {
    this.serialNo = serialNo;
    return this;
  }

  public String getCertType() {
    return certType;
  }

  public AmarRuleService setCertType(String certType) {
    this.certType = certType;
    return this;
  }

  public String getCertID() {
    return certID;
  }

  public AmarRuleService setCertID(String certID) {
    this.certID = certID;
    return this;
  }

  public String getCustomerName() {
    return customerName;
  }

  public AmarRuleService setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public String getAge() {
    return age;
  }

  public AmarRuleService setAge(String age) {
    this.age = age;
    return this;
  }

  public String getTerm() {
    return term;
  }

  public AmarRuleService setTerm(String term) {
    this.term = term;
    return this;
  }

  public String getSex() {
    return sex;
  }

  public AmarRuleService setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public String getMarriage() {
    return marriage;
  }

  public AmarRuleService setMarriage(String marriage) {
    this.marriage = marriage;
    return this;
  }

  public String getDegree() {
    return degree;
  }

  public AmarRuleService setDegree(String degree) {
    this.degree = degree;
    return this;
  }

  public String getMobile() {
    return mobile;
  }

  public AmarRuleService setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public String getProductCode() {
    return productCode;
  }

  public AmarRuleService setProductCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

  public String getInnerLoanCurDue() {
    return innerLoanCurDue;
  }

  public AmarRuleService setInnerLoanCurDue(String innerLoanCurDue) {
    this.innerLoanCurDue = innerLoanCurDue;
    return this;
  }

  public String getInnerLoanStatus() {
    return innerLoanStatus;
  }

  public AmarRuleService setInnerLoanStatus(String innerLoanStatus) {
    this.innerLoanStatus = innerLoanStatus;
    return this;
  }

  public String getInnerLoan24Due() {
    return innerLoan24Due;
  }

  public AmarRuleService setInnerLoan24Due(String innerLoan24Due) {
    this.innerLoan24Due = innerLoan24Due;
    return this;
  }

  public String getInnerLoan24DueTime() {
    return innerLoan24DueTime;
  }

  public AmarRuleService setInnerLoan24DueTime(String innerLoan24DueTime) {
    this.innerLoan24DueTime = innerLoan24DueTime;
    return this;
  }

  public String getBusinessSum() {
    return businessSum;
  }

  public AmarRuleService setBusinessSum(String businessSum) {
    this.businessSum = businessSum;
    return this;
  }

  public String getDebitCard() {
    return debitCard;
  }

  public AmarRuleService setDebitCard(String debitCard) {
    this.debitCard = debitCard;
    return this;
  }

  public String getCustLabel() {
    return custLabel;
  }

  public AmarRuleService setCustLabel(String custLabel) {
    this.custLabel = custLabel;
    return this;
  }

  public String getVerifyDegree() {
    return verifyDegree;
  }

  public AmarRuleService setVerifyDegree(String verifyDegree) {
    this.verifyDegree = verifyDegree;
    return this;
  }

  public String getVscore() {
    return vscore;
  }

  public AmarRuleService setVscore(String vscore) {
    this.vscore = vscore;
    return this;
  }

  public String getCscore() {
    return cscore;
  }

  public AmarRuleService setCscore(String cscore) {
    this.cscore = cscore;
    return this;
  }

  public String getRelationShip1() {
    return relationShip1;
  }

  public AmarRuleService setRelationShip1(String relationShip1) {
    this.relationShip1 = relationShip1;
    return this;
  }

  public String getHomeAddr() {
    return homeAddr;
  }

  public AmarRuleService setHomeAddr(String homeAddr) {
    this.homeAddr = homeAddr;
    return this;
  }

  public String getLoanSum() {
    return loanSum;
  }

  public AmarRuleService setLoanSum(String loanSum) {
    this.loanSum = loanSum;
    return this;
  }

  public String getUserLabel() {
    return userLabel;
  }

  public AmarRuleService setUserLabel(String userLabel) {
    this.userLabel = userLabel;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public AmarRuleService setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getFinalSum() {
    return finalSum;
  }

  public AmarRuleService setFinalSum(String finalSum) {
    this.finalSum = finalSum;
    return this;
  }

  public String getRuleID() {
    return ruleID;
  }

  public AmarRuleService setRuleID(String ruleID) {
    this.ruleID = ruleID;
    return this;
  }

  public String getRuleResult() {
    return ruleResult;
  }

  public AmarRuleService setRuleResult(String ruleResult) {
    this.ruleResult = ruleResult;
    return this;
  }

  public String getRuleName() {
    return ruleName;
  }

  public AmarRuleService setRuleName(String ruleName) {
    this.ruleName = ruleName;
    return this;
  }

  public String getTestNifa() {
    return testNifa;
  }

  public AmarRuleService setTestNifa(String testNifa) {
    this.testNifa = testNifa;
    return this;
  }

  public String getTestBh() {
    return testBh;
  }

  public AmarRuleService setTestBh(String testBh) {
    this.testBh = testBh;
    return this;
  }

  public String getTestRh() {
    return testRh;
  }

  public AmarRuleService setTestRh(String testRh) {
    this.testRh = testRh;
    return this;
  }

  public String getTestAli() {
    return testAli;
  }

  public AmarRuleService setTestAli(String testAli) {
    this.testAli = testAli;
    return this;
  }

  public String getTestTencent() {
    return testTencent;
  }

  public AmarRuleService setTestTencent(String testTencent) {
    this.testTencent = testTencent;
    return this;
  }

  public String getTestTemp1() {
    return testTemp1;
  }

  public AmarRuleService setTestTemp1(String testTemp1) {
    this.testTemp1 = testTemp1;
    return this;
  }

  public String getTestTemp2() {
    return testTemp2;
  }

  public AmarRuleService setTestTemp2(String testTemp2) {
    this.testTemp2 = testTemp2;
    return this;
  }

  @Override
  public String toString() {
    return "AmarRuleService{" +
      "tradeCode='" + tradeCode + '\'' +
      ", callNo='" + callNo + '\'' +
      ", callTime='" + callTime + '\'' +
      ", callUserID='" + callUserID + '\'' +
      ", serialNo='" + serialNo + '\'' +
      ", certType='" + certType + '\'' +
      ", certID='" + certID + '\'' +
      ", customerName='" + customerName + '\'' +
      ", age='" + age + '\'' +
      ", term='" + term + '\'' +
      ", sex='" + sex + '\'' +
      ", marriage='" + marriage + '\'' +
      ", degree='" + degree + '\'' +
      ", mobile='" + mobile + '\'' +
      ", productCode='" + productCode + '\'' +
      ", innerLoanCurDue='" + innerLoanCurDue + '\'' +
      ", innerLoanStatus='" + innerLoanStatus + '\'' +
      ", innerLoan24Due='" + innerLoan24Due + '\'' +
      ", innerLoan24DueTime='" + innerLoan24DueTime + '\'' +
      ", businessSum='" + businessSum + '\'' +
      ", debitCard='" + debitCard + '\'' +
      ", custLabel='" + custLabel + '\'' +
      ", verifyDegree='" + verifyDegree + '\'' +
      ", vscore='" + vscore + '\'' +
      ", cscore='" + cscore + '\'' +
      ", relationShip1='" + relationShip1 + '\'' +
      ", homeAddr='" + homeAddr + '\'' +
      ", loanSum='" + loanSum + '\'' +
      ", userLabel='" + userLabel + '\'' +
      ", status='" + status + '\'' +
      ", finalSum='" + finalSum + '\'' +
      ", ruleID='" + ruleID + '\'' +
      ", ruleResult='" + ruleResult + '\'' +
      ", ruleName='" + ruleName + '\'' +
      ", testNifa='" + testNifa + '\'' +
      ", testBh='" + testBh + '\'' +
      ", testRh='" + testRh + '\'' +
      ", testAli='" + testAli + '\'' +
      ", testTencent='" + testTencent + '\'' +
      ", testTemp1='" + testTemp1 + '\'' +
      ", testTemp2='" + testTemp2 + '\'' +
      '}';
  }
}