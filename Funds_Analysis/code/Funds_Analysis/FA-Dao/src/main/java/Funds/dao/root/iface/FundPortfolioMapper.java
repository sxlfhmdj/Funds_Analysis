package Funds.dao.root.iface;

import Funds.dao.root.dao.FundPortfolio;
import Funds.dao.root.dao.FundPortfolioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundPortfolioMapper {
    long countByExample(FundPortfolioExample example);

    int deleteByExample(FundPortfolioExample example);

    int insert(FundPortfolio record);

    int insertSelective(FundPortfolio record);

    List<FundPortfolio> selectByExample(FundPortfolioExample example);

    int updateByExampleSelective(@Param("record") FundPortfolio record, @Param("example") FundPortfolioExample example);

    int updateByExample(@Param("record") FundPortfolio record, @Param("example") FundPortfolioExample example);
}