package com.fujie.modle;

import java.io.Serializable;
import org.springframework.stereotype.Component;
/**
 * 
 * 此类描述的是：
 * @author: fujie
 * @version: 2017年7月15日 下午5:35:23
 */
public class Test extends BaseEntity implements Serializable{
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since Ver 1.1
	 */
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String fempno;
	private String fempname;
	private Integer fage;
	private Integer fsalary;

	
	public Test(){}
	
	public Test(String fempno,String fempname,Integer fage,Integer fsalary){
		this.fage = fage;
		this.fempno = fempno;
		this.fempname = fempname;
		this.fsalary = fsalary;
	}
	public String getFempno() {
		return fempno;
	}
	public void setFempno(String fempno) {
		this.fempno = fempno;
	}
	public String getFempname() {
		return fempname;
	}
	public void setFempname(String fempname) {
		this.fempname = fempname;
	}
	public Integer getFage() {
		return fage;
	}
	public void setFage(Integer fage) {
		this.fage = fage;
	}
	public Integer getFsalary() {
		return fsalary;
	}
	public void setFsalary(Integer fsalary) {
		this.fsalary = fsalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString(){
		return "id:"+id+"-"+"fage:"+fage+"-"+"fempno:"+fempno+"-"+"fempname:"+fempname+"-"+"fsalary:"+fsalary;		
	}
}
