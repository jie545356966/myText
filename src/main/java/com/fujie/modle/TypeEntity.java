package com.fujie.modle;

import org.springframework.stereotype.Component;

/**
 * 
 * 此类描述的是：
 * @author: fujie
 * @version: 2017年7月18日 下午4:04:17
 */
@Component("type")
public class TypeEntity {
	
	private String  one;
	private String  two;
	private String three;
	private String four;
	
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	public String getTwo() {
		return two;
	}
	public void setTwo(String two) {
		this.two = two;
	}
	public String getThree() {
		return three;
	}
	public void setThree(String three) {
		this.three = three;
	}
	public String getFour() {
		return four;
	}
	public void setFour(String four) {
		this.four = four;
	}
	
}
