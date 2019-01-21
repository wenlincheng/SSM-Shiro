package com.wenlincheng.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateConverter 
 * @Description 日期转换器
 * @author Cheng
 * @date 2018年10月7日 上午11:53:53
 */
public class DateConverter implements Converter<String, Date> {

	/* (non Javadoc) 
	 * @Title: convert
	 * @Description: TODO
	 * @param arg0
	 * @return 
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object) 
	 */
	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
