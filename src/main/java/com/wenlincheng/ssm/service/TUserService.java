package com.wenlincheng.ssm.service;

import com.wenlincheng.ssm.pojo.TResource;
import com.wenlincheng.ssm.pojo.TUser;

import java.util.List;

/**
 * @ClassName: TUserService
 * @Description: 用户
 * @Author: Cheng
 * @Date: 2019/1/21 20:56
 * @Version: 1.0.0
 */
public interface TUserService {

    /**
     * @MethodName: getByName
     * @Description: 根据用户名查询用户
     * @Params: [userName]
     * @Return: com.wenlincheng.ssm.pojo.TUser
     * @Author: Cheng
     * @Date: 2019/1/21 21:07
     */
    TUser getByName(String userName);

}
