package com.wenlincheng.ssm.service;

import com.wenlincheng.ssm.pojo.TRoleResource;

import java.util.List;

/**
 * @ClassName: TRoleResourceService
 * @Description: TODO
 * @Author: Cheng
 * @Date: 2019/1/21 21:09
 * @Version: 1.0.0
 */
public interface TRoleResourceService {
    /**
     * @MethodName: getByRid
     * @Description: 根据 roleId 查询 角色权限关联列表
     * @Params: [roleId]
     * @Return: java.util.List<com.wenlincheng.ssm.pojo.TRoleResource>
     * @Author: Cheng
     * @Date: 2019/1/21 21:10
     */
    List<TRoleResource> getByRid(int roleId);

}
