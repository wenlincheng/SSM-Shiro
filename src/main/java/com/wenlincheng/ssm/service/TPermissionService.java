package com.wenlincheng.ssm.service;

import com.wenlincheng.ssm.pojo.TPermission;

/**
 * @ClassName: TPermissionService
 * @Description: TODO
 * @Author: Cheng
 * @Date: 2019/1/21 22:01
 * @Version: 1.0.0
 */
public interface TPermissionService {

    TPermission getById(int resourceId);

}
