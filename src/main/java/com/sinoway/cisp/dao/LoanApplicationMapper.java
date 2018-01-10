package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.LoanApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoanApplicationMapper {
    int countByExample(LoanApplicationExample example);

    int deleteByExample(LoanApplicationExample example);

    int deleteByPrimaryKey(String sinoid);

    int insert(LoanApplication record);

    int insertSelective(LoanApplication record);

    List<LoanApplication> selectByExample(LoanApplicationExample example);

    LoanApplication selectByPrimaryKey(String sinoid);

    int updateByExampleSelective(@Param("record") LoanApplication record, @Param("example") LoanApplicationExample example);

    int updateByExample(@Param("record") LoanApplication record, @Param("example") LoanApplicationExample example);

    int updateByPrimaryKeySelective(LoanApplication record);

    int updateByPrimaryKey(LoanApplication record);
    
    /**
	 * 通过华道身份证号查询学历
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("SELECT edu from loan_application WHERE sino_cardid=#{sinoCardid} ORDER BY sinotime DESC LIMIT 1")
	String findEduBySinoCardid(String sinoCardid);
}