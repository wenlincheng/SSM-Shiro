package com.wenlincheng.ssm.service;

import com.wenlincheng.ssm.pojo.TUserRole;

import java.util.List;

/**
 * @ClassName: TUserRole
 * @Description: 用户角色关联
 * @Author: Cheng
 * @Date: 2019/1/21 21:10
 * @Version: 1.0.0
 */
public interface TUserRoleService {

    /**
     * @MethodName: getByUid
     * @Description: 根据用户id 查询用户角色关联列表
     * @Params: [userId]
     * @Return: java.util.List<com.wenlincheng.ssm.pojo.TUserRole> 
     * @Author: Cheng
     * @Date: 2019/1/21 22:11
     */
    List<TUserRole> getByUid(int userId);

}
