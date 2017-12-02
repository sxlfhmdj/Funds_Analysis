package Funds.dao.root.fund.dao;

import java.math.BigDecimal;
import java.util.Date;

public class FundInfo {
    private String fundCode;

    private String fundName;

    private String shortName;

    private String fundPy;

    private String fundType;

    private String fundCompany;

    private String riskLvl;

    private Date setUpDt;

    private String hostPer;

    private BigDecimal fundScale;

    private Date createDt;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName == null ? null : fundName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getFundPy() {
        return fundPy;
    }

    public void setFundPy(String fundPy) {
        this.fundPy = fundPy == null ? null : fundPy.trim();
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType == null ? null : fundType.trim();
    }

    public String getFundCompany() {
        return fundCompany;
    }

    public void setFundCompany(String fundCompany) {
        this.fundCompany = fundCompany == null ? null : fundCompany.trim();
    }

    public String getRiskLvl() {
        return riskLvl;
    }

    public void setRiskLvl(String riskLvl) {
        this.riskLvl = riskLvl == null ? null : riskLvl.trim();
    }

    public Date getSetUpDt() {
        return setUpDt;
    }

    public void setSetUpDt(Date setUpDt) {
        this.setUpDt = setUpDt;
    }

    public String getHostPer() {
        return hostPer;
    }

    public void setHostPer(String hostPer) {
        this.hostPer = hostPer == null ? null : hostPer.trim();
    }

    public BigDecimal getFundScale() {
        return fundScale;
    }

    public void setFundScale(BigDecimal fundScale) {
        this.fundScale = fundScale;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}