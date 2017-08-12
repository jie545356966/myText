package com.fujie.modle;
/**
 * 
 * 此类描述的是：
 * @author: fujie
 * @version: 2017年7月7日 上午9:00:51
 */
public class Sport {
	public Sport(){}
	public Sport(String  name){
		setName(name);
	}
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
