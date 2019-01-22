package com.wenlincheng.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: IndexController
 * @Description: 首页
 * @Author: Cheng
 * @Date: 2019/1/21 23:22
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * @MethodName: unAuthorization
     * @Description: 首页
     * @Params: [modelAndView]
     * @Return: org.springframework.web.servlet.ModelAndView 
     * @Author: Cheng
     * @Date: 2019/1/21 23:23
     */
    @RequestMapping("/page")
    public ModelAndView unAuthorization(ModelAndView modelAndView){
        modelAndView.setViewName("index");

        return modelAndView;
    }


}
