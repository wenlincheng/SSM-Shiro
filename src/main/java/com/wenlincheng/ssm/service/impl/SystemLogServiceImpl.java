package com.wenlincheng.ssm.service.impl;

import com.wenlincheng.ssm.mapper.TSystemLogMapper;
import com.wenlincheng.ssm.pojo.TSystemLog;
import com.wenlincheng.ssm.service.TSystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SystemLogServiceImpl
 * @Description: 系统日志
 * @Author: Cheng
 * @Date: 2019/1/21 22:42
 * @Version: 1.0.0
 */
@Service("systemLogService")
public class SystemLogServiceImpl implements TSystemLogService {

    @Autowired
    private TSystemLogMapper systemLogMapper;

    @Override
    public int addLog(TSystemLog systemLog) {

        int i = systemLogMapper.insert(systemLog);

        return i;
    }
}
