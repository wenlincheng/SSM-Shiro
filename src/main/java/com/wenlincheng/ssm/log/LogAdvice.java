package com.wenlincheng.ssm.log;

/**
 * @ClassName: LogAdvice
 * @Description: 日志切面
 * @Author: Cheng
 * @Date: 2018/11/10 22:26
 * @Version: 1.0.0
 */

import com.wenlincheng.ssm.pojo.TSystemLog;
import com.wenlincheng.ssm.pojo.TUser;
import com.wenlincheng.ssm.service.TSystemLogService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * @ClassName: LogAdvice
 * @Description: 系统日志切面类
 * @Author: Cheng
 * @Date: 2019/1/21 23:32
 */
@Aspect
@Component
public class LogAdvice {

    private Logger log = Logger.getLogger(LogAdvice.class);

    @Autowired
    private TSystemLogService systemLogService;

    /**
     * 配置切入点
     */
    @Pointcut("execution(* com.wenlincheng.ssm.controller..*.*(..))")
    public void controllerAspect() {
    }

    /**
     * @MethodName: after
     * @Description: 后置通知
     * @Params: [joinPoint]
     * @Return: void 
     * @Author: Cheng
     * @Date: 2018/11/11 0:23
     */
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {

        try {

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //获取请求ip
            String ip = request.getRemoteAddr();
            String requestType = request.getMethod();
            String requestURI = request.getRequestURI();

            // 获取用户请求方法的参数并序列化为JSON格式字符串
            TUser user = (TUser) SecurityUtils.getSubject().getPrincipal();
            String username = "游客";
            if (user != null){
                username = user.getUserName();
            }

            //Map<String,String[]> params2 = request.getParameterMap();

            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String methodDesc = "";
            String params = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {

                        if (!method.isAnnotationPresent(Log.class))
                            return;
                        // 获取注解字段
                        methodDesc = method.getAnnotation(Log.class).methodDesc();

                        // 获取参数
                        for (int i = 0; i < arguments.length; i++) {
                            params = params + arguments[i] + (i == arguments.length - 1 ? "" : ",");
                        }
                        break;
                    }
                }
            }
            // 控制台输出
            log.debug("*******Log start*******");
            log.debug("请求方法:"
                    + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.debug("方法描述:" + methodDesc);
            log.debug("请求人:" + username);
            log.debug("请求IP:" + ip);
            log.debug("请求参数：" + params);

            // 写入数据库
            log.debug("*写入数据库*");
            TSystemLog syslog = new TSystemLog();
            //syslog.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            syslog.setMethod(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            syslog.setDescription(methodDesc);
            syslog.setRequestIp(ip);
            syslog.setRequestUsername(username);
            syslog.setExceptionCode(null);
            syslog.setExceptionDetail(null);
            syslog.setCreateDate(new Date());
            syslog.setParams(params);
            syslog.setRequestType(requestType);
            syslog.setRequestUri(requestURI);

            if(params.length() > 100){
                params = params.substring(0, 99);
            }
            syslog.setParams(params);

            int i = systemLogService.addLog(syslog);

            log.debug("*写入数据库完成*");
            log.debug("*******Log end*******");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * @MethodName: doAfterThrowing
     * @Description: 异常通知
     * @Params: [joinPoint, e]
     * @Return: void 
     * @Author: Cheng
     * @Date: 2018/11/11 0:23
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取请求ip
        String ip = request.getRemoteAddr();
        String requestType = request.getMethod();
        String requestURI = request.getRequestURI();

        // 获取用户请求方法的参数并序列化为JSON格式字符串
        TUser user = (TUser) SecurityUtils.getSubject().getPrincipal();
        String username = "游客";
        if (user != null){
            username = user.getUserName();
        }

        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String methodDesc = "";
            String params = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {

                        if (!method.isAnnotationPresent(Log.class))
                            return;

                        methodDesc = method.getAnnotation(Log.class).methodDesc();
                        // 获取参数
                        for (int i = 0; i < arguments.length; i++) {

                            params = params + arguments[i] + (i == arguments.length - 1 ? "" : ",");
                        }
                        break;
                    }
                }
            }

            // 控制台数据
            log.debug("*******ExceptionLog start*******");
            log.debug("请求方法:"
                    + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.debug("方法描述:" + methodDesc);
            log.debug("异常代码:" + e.getClass().getName());
            log.debug("异常信息:" + e.getMessage());
            log.debug("请求人:" + username);
            log.debug("请求IP:" + ip);
            log.debug("请求参数：" + params);

            // 写入数据库
            log.debug("*写入数据库*");
            TSystemLog syslog = new TSystemLog();
            syslog.setMethod(
                    joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            syslog.setDescription(methodDesc);
            syslog.setRequestIp(ip);
            syslog.setExceptionCode(e.getClass().getName());
            syslog.setExceptionDetail(e.getMessage());
            syslog.setCreateDate(new Date());
            syslog.setRequestType(requestType);
            syslog.setRequestUri(requestURI);
            if(params.length() > 100){
                params = params.substring(0, 99);
            }
            syslog.setParams(params);
            // save
            log.debug("*写入数据库完成*");
            log.debug("*******ExceptionLog end*******");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        }

    }
}
