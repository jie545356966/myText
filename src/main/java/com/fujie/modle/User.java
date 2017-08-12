package com.fujie.modle;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 此类描述的是：测试用户类
 * @author: fujie
 * @version: 2017年7月10日 上午11:48:24
 */
public class User {
	
	private Integer id;
	private Long code;
	private String name;
	private String password;
	private Integer sex;
	private Integer age;
	private Date birthday;
	private String content;
//	private Set<String> hobby;
//	private List<String> specialty;
//	private Map<Integer,String> jobs;
//	private Map<String,Object> contact;
//	private String phone;
	
	public User(){}
	
	public User(Integer id,Long code,String name,String password,Integer age,String content){
		this.content = content;
		this.age = age;
		this.id = id;
		this.code = code;
		this.name = name;
		this.password = password;

	}
	public User(String name,Integer age){
		this.age = age;
		this.name = name;
	}
	
	
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public Set<String> getHobby() {
//		return hobby;
//	}
//	public void setHobby(Set<String> hobby) {
//		this.hobby = hobby;
//	}
//	public List<String> getSpecialty() {
//		return specialty;
//	}
//	public void setSpecialty(List<String> specialty) {
//		this.specialty = specialty;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Map<String,Object> getContact() {
//		return contact;
//	}
//	public void setContact(Map<String,Object> contact) {
//		this.contact = contact;
//	}
//	public Map<Integer,String> getJobs() {
//		return jobs;
//	}
//	public void setJobs(Map<Integer,String> jobs) {
//		this.jobs = jobs;
//	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
