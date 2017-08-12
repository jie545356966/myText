package com.fujie.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringtoDateConvertor  implements Converter<String, Date>{
		
	private String datePattern;
	
	public StringtoDateConvertor(String datePattern){
		this.datePattern = datePattern;
	}

	@Override
	public Date convert(String s) {
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		try {
			format.setLenient(false);
		
			return format.parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("日期格式不正确");
		}
	}

}
