package com.fujie.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujie.modle.Result;
import com.fujie.modle.Test;
import com.fujie.service.TestService;


@Controller
@RequestMapping(value="/my")
public class MyController {
	
	private static final Logger logger = Logger.getLogger(MyController.class);
	
	@Autowired
	TestService _testService;
	
	/**
	 * 
	 * 此方法描述的是：测试Mybaits默认分页(内存式)
	 * @author: fujie
	 * @version: 2017年8月3日 下午4:43:57
	 */
	@RequestMapping(value="/queryTest.do",method=RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Object testRowBunds(){
		logger.debug("测试Mybaits内存分页开始");
		Test test = new Test();
		Result result = new Result();
		List<Test> list = new ArrayList<Test>();
		int total = _testService.queryCount();	
		test.setPage(4);
		test.setRows(40);
		test.buildRowBounds(total);
		try {
			list =  _testService.testRowBounds(test);				
			result.setSuccess(true);
			result.setMsg("查询成功");
			result.setObj(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		logger.debug("查询到:"+total+"条数据");
		return result;
	}

}
