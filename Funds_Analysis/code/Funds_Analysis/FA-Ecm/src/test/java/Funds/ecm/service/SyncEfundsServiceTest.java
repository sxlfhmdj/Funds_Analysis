package Funds.ecm.service;

import Funds.ecm.EcmApplication;
import Funds.ecm.service.syncData.SyncEfundsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Description: [描述]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/12/1
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EcmApplication.class)
public class SyncEfundsServiceTest {

    @Autowired
    private SyncEfundsService syncEfundsService;


    @Test
    public void syncFundInfoOfEfundsTest(){
        syncEfundsService.syncFundInfoOfEfunds();
    }

    @Test
    public void syncFundPortfolioOfEfundsTest(){
        syncEfundsService.syncFundPortfolioOfEfunds();
    }


}
