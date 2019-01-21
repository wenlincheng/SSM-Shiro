package com.wenlincheng.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: CommonController
 * @Description: TODO
 * @Author: Cheng
 * @Date: 2019/1/21 23:22
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    /**
     * @MethodName: unAuthorization
     * @Description: 未授权页面
     * @Params: [modelAndView]
     * @Return: org.springframework.web.servlet.ModelAndView 
     * @Author: Cheng
     * @Date: 2019/1/21 23:23
     */
    @RequestMapping("/unAuthorization")
    public ModelAndView unAuthorization(ModelAndView modelAndView){
        modelAndView.setViewName("unAuthorization");

        return modelAndView;
    }

    /**
     * @MethodName: error404
     * @Description: 404 页面
     * @Params: [modelAndView]
     * @Return: org.springframework.web.servlet.ModelAndView
     * @Author: Cheng
     * @Date: 2019/1/21 23:24
     */
    @RequestMapping("/404")
    public ModelAndView error404(ModelAndView modelAndView){
        modelAndView.setViewName("404");

        return modelAndView;
    }

}
