package Funds.entity;

import java.util.Date;

/**
 * <p>Description: [基金实体]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/11/23
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public class Fund {
    /*基金名称*/
    private String fundName;
    /*基金代码*/
    private String fundCode;
    /*基金简称*/
    private String shortName;
    /*基金拼音*/
    private String fundPy;
    /*基金类型*/
    private String fundType;
    /*基金风险等级*/
    private String riskLvl;
    /*基金成立日期*/
    private Date setUpDate;
    /*基金规模*/
    private String fundScale;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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

    public Date getSetUpDate() {
        return setUpDate;
    }

    public void setSetUpDate(Date setUpDate) {
        this.setUpDate = setUpDate;
    }

    public String getFundScale() {
        return fundScale;
    }

    public void setFundScale(String fundScale) {
        this.fundScale = fundScale;
    }

    public String getFundPy() {
        return fundPy;
    }

    public void setFundPy(String fundPy) {
        this.fundPy = fundPy;
    }
}
