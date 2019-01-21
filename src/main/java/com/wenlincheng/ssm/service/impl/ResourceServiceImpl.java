package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TResourceMapper;
import com.wenlincheng.ssm.pojo.TResource;
import com.wenlincheng.ssm.service.TResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ResourceService
 * @Description: 权限
 * @Author: Cheng
 * @Date: 2019/1/21 22:03
 * @Version: 1.0.0
 */
@Service("resourceService")
public class ResourceServiceImpl implements TResourceService {

    @Autowired
    private TResourceMapper resourceMapper;

    @Override
    public TResource getById(int resourceId) {

        TResource resource = resourceMapper.selectByPrimaryKey(resourceId);

        return resource;
    }
}
