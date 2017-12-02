package Funds.dao.root.fund.dao;

import java.math.BigDecimal;
import java.util.Date;

public class FundPortfolio {
    private String stockCode;

    private String stockName;

    private BigDecimal stockAmount;

    private BigDecimal stockWorth;

    private String fundCode;

    private String fundName;

    private Date stDt;

    private Integer sort;

    private BigDecimal occupProport;

    private Date createDt;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public BigDecimal getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(BigDecimal stockAmount) {
        this.stockAmount = stockAmount;
    }

    public BigDecimal getStockWorth() {
        return stockWorth;
    }

    public void setStockWorth(BigDecimal stockWorth) {
        this.stockWorth = stockWorth;
    }

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

    public Date getStDt() {
        return stDt;
    }

    public void setStDt(Date stDt) {
        this.stDt = stDt;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public BigDecimal getOccupProport() {
        return occupProport;
    }

    public void setOccupProport(BigDecimal occupProport) {
        this.occupProport = occupProport;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}