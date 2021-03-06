package Funds.dao.root.fund.iface;

import Funds.dao.root.fund.dao.FundPortfolio;
import Funds.dao.root.fund.dao.FundPortfolioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundPortfolioMapper {
    long countByExample(FundPortfolioExample example);

    int deleteByExample(FundPortfolioExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FundPortfolio record);

    int insertSelective(FundPortfolio record);

    List<FundPortfolio> selectByExample(FundPortfolioExample example);

    FundPortfolio selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FundPortfolio record, @Param("example") FundPortfolioExample example);

    int updateByExample(@Param("record") FundPortfolio record, @Param("example") FundPortfolioExample example);

    int updateByPrimaryKeySelective(FundPortfolio record);

    int updateByPrimaryKey(FundPortfolio record);
}