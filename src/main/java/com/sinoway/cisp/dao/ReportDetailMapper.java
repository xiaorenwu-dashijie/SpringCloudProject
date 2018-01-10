package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.ReportDetail;

public interface ReportDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportDetail record);

    int insertSelective(ReportDetail record);

    ReportDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReportDetail record);

    int updateByPrimaryKey(ReportDetail record);
}