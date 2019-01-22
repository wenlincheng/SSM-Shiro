package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TRolePermissionMapper;
import com.wenlincheng.ssm.pojo.TRolePermission;
import com.wenlincheng.ssm.pojo.TRolePermissionExample;
import com.wenlincheng.ssm.service.TRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: RolePermissionServiceImpl
 * @Description: 角色权限关联
 * @Author: Cheng
 * @Date: 2019/1/21 22:04
 * @Version: 1.0.0
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements TRolePermissionService {

    @Autowired
    private TRolePermissionMapper rolePermissionMapper;

    @Override
    public List<TRolePermission> getByRid(int roleId) {

        TRolePermissionExample rolePermissionExample = new TRolePermissionExample();

        TRolePermissionExample.Criteria criteria = rolePermissionExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);

        List<TRolePermission> rolePermissionList = rolePermissionMapper.selectByExample(rolePermissionExample);

        return rolePermissionList;
    }
}
