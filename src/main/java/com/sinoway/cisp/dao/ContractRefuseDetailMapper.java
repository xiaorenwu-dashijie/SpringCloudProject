package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.ContractRefuseDetail;
import com.sinoway.cisp.entitys.ContractRefuseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractRefuseDetailMapper {
    int countByExample(ContractRefuseDetailExample example);

    int deleteByExample(ContractRefuseDetailExample example);

    int deleteByPrimaryKey(String sinoid);

    int insert(ContractRefuseDetail record);

    int insertSelective(ContractRefuseDetail record);

    List<ContractRefuseDetail> selectByExample(ContractRefuseDetailExample example);

    ContractRefuseDetail selectByPrimaryKey(String sinoid);

    int updateByExampleSelective(@Param("record") ContractRefuseDetail record, @Param("example") ContractRefuseDetailExample example);

    int updateByExample(@Param("record") ContractRefuseDetail record, @Param("example") ContractRefuseDetailExample example);

    int updateByPrimaryKeySelective(ContractRefuseDetail record);

    int updateByPrimaryKey(ContractRefuseDetail record);
}