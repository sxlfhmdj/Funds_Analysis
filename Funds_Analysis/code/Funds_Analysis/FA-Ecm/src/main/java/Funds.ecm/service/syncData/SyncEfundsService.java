package Funds.ecm.service.syncData;

/**
 * <p>Description: [同步易方达数据服务]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/12/1
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public interface SyncEfundsService {

    /**
     * <p>Discription: [同步易方达基金信息数据到数据库中] </p>
     * Created on: 2017/12/1 14:27
     *
     * @param
     * @return
     * @author [邓江]
     */
    public void syncFundInfoOfEfunds();

    /**
     * <p>Discription: [同步易方达基金投资组合数据到数据库中] </p>
     * Created on: 2017/12/1 14:29
     *
     * @param
     * @return
     * @author [邓江]
     */
    public void syncFundPortfolioOfEfunds();
}
