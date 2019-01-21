package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TUserMapper;
import com.wenlincheng.ssm.pojo.TResource;
import com.wenlincheng.ssm.pojo.TUser;
import com.wenlincheng.ssm.pojo.TUserExample;
import com.wenlincheng.ssm.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: 用户
 * @Author: Cheng
 * @Date: 2019/1/21 21:41
 * @Version: 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements TUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getByName(String userName) {

        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<TUser> userList = userMapper.selectByExample(userExample);

        if (userList.size() > 0){
            return userList.get(0);
        }

        return null;
    }
}
