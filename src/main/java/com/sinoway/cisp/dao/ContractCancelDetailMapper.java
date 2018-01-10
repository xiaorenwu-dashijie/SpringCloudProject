package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.ContractCancelDetail;
import com.sinoway.cisp.entitys.ContractCancelDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractCancelDetailMapper {
    int countByExample(ContractCancelDetailExample example);

    int deleteByExample(ContractCancelDetailExample example);

    int deleteByPrimaryKey(String sinoid);

    int insert(ContractCancelDetail record);

    int insertSelective(ContractCancelDetail record);

    List<ContractCancelDetail> selectByExample(ContractCancelDetailExample example);

    ContractCancelDetail selectByPrimaryKey(String sinoid);

    int updateByExampleSelective(@Param("record") ContractCancelDetail record, @Param("example") ContractCancelDetailExample example);

    int updateByExample(@Param("record") ContractCancelDetail record, @Param("example") ContractCancelDetailExample example);

    int updateByPrimaryKeySelective(ContractCancelDetail record);

    int updateByPrimaryKey(ContractCancelDetail record);
}