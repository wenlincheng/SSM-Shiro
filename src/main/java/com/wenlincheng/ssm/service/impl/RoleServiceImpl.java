package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TRoleMapper;
import com.wenlincheng.ssm.pojo.TRole;
import com.wenlincheng.ssm.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RoleServiceImpl
 * @Description: 角色
 * @Author: Cheng
 * @Date: 2019/1/21 22:06
 * @Version: 1.0.0
 */
@Service("roleService")
public class RoleServiceImpl implements TRoleService {

    @Autowired
    private TRoleMapper roleMapper;


    @Override
    public TRole getById(int roleId) {

        TRole role = roleMapper.selectByPrimaryKey(roleId);

        return role;
    }
}
