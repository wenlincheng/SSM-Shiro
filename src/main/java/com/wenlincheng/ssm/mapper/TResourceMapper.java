package com.wenlincheng.ssm.mapper;

import com.wenlincheng.ssm.pojo.TResource;
import com.wenlincheng.ssm.pojo.TResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResourceMapper {
    int countByExample(TResourceExample example);

    int deleteByExample(TResourceExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(TResource record);

    int insertSelective(TResource record);

    List<TResource> selectByExample(TResourceExample example);

    TResource selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByExample(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByPrimaryKeySelective(TResource record);

    int updateByPrimaryKey(TResource record);
}