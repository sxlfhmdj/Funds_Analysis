package Funds.test.dto;

/**
 * <p>Description: [描述]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/11/24
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public class FundDto {
    /*基金名称*/
    private String fundName;
    /*基金代码*/
    private String fundCode;
    /*基金拼音*/
    private String fundPy;
    /*基金类型*/
    private String fundType;
    /*基金风险等级*/
    private String riskLvl;
    /*基金详情地址*/
    private String fundInfoUrl;

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundPy() {
        return fundPy;
    }

    public void setFundPy(String fundPy) {
        this.fundPy = fundPy;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getRiskLvl() {
        return riskLvl;
    }

    public void setRiskLvl(String riskLvl) {
        this.riskLvl = riskLvl;
    }

    public String getFundInfoUrl() {
        return fundInfoUrl;
    }

    public void setFundInfoUrl(String fundInfoUrl) {
        this.fundInfoUrl = fundInfoUrl;
    }
}
