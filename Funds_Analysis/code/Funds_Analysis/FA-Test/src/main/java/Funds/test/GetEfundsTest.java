package Funds.test;

import Funds.entity.Fund;
import Funds.test.dto.FundDto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableRow;
import org.htmlparser.util.NodeList;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: [获取易方达基金测试类]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/11/23
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public class GetEfundsTest {


    /**
     * <p>Discription: [测试主方法] </p>
     * Created on: 2017/11/23 13:11
     *
     * @param
     * @return
     * @author [邓江]
     */
    public static void main(String[] args) {
        String efundsUrl = "https://e.efunds.com.cn/funds";
        GetEfundsTest test = new GetEfundsTest();
        test.getEfunds(efundsUrl);
    }



    /**
     * <p>Discription: [根据URL获取HTML网页] </p>
     * Created on: 2017/11/23 14:01
     * @param
     * @return
     * @author [邓江]
     */
    public List<Fund> getEfunds(String url){
        try{
            //解析通过URL打开的链接
            Parser parser = new Parser(new URL(url).openConnection());

            //基金tr过滤器
            NodeFilter fundsFilter = new NodeFilter() {
                public boolean accept(Node node) {
                    if (node.getText().startsWith("tr fundType")){
                        return true;
                    }
                    return false;
                }
            };
            //a标签过滤器
            NodeFilter aNodeFilter = new NodeClassFilter(LinkTag.class);

            //过滤获取基金信息的tr标签
            NodeList nodeList = parser.extractAllNodesThatMatch(fundsFilter);
            //构造接基金收数据数组
            List<FundDto> fundDtos = new ArrayList<FundDto>();

            for(int i = 0; i<nodeList.size();i++){
                Node node = nodeList.elementAt(i);
                if (node instanceof TableRow){
                    TableRow row = (TableRow)node;
                    NodeList tdlist = row.getChildren();
                    for(int j = 0; i<tdlist.size();i++){

                    }
                    LinkTag aTag = null;
                    if (nodeList.elementAt(0) != null){
                        aTag = (LinkTag)nodeList.elementAt(0);
                    }

                    FundDto fund = new FundDto();
                    fund.setFundName(row.getAttribute("fName"));
                    fund.setFundType(row.getAttribute("fundType"));
                    fund.setFundCode(row.getAttribute("fundCode"));
                    if (aTag != null) {
                        fund.setFundInfoUrl(aTag.getAttribute("href"));
                    }
                    fundDtos.add(fund);
                }
            }


            System.out.print(JSONObject.toJSONString(fundDtos));
        }catch (Exception e){
            e.getStackTrace();
        }
        return new ArrayList<Fund>();
    }



}
