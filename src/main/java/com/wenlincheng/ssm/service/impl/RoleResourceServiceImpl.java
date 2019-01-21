package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TRoleResourceMapper;
import com.wenlincheng.ssm.pojo.TRoleResource;
import com.wenlincheng.ssm.pojo.TRoleResourceExample;
import com.wenlincheng.ssm.service.TRoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: RoleResourceServiceImpl
 * @Description: 角色权限关联
 * @Author: Cheng
 * @Date: 2019/1/21 22:04
 * @Version: 1.0.0
 */
@Service("roleResourceService")
public class RoleResourceServiceImpl implements TRoleResourceService {

    @Autowired
    private TRoleResourceMapper roleResourceMapper;

    @Override
    public List<TRoleResource> getByRid(int roleId) {

        TRoleResourceExample roleResourceExample = new TRoleResourceExample();

        TRoleResourceExample.Criteria criteria = roleResourceExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);

        List<TRoleResource> roleResourceList = roleResourceMapper.selectByExample(roleResourceExample);

        return roleResourceList;
    }
}
