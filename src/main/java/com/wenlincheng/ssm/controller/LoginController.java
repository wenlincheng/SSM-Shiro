package com.wenlincheng.ssm.controller;

import com.wenlincheng.ssm.log.Log;
import com.wenlincheng.ssm.pojo.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @MethodName: LoginController
 * @Description: 用户登录
 * @Params: 
 * @Return:  
 * @Author: Cheng
 * @Date: 2018/11/1 0:23
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SessionDAO sessionDAO;

    /**
     * @MethodName: login
     * @Description: 登录页面跳转
     * @Params: []
     * @Return: java.lang.String 
     * @Author: Cheng
     * @Date: 2018/11/1 0:24
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");

        return modelAndView;
    }

    /**
     * @MethodName: login
     * @Description: 提交登录
     * @Params: [user, model]
     * @Return: java.lang.String 
     * @Author: Cheng
     * @Date: 2018/11/1 0:24
     */
    @Log(methodDesc="用户登录")
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public ModelAndView login(TUser user, boolean rememberMe, ModelAndView modelAndView){
        System.out.println("登录");
        System.out.println(rememberMe);

        String username = user.getUserName();
        String password = user.getUserPassword();

        logger.debug("username => " + username);
        logger.debug("password => " + password);

        // 将用户名和密码放入token中，通过shiro 验证登录
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        // 重复登录 踢出系统
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for(Session session:sessions){

            if(token.getUsername().equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
                // 设置 session 立即失效，即将其踢出系统
                session.setTimeout(0);
                break;
            }
        }

        if (rememberMe){
            // 记录用户
            token.setRememberMe(true);
        }

        Subject subject = SecurityUtils.getSubject();

        String msg = null;
        try {
            // 登录验证，验证失败会抛出异常，可以在 userService.login 中抛出，这里进行捕获
            subject.login(token);

        } catch (UnknownAccountException e) {
            e.printStackTrace();
            msg = e.getMessage();
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            msg = "用户名和密码不匹配";
        } catch (LockedAccountException e){
            e.printStackTrace();
            msg = e.getMessage();
        }

        // 登录成功,重定向到首页
        if(msg == null){
            modelAndView.setViewName("redirect:/admin/index");
            return modelAndView;
        }
        // 登录失败 页面跳转到登录页面 并显示提示信息
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("/login");

        return modelAndView;
    }

    /**
     * @MethodName: logout
     * @Description: 退出登录
     * @Params: [model]
     * @Return: java.lang.String 
     * @Author: Cheng
     * @Date: 2018/11/1 0:28
     */
    @Log(methodDesc="用户退出登录")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView logout(ModelAndView modelAndView){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        modelAndView.setViewName("login");

        return modelAndView;
    }

}
