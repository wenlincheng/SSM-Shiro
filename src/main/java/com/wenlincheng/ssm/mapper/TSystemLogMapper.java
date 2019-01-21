package com.wenlincheng.ssm.mapper;

import com.wenlincheng.ssm.pojo.TSystemLog;
import com.wenlincheng.ssm.pojo.TSystemLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSystemLogMapper {
    int countByExample(TSystemLogExample example);

    int deleteByExample(TSystemLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSystemLog record);

    int insertSelective(TSystemLog record);

    List<TSystemLog> selectByExample(TSystemLogExample example);

    TSystemLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSystemLog record, @Param("example") TSystemLogExample example);

    int updateByExample(@Param("record") TSystemLog record, @Param("example") TSystemLogExample example);

    int updateByPrimaryKeySelective(TSystemLog record);

    int updateByPrimaryKey(TSystemLog record);
}