package Funds.test.dto;

public class StockInvestDto {
    /**股票代码**/
    private String stockCode;
    /**股票名称**/
    private String stockName;
    /**股票数量（股）**/
    private String stockAmount;
    /**股票价值（公允价值 元）**/
    private String stockWorth;
    /**所属基金**/
    private String belongFundCode;
    /**统计时间**/
    private String stDate;
    /**所占基金比例**/
    private String proport;
    /**比例排名**/
    private int sort;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(String stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getStockWorth() {
        return stockWorth;
    }

    public void setStockWorth(String stockWorth) {
        this.stockWorth = stockWorth;
    }

    public String getBelongFundCode() {
        return belongFundCode;
    }

    public void setBelongFundCode(String belongFundCode) {
        this.belongFundCode = belongFundCode;
    }

    public String getStDate() {
        return stDate;
    }

    public void setStDate(String stDate) {
        this.stDate = stDate;
    }

    public String getProport() {
        return proport;
    }

    public void setProport(String proport) {
        this.proport = proport;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
