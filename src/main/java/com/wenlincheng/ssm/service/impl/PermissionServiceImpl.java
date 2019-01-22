package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TPermissionMapper;
import com.wenlincheng.ssm.pojo.TPermission;
import com.wenlincheng.ssm.service.TPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PermissionServiceImpl
 * @Description: 权限
 * @Author: Cheng
 * @Date: 2019/1/21 22:03
 * @Version: 1.0.0
 */
@Service("permissionService")
public class PermissionServiceImpl implements TPermissionService {

    @Autowired
    private TPermissionMapper permissionMapper;

    @Override
    public TPermission getById(int resourceId) {

        TPermission resource = permissionMapper.selectByPrimaryKey(resourceId);

        return resource;
    }
}
