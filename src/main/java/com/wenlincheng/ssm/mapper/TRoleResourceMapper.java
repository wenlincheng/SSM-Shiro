package com.wenlincheng.ssm.mapper;

import com.wenlincheng.ssm.pojo.TRoleResource;
import com.wenlincheng.ssm.pojo.TRoleResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRoleResourceMapper {
    int countByExample(TRoleResourceExample example);

    int deleteByExample(TRoleResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRoleResource record);

    int insertSelective(TRoleResource record);

    List<TRoleResource> selectByExample(TRoleResourceExample example);

    TRoleResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRoleResource record, @Param("example") TRoleResourceExample example);

    int updateByExample(@Param("record") TRoleResource record, @Param("example") TRoleResourceExample example);

    int updateByPrimaryKeySelective(TRoleResource record);

    int updateByPrimaryKey(TRoleResource record);
}