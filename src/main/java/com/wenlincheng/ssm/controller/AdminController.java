package com.wenlincheng.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: AdminController
 * @Description: TODO
 * @Author: Cheng
 * @Date: 2019/1/21 23:22
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * @MethodName: unAuthorization
     * @Description: 首页
     * @Params: [modelAndView]
     * @Return: org.springframework.web.servlet.ModelAndView 
     * @Author: Cheng
     * @Date: 2019/1/21 23:23
     */
    @RequestMapping("/index")
    public ModelAndView unAuthorization(ModelAndView modelAndView){
        modelAndView.setViewName("index");

        return modelAndView;
    }


}
