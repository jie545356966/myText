package com.fujie.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fujie.modle.Book;
import com.fujie.modle.MyUser;
import com.fujie.modle.ResultData;
import com.fujie.modle.ResultData.ResultEnum;
import com.fujie.modle.Sport;
import com.fujie.modle.Test;
import com.fujie.modle.TypeEntity;
import com.fujie.modle.User;
import com.fujie.service.TestService;
import com.fujie.service.UserService;
import com.fujie.uitls.JsonUtil;




/**
 * 
 * 此类描述的是：测试MVC
 * @author: fujie
 * @version: 2017年7月10日 下午4:43:11
 */
@Controller
@RequestMapping(value="/myTest")
public class TestController {
	private static final Logger logger = Logger.getLogger(TestController.class);
		private String JSESSIONID = new String();
		private User user = new User();
		
		@Autowired
		private UserService userService;
		@Autowired
		private TestService testService;
		/**
		 * 
		 * 此方法描述的是：返回请求页面test.jsp
		 * @author: fujie
		 * @version: 2017年7月10日 下午4:43:24
		 */
		@RequestMapping("/test.do")
		public String test(){
			System.out.println("返回请求页面test.jsp");
			return "test";
		}

		/**
		 * 
		 * 此方法描述的是：
		 * @author: fujie
		 * @version: 2017年7月10日 下午4:43:28
		 */
		//@RequestMapping请求 value是请求地址 可以设置多个 格式value={"/test01.do","/test02.do","/test03.do"}
		//请求方式配置 method={RequestMethod.GET,RequestMethod.POST}
		//@RequestHeader 获取请求头
		//@RequestParam 获取请求体
		//@CookieValue 获取Cookie内容
		@RequestMapping(value="/test01.do",method={RequestMethod.GET,RequestMethod.POST})
		public String test01(@RequestHeader("Accept") String accept,
				@RequestHeader("Accept-Encoding")String acceptEncoding,
				@RequestHeader("Accept-Language")String  acceptLanguage,
				@RequestHeader("Connection")String connection,
				@RequestHeader("Content-Type")String contentType,
				@RequestHeader("Cookie")String cookies,
				@RequestHeader("Host")String host,
				@RequestHeader("Origin")String origin,
				@RequestHeader("User-Agent")String userAgent,
				@CookieValue("JSESSIONID") String cookie,
				@RequestParam("name") String name,@RequestParam("age") Integer age,Model model){
			System.out.println("请求到test01");
			
			System.out.println("--------------请求头文件---------------");
			System.out.println("Accept:"+accept);
			System.out.println("Accept-Encoding:"+acceptEncoding);
			System.out.println("Accept-Language:"+acceptLanguage);
			System.out.println("Connection:"+connection);
			System.out.println("Content-Type:"+contentType);
			System.out.println("Cookie:"+cookies);
			System.out.println("Host:"+host);
			System.out.println("Origin:"+origin);
			System.out.println("JSESSIONID:"+cookie);
			System.out.println("User-Agent:"+userAgent);

			
			System.out.println("--------------请求体文件---------------");
			System.out.println("姓名等于:"+name);
			System.out.println("年龄等于:"+age);
			System.out.println("模型等于:"+model);
			
			model.addAttribute("content", "这是我自己设置的Attribute");
			model.addAttribute("result","true" );			
			return "test";
		}
		/**
		 * 
		 * 此方法描述的是：
		 * @author: fujie
		 * @version: 2017年7月10日 下午4:43:33
		 */
		@RequestMapping(value="/test02.do",method=RequestMethod.POST)
		public String test2(@ModelAttribute MyUser myUser,Book book,Model model, Sport sport,@RequestBody String body,RedirectAttributes redModel,HttpEntity<String>  httpEntity){
			System.out.println("请求到test02");
			System.out.println("模型:"+model);
			System.out.println("HttpEntity:"+httpEntity);
			System.out.println("报文体:"+body);
			System.out.println("姓名等于:"+myUser.getName());
			System.out.println("年龄等于:"+myUser.getAge());
			System.out.println("书名等于:"+book.getBookName());
			System.out.println("编码等于:"+book.getCode());
			System.out.println("类型等于:"+book.getType());
			System.out.println("运动名等于:"+sport.getName());			
			redModel.addFlashAttribute("myUser", myUser);
			redModel.addFlashAttribute("book", book);
			redModel.addFlashAttribute("sport", sport);
			
			
			return "redirect:/myTest/test.do";			
		}
		/**
		 * 
		 * 此方法描述的是：修改
		 * @author: fujie
		 * @version: 2017年7月10日 下午4:43:37
		 */
		@RequestMapping(value="{id}/editTestForm.do",method={RequestMethod.POST,RequestMethod.GET})
		public String test3(@PathVariable(name="id") Integer id,Model model){
			System.out.println("请求到修改页面");			
			User user = userService.getUser(id);
			model.addAttribute("user",user);	
			  return "testForm";
		}
		
		/**
		 * 
		 * 此方法描述的是：查看
		 * @author: fujie
		 * @version: 2017年7月12日 下午6:06:06
		 */
		@RequestMapping("/testList.do")
		public String testList(Model model){
			System.out.println("请求到用户展示页面");
			List<User> userList =  userService.queryUserAll();
			model.addAttribute("userList",userList);
			if(!userList.isEmpty()){
				model.addAttribute("result",1);
			}else{
				model.addAttribute("result",0);
			}
			return "showTestForm";
		}
		/**
		 * 
		 * 此方法描述的是：新增
		 * @author: fujie
		 * @version: 2017年7月12日 下午6:06:10
		 */
		@RequestMapping("/addTestForm.do")
		public String testForm(Model model,@CookieValue("JSESSIONID") String cookie){
			System.out.println("请求到新增用户页面");
			if(!JSESSIONID.equals(cookie)){		 
				JSESSIONID = cookie;
				User user = userService.initializeUser();
				this	.user = user;		
		    }
			model.addAttribute("user",user);	
		    return "testForm";
		}
		
		/**
		 * 
		 * 此方法描述的是：保存
		 * @author: fujie
		 * @version: 2017年7月12日 下午6:06:29
		 */
		@RequestMapping(value="/testSave.do",method=RequestMethod.POST)
		public String saveTest(@ModelAttribute User user){
			System.out.println("请求到保存数据逻辑");
			if(user.getId()!=0){
				if(userService.addUser(user)){
					System.out.println("新增成功");
				};
			}else{
				if(userService.editUser(user)){
					System.out.println("修改成功");
				};
			}
			return "redirect:/myTest/testList.do";
		}
		@RequestMapping(value="/testAjax.do",method=RequestMethod.POST,consumes = "application/json")
		public @ResponseBody String  ajaxTest(HttpEntity<User>  user){
			  // JSONObject jsonObject = new JSONObject();
//			 try {
				User myUser = user.getBody();
				Map map = new HashMap<String,Object>();
				map.put("user", myUser);
				userService.addUser(myUser);
				List<User> userList = new ArrayList<User>();
				userList = userService.queryUserAll();			
				map.put("userList", JsonUtil.list2json(userList));
			     map.put("message", "请求了一条user数据");  
				 map.put("status", "success");
//			} catch (Exception e) {
//				jsonObject.put("status", "eroor");
//			}
			 return map.toString();
		}
		@RequestMapping(value="/insterTest.do",method=RequestMethod.POST,consumes = "application/json")
		@ResponseBody 
		public Object  inster(@ModelAttribute Test test,HttpServletResponse response){
			//Test myTest = null==test?test:new Test();

			TypeEntity type =  testService.findTest();
			try {
				testService.addTest();								

			} catch (Exception e) {
				
			}
			return type;
		}
		@RequestMapping(value="/queryMybits.do",method=RequestMethod.POST,consumes = "application/json")
		@ResponseBody
		public void TestMybitsCache(){
			TypeEntity type =  testService.findTest();
			try {
				testService.TestMybitsCache();								
			} catch (Exception e) {
			}
		}
}
