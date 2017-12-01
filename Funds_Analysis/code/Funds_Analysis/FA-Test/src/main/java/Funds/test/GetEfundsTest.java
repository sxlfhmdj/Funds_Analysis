package Funds.test;

import Funds.test.dto.FundDto;
import Funds.test.dto.StockInvestDto;
import Funds.test.util.HtmlUtil;
import com.alibaba.fastjson.JSONObject;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.*;
import org.htmlparser.util.NodeList;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * <p>Description: [获取易方达基金测试类]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/11/23
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 * @desctipion:
 * @reference: HTMLPARSER API - http://htmlparser.sourceforge.net/javadoc/index.html
 */
public class GetEfundsTest {


    /**
     *  Efunds
     *  基金列表网址: https://e.efunds.com.cn/funds
     *  基金详情网址：http://www.efunds.com.cn/html/fund/%s_fundinfo.htm
     *  基金投资组合查询网址: http://query2.efunds.com.cn/view?id=27&fundcode={fundCode}&tab=cominvest&newenddate={queryDate!2017-09-30}
     *
     */


    /**
     * <p>Discription: [测试主方法] </p>
     * Created on: 2017/ -/23 13:11
     *
     * @param
     * @return
     * @author [邓江]
     */
    public static void main(String[] args) {
        String efundsUrl = "https://e.efunds.com.cn/funds";
        GetEfundsTest test = new GetEfundsTest();
        List<FundDto> fundAll = test.getEfunds(efundsUrl);
        List<StockInvestDto> stockInvestAll = new ArrayList<StockInvestDto>();
        for (FundDto fund : fundAll){
            String fundType = fund.getFundType();
            if ("1".equals(fundType) || "4".equals(fundType) || "5".equals(fundType)){
                List<StockInvestDto> stockInvests = test.getStockInvest(fund.getFundCode());
                for (StockInvestDto dto : stockInvests){
                    System.out.println(JSONObject.toJSONString(dto));
                }
                stockInvestAll.addAll(stockInvests);
            }
        }

    }



    /**
     * <p>Discription: [根据URL获取HTML网页] </p>
     * Created on: 2017/11/23 14:01
     *
     * @param
     * @return
     * @author [邓江]
     */
    public List<FundDto> getEfunds(String url) {
        List<FundDto> fundDtos = new ArrayList<FundDto>();
        try {
            //解析通过URL打开的链接
            Parser parser = new Parser(new URL(url).openConnection());

            //基金tr过滤器
            NodeFilter fundsFilter = new NodeFilter() {
                public boolean accept(Node node) {
                    if (node.getText().startsWith("tr fundType")) {
                        return true;
                    }
                    return false;
                }
            };
            //td标签过滤
            NodeFilter tableFilter = new NodeClassFilter(TableTag.class);

//            //a标签过滤器
//            NodeFilter aNodeFilter = new NodeClassFilter(LinkTag.class);


            //过滤获取基金信息的tr标签
            NodeList nodeList = parser.extractAllNodesThatMatch(fundsFilter);

            for (int i = 0; i < nodeList.size(); i++) {
                Node node = nodeList.elementAt(i);
                if (node instanceof TableRow) {
                    TableRow row = (TableRow) node;

                    FundDto fund = new FundDto();
                    String fundCode = row.getAttribute("fCode");
                    fund.setShortName(row.getAttribute("fName"));
                    fund.setFundType(row.getAttribute("fundType"));
                    fund.setFundPy(row.getAttribute("fPy"));
                    fund.setFundCode(fundCode);

                    NodeList childrens = row.getChildren();
                    //获取基金的风险等级
                    if (childrens != null && childrens.size() > 0) {
                        for (int j = 0; j < childrens.size(); j++) {
                            Node risk = childrens.elementAt(j);
                            if (risk instanceof TableColumn) {
                                TableColumn tb_risk = (TableColumn) risk;
                                String tx_risk = tb_risk.getStringText();
                                if (tx_risk.indexOf("风险") != -1) {
                                    fund.setRiskLvl(tx_risk);
                                }
                            }
                        }
                    }

                    //构造基金详情信息URL
                    fund.setFundInfoUrl(String.format("http://www.efunds.com.cn/html/fund/%s_fundinfo.htm", fundCode));
                    fundDtos.add(fund);
                }
            }

            //循环列表获取基金详情信息
            for (FundDto fundDto : fundDtos){
                String url_fundinfo = fundDto.getFundInfoUrl();
                if (url_fundinfo != null && !url_fundinfo.equals("")) {
                    Parser parser_fundinfo = new Parser(new URL(url_fundinfo).openConnection());
                    NodeList tableNode_fundinfos = parser_fundinfo.extractAllNodesThatMatch(tableFilter);
                    if (tableNode_fundinfos != null && tableNode_fundinfos.size() > 0) {
                        //获取基金信息表单
                        TableTag tableTag = (TableTag) tableNode_fundinfos.elementAt(15);
                        for (int i = 0; i < tableTag.getRowCount(); i++) {
                            TableRow row = tableTag.getRow(i);
                            TableColumn[] cols = row.getColumns();
                            if ("基金名称".equals(cols[0].getStringText())){
                                fundDto.setFundName(HtmlUtil.rmHTMLTag(cols[2].getStringText()));
                            }
                            if ("基金合同生效日".equals(cols[0].getStringText())){
                                fundDto.setSetUpDate(HtmlUtil.rmHTMLTag(cols[2].getStringText()));
                            }
                            if ("基金托管人".equals(cols[0].getStringText())){
                                fundDto.setHostPer(HtmlUtil.rmHTMLTag(cols[2].getStringText()));
                            }
                            if ("资产规模".equals(cols[0].getStringText())){
                                fundDto.setFundScale(HtmlUtil.rmHTMLTag(cols[2].getStringText()));
                            }
                        }
                    }
                    fundDtos.add(fundDto);
                    if (fundDto.getFundType().equals("1") || fundDto.getFundType().equals("4") || fundDto.getFundType().equals("5")){
                        System.out.println(JSONObject.toJSONString(fundDto));
                    }
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return fundDtos;
    }


    /**获取基金投资组合数据**/
    public List<StockInvestDto> getStockInvest(String fundCode){
        List<StockInvestDto> stockInvestDtos = new ArrayList<StockInvestDto>();
        int[] months = new int[]{3,6,9,12};
        int[] days = new int[]{31,30,30,31};
        //获取当前日期
        Calendar cal = Calendar.getInstance();
        //当前月份
        int curMonth = cal.get(Calendar.MONTH) + 1;
        //当前年份
        int curYear = cal.get(Calendar.YEAR);
        int startMonth = 1;
        int startYear = curYear;
        int startTmp = 0;
        for (int i = months.length - 1; i >= 0; i--) {
            if (curMonth > months[i]){
                startMonth =  months[i];
                startTmp = i;
                break;
            }
        }
        if (startMonth == 1){
            startYear = startYear -1;
            startMonth = 12;
            startTmp = 3;
        }

        year: for (int i = startYear; i > 2000; i--) {
            if (i == startYear) {
                for (int j = startTmp; j >= 0; j--) {
                    String date = String.format("%s-%s-%s", i, String.format("%02d", months[j]), days[j]);
                    String url = String.format("http://query2.efunds.com.cn/view?id=27&fundcode=%s&tab=cominvest&newenddate=%s", fundCode,date);
                    List<StockInvestDto> addStocks = getStockInvestByQuarter(url, date, fundCode);
                    if (addStocks != null && addStocks.size() > 0) {
                        stockInvestDtos.addAll(addStocks);
                    } else {
                        break year;
                    }
                }
            } else {
                for (int j = 3; j >= 0; j--) {
                    String date = String.format("%s-%s-%s", i, String.format("%02d", months[j]), days[j]);
                    String url = String.format("http://query2.efunds.com.cn/view?id=27&fundcode=%s&tab=cominvest&newenddate=%s", fundCode,date);
                    List<StockInvestDto> addStocks = getStockInvestByQuarter(url, date, fundCode);
                    if (addStocks != null && addStocks.size() > 0) {
                        stockInvestDtos.addAll(addStocks);
                    } else {
                        break year;
                    }
                }
            }


        }

        return stockInvestDtos;
    }

    private List<StockInvestDto> getStockInvestByQuarter(String url, String date, String fundCode){
        List<StockInvestDto> stockInvestDtos = new ArrayList<StockInvestDto>();
        try{
            Parser parser = new Parser(new URL(url).openConnection());
            NodeFilter tableFilter = new NodeClassFilter(TableTag.class);
            NodeList tableNode_stocks = parser.extractAllNodesThatMatch(tableFilter);
            if (tableNode_stocks != null && tableNode_stocks.size() > 17) {
                TableTag tableTag = (TableTag) tableNode_stocks.elementAt(16);
                for (int i = 1; i < tableTag.getRowCount(); i++) {
                    TableRow row = tableTag.getRow(i);
                    TableColumn[] cols = row.getColumns();
                    StockInvestDto stockInvestDto = new StockInvestDto();
                    stockInvestDto.setBelongFundCode(fundCode);
                    stockInvestDto.setStDate(date);
                    stockInvestDto.setSort(Integer.parseInt(HtmlUtil.rmHTMLTag(cols[0].getStringText())));
                    stockInvestDto.setStockCode(HtmlUtil.rmHTMLTag(cols[1].getStringText()));
                    stockInvestDto.setStockName(HtmlUtil.rmHTMLTag(cols[2].getStringText()));
                    stockInvestDto.setStockAmount(HtmlUtil.rmHTMLTag(cols[3].getStringText()));
                    stockInvestDto.setStockWorth(HtmlUtil.rmHTMLTag(cols[4].getStringText()));
                    stockInvestDto.setProport(HtmlUtil.rmHTMLTag(cols[5].getStringText()));
                    stockInvestDtos.add(stockInvestDto);
                    System.out.println(JSONObject.toJSONString(stockInvestDto));
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return stockInvestDtos;
    }

}
