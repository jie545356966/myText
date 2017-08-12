package com.fujie.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fujie.modle.User;
import com.fujie.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	int i = 0;
	Map<Integer,Object> userMap = new HashMap<Integer,Object>();
	Map<Integer,String> jobs = new HashMap<Integer,String>();
	Map<String,Object> contact = new HashMap<String,Object>();
	List<String> specialty = new ArrayList<String>();
	Set<String> hobby = new HashSet<String>();
	

	@Override
	public User getUser(Integer id) {
		return (User) userMap.get(id);
	}

	@Override
	public List<User> queryUserAll() {
		List<User> userList = new ArrayList<User>();
		if(!userMap.isEmpty()){
			for (Integer key : userMap.keySet()) {
				userList.add((User) userMap.get(key));
			}
		}
		return userList;
	}

	@Override
	public Boolean addUser(User user) {
		if(null!=user){
			user.setId(i++);
			userMap.put(i++, user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean editUser( User user) {
		if(null!=user){
			 userMap.put(user.getId(), user);
			 return true;
		}else{
			return false;
		}		
	}

	@Override
	public Boolean delUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delUserAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User initializeUser() {
		User user = new User(0,(long) 000,"输入用户名","输入密码",0,"其他备注信息");
		if(jobs.isEmpty()){
			jobs.put(1, "老师");
			jobs.put(2, "医生");
			jobs.put(3, "律师");
			jobs.put(4, "销售");
			jobs.put(5, "司机");
			jobs.put(5, "程序员");
		}
		if(contact.isEmpty()){
		contact.put("手机", "1xxxxxxxxxx");
		contact.put("邮箱", "xxxxxx@xx.com");
		contact.put("座机", "0731-xxxxxxx");
		}
		if(specialty.isEmpty()){
		specialty.add("吉他");
		specialty.add("踢球");
		specialty.add("游泳");
		specialty.add("溜冰");
		}
		if(hobby.isEmpty()){
		hobby.add("音乐");
		hobby.add("游戏");
		hobby.add("电影");
		hobby.add("吃饭");
		hobby.add("睡觉");
		}
//		user.setContact(contact);
//		user.setHobby(hobby);
//		user.setJobs(jobs);
//		user.setSpecialty(specialty);
		return user;
	}

//	public static void main(String[] args) {
//		UserServiceImpl ser = new UserServiceImpl();
//		User user = ser.initializeUser();
//		ser.addUser(user);
//		System.out.println(user);
//		ser.editUser(1, user);
//		System.out.println(user);
//		
//	}
}
