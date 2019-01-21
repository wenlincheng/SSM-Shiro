package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TUserRoleMapper;
import com.wenlincheng.ssm.pojo.TUserRole;
import com.wenlincheng.ssm.pojo.TUserRoleExample;
import com.wenlincheng.ssm.service.TUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserRoleServiceImpl
 * @Description: 用户角色关联
 * @Author: Cheng
 * @Date: 2019/1/21 22:08
 * @Version: 1.0.0
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements TUserRoleService {

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Override
    public List<TUserRole> getByUid(int userId) {

        TUserRoleExample userRoleExample = new TUserRoleExample();

        TUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TUserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);

        return userRoleList;
    }
}
