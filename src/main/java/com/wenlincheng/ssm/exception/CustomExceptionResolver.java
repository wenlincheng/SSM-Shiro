package com.wenlincheng.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CustomExceptionResolver 
 * @Description 自定义异常处理器,404 页面跳转等
 * @author Cheng
 * @date 2018年10月7日 上午11:56:42
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		ex.printStackTrace();

		CustomException customException = null;

		// 如果抛出的是系统自定义异常则直接转换
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			// 如果抛出的不是系统自定义异常则重新构造一个系统错误异常。
			customException = new CustomException("系统错误，请与系统管理 员联系！");
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", customException.getMessage());
		modelAndView.setViewName("404");

		return modelAndView;
	}

}
