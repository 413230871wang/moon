package com.moon.extension.poi.mapper;

import com.moon.extension.poi.model.ResultTest;
import com.moon.extension.poi.model.ResultTestExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultTestMapper {
    int countByExample(ResultTestExample example);

    int deleteByExample(ResultTestExample example);

    int deleteByPrimaryKey(String idNo);

    int insert(ResultTest record);

    int insertSelective(ResultTest record);

    List<ResultTest> selectByExample(ResultTestExample example);

    ResultTest selectByPrimaryKey(String idNo);

    int updateByExampleSelective(@Param("record") ResultTest record, @Param("example") ResultTestExample example);

    int updateByExample(@Param("record") ResultTest record, @Param("example") ResultTestExample example);

    int updateByPrimaryKeySelective(ResultTest record);

    int updateByPrimaryKey(ResultTest record);

    Map<String, Object> selectMapByPrimaryKey(@Param("idNo") String s);
}