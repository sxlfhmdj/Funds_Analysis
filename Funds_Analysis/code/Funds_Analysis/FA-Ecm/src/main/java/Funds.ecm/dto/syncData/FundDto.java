package Funds.ecm.dto.syncData;

import java.util.Date;

/**
 * <p>Description: [描述]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/11/24
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public class FundDto {
    /*基金代码*/
    private String fundCode;
    /*基金简称*/
    private String ShortName;
    /*基金名称*/
    private String fundName;
    /*基金拼音*/
    private String fundPy;
    /*基金类型*/
    private String fundType;
    /*基金风险等级*/
    private String riskLvl;
    /*基金详情地址*/
    private String fundInfoUrl;
    /*基金成立日期*/
    private Date setUpDate;
    /*基金资产规模*/
    private String fundScale;
    /*基金托管人*/
    private String hostPer;

    public String getHostPer() {
        return hostPer;
    }

    public void setHostPer(String hostPer) {
        this.hostPer = hostPer;
    }

    public String getFundScale() {
        return fundScale;
    }

    public void setFundScale(String fundScale) {
        this.fundScale = fundScale;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

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

    public Date getSetUpDate() {
        return setUpDate;
    }

    public void setSetUpDate(Date setUpDate) {
        this.setUpDate = setUpDate;
    }
}
