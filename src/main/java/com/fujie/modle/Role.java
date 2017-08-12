package com.fujie.modle;
/**
 * 
 * 此类描述的是：角色
 * @author: fujie
 * @version: 2017年8月4日 下午4:08:36
 */
public class Role extends BaseEntity{
	
		/*角色id*/
		private int id;
		/*角色名*/
		private String name;
		/*角色编号*/
		private int code;
		
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
