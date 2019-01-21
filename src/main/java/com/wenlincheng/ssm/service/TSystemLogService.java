package com.wenlincheng.ssm.service;

import com.wenlincheng.ssm.pojo.TSystemLog;

/**
 * @ClassName: TSystemLogService
 * @Description: 系统日志
 * @Author: Cheng
 * @Date: 2019/1/21 20:59
 * @Version: 1.0.0
 */
public interface TSystemLogService {

    /**
     * @MethodName: addLog
     * @Description: 添加系统日志
     * @Params: [systemLog]
     * @Return: int
     * @Author: Cheng
     * @Date: 2019/1/21 22:41
     */
    int addLog(TSystemLog systemLog);

}
