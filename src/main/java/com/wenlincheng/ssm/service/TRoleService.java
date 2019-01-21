package com.wenlincheng.ssm.service;

import com.wenlincheng.ssm.pojo.TRole;

/**
 * @ClassName: TRoleService
 * @Description: 角色
 * @Author: Cheng
 * @Date: 2019/1/21 21:10
 * @Version: 1.0.0
 */
public interface TRoleService {

    /**
     * @MethodName: getById
     * @Description: 根据 ID 查询角色
     * @Params: [roleId]
     * @Return: com.wenlincheng.ssm.pojo.TRole 
     * @Author: Cheng
     * @Date: 2019/1/21 22:15
     */
    TRole getById(int roleId);
}
