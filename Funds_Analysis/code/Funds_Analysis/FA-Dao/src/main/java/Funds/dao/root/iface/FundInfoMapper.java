package Funds.dao.root.iface;

import Funds.dao.root.dao.FundInfo;
import Funds.dao.root.dao.FundInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundInfoMapper {
    long countByExample(FundInfoExample example);

    int deleteByExample(FundInfoExample example);

    int deleteByPrimaryKey(String fundCode);

    int insert(FundInfo record);

    int insertSelective(FundInfo record);

    List<FundInfo> selectByExample(FundInfoExample example);

    FundInfo selectByPrimaryKey(String fundCode);

    int updateByExampleSelective(@Param("record") FundInfo record, @Param("example") FundInfoExample example);

    int updateByExample(@Param("record") FundInfo record, @Param("example") FundInfoExample example);

    int updateByPrimaryKeySelective(FundInfo record);

    int updateByPrimaryKey(FundInfo record);
}