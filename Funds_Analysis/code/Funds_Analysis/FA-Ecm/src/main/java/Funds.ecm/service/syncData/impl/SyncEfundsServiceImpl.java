package Funds.ecm.service.syncData.impl;

import Funds.common.utils.DateUtil;
import Funds.common.utils.HtmlUtil;
import Funds.common.utils.MathUtil;
import Funds.dao.root.fund.dao.FundInfo;
import Funds.dao.root.fund.dao.FundInfoExample;
import Funds.dao.root.fund.dao.FundPortfolio;
import Funds.dao.root.fund.iface.FundInfoMapper;
import Funds.dao.root.fund.iface.FundPortfolioMapper;
import Funds.ecm.dto.syncData.FundDto;
import Funds.ecm.dto.syncData.StockInvestDto;
import Funds.ecm.service.syncData.SyncEfundsService;
import Funds.entity.FundCompany;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.*;

/**
 * <p>Description: [同步易方达数据服务实现]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/12/1
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
@Service
public class SyncEfundsServiceImpl implements SyncEfundsService{
    @Autowired
    private FundInfoMapper fundInfoMapper;

    @Autowired
    private FundPortfolioMapper fundPortfolioMapper;


    @Transactional
    public void syncFundInfoOfEfunds() {
        List<FundDto> fundOfNets = getEfunds();
        FundInfoExample example = new FundInfoExample();
        FundInfoExample.Criteria criteria = example.createCriteria();
        criteria.andFundCompanyEqualTo(FundCompany.EFUNDS);
        fundInfoMapper.deleteByExample(example);
        if (fundOfNets != null && fundOfNets.size() > 0) {
            for (FundDto dto : fundOfNets){
                FundInfo fund = new FundInfo();
                fund.setFundCode(dto.getFundCode());
                fund.setFundName(dto.getFundName());
                fund.setShortName(dto.getShortName());
                fund.setFundPy(dto.getFundPy());
                fund.setFundCompany(FundCompany.EFUNDS);
                fund.setFundType(dto.getFundType());
                fund.setCreateDt(new Date());
                fund.setHostPer(dto.getHostPer());
                fund.setRiskLvl(dto.getRiskLvl());
                fund.setSetUpDt(dto.getSetUpDate());
                fund.setFundScale(!Strings.isNullOrEmpty(dto.getFundScale().trim())? MathUtil.parseFundScale(dto.getFundScale()) : null);
                fundInfoMapper.insert(fund);
            }
        }
    }


    public void syncFundPortfolioOfEfunds() {
        //获取所有易方达基金：1股票型、4混合型、5指数型
        FundInfoExample example = new FundInfoExample();
        FundInfoExample.Criteria criteria = example.createCriteria();
        criteria.andFundCompanyEqualTo(FundCompany.EFUNDS);
        criteria.andFundTypeIn(Arrays.asList(new String[]{"1","4","5"}));
        List<FundInfo> fundInfos = fundInfoMapper.selectByExample(example);
        if (fundInfos != null && fundInfos.size() > 0){
            for (FundInfo fund : fundInfos){
                List<StockInvestDto> stockInvestDtos = getStockInvest(fund.getFundCode());
                for (StockInvestDto dto : stockInvestDtos){
                    FundPortfolio portfolio = new FundPortfolio();
                    portfolio.setFundCode(fund.getFundCode());
                    portfolio.setFundName(fund.getFundName());
                    portfolio.setCreateDt(new Date());
                    portfolio.setSort(dto.getSort());
                    portfolio.setOccupProport(MathUtil.parseProport(dto.getProport()));
                    portfolio.setStockAmount(MathUtil.parseFundScale(dto.getStockAmount()));
                    portfolio.setStockWorth(MathUtil.parseFundScale(dto.getStockWorth()));
                    portfolio.setStDt(DateUtil.parseToDate(dto.getStDate(),DateUtil.formate_yyyy_MM_dd));
                    portfolio.setStockCode(dto.getStockCode());
                    portfolio.setStockName(dto.getStockName());
                    fundPortfolioMapper.insert(portfolio);
                }
            }
        }
    }

    /**
     * <p>Discription: [获取易方达基金信息] </p>
     * Created on: 2017/12/1 14:43
     *
     * @param
     * @return
     * @author [邓江]
     */
    private List<FundDto> getEfunds() {
        List<FundDto> fundDtos = new ArrayList<FundDto>();
        List<FundDto> rtfundDtos = new ArrayList<FundDto>();
        try {
            //解析通过URL打开的链接
            Parser parser = new Parser(new URL("https://e.efunds.com.cn/funds").openConnection());

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

            //过滤获取基金信息的tr标签
            NodeList nodeList = parser.extractAllNodesThatMatch(fundsFilter);

            for (int i = 0; i < nodeList.size(); i++) {
                Node node = nodeList.elementAt(i);
                if (node instanceof TableRow) {
                    TableRow row = (TableRow) node;

                    FundDto fund = new FundDto();

                    String fundCode = row.getAttribute("fCode");
                    boolean flag = false;
                    for (FundDto dto : fundDtos){
                        if (dto.getFundCode().equals(fundCode)){
                            flag = true;
                        }
                    }
                    if (flag){
                        continue;
                    }
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
                                String dtStr = HtmlUtil.rmHTMLTag(cols[2].getStringText());
                                if ((!Strings.isNullOrEmpty(dtStr))) {
                                    //FIXME 根据shortName 最后一个字符判断基金创建时间是取A B C
                                    if (dtStr.trim().length() > 12) {
                                        fundDto.setSetUpDate(DateUtil.parseToDate(dtStr.trim().substring(dtStr.trim().length() - 11, dtStr.trim().length()), DateUtil.formate_C_yyyyMMdd));
                                    }else if (dtStr.trim().length() == 12){
                                        fundDto.setSetUpDate(DateUtil.parseToDate(dtStr.trim(), DateUtil.formate_C_yyyyMMdd));
                                    }
                                }

                            }
                            if ("基金托管人".equals(cols[0].getStringText())){
                                fundDto.setHostPer(HtmlUtil.rmHTMLTag(cols[2].getStringText()));
                            }
                            if ("资产规模".equals(cols[0].getStringText())){
                                fundDto.setFundScale(HtmlUtil.rmHTMLTag(cols[2].getStringText()));
                            }
                        }
                    }
                    rtfundDtos.add(fundDto);
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return rtfundDtos;
    }


    /**获取基金投资组合数据**/
    private List<StockInvestDto> getStockInvest(String fundCode){
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
