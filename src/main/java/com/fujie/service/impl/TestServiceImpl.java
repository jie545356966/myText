package com.fujie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujie.dao.mapper.TestMapper;
import com.fujie.modle.Paging;
import com.fujie.modle.Procedure;
import com.fujie.modle.Test;
import com.fujie.modle.TypeEntity;
import com.fujie.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{
	private static final Logger logger = Logger.getLogger(TestServiceImpl.class);
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private Paging page;
	public String fempno;
	public String fempname;
	public Integer fage = 0;
	public Integer fsalary;
	@Override
	public void addTest() {
		Random random = new Random();
		char[] first ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] middle ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] last = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		try {
			for (int i = 0; i < 10; i++) {
				fage++;
				String f = fage+"000";
				fsalary = Integer.valueOf(f);
				fempno = UUID.randomUUID().toString();
				fempname = String.valueOf(first[random.nextInt(25)])+String.valueOf(middle[random.nextInt(25)])+String.valueOf(last[random.nextInt(25)]);
				Test test = new Test(fempno,fempname,fage,fsalary);
				testMapper.insertTest(test);
			}
			logger.info("成功录入");
		} catch (Exception e) {
			e.getMessage();
			logger.info("系统错误!");
		}		
	}
 
	@Override
	public TypeEntity findTest() {
		TypeEntity type =  testMapper.queryTest();
		return type;
	}
	@Override
	public void TestMybitsCache(){

	}

	@Override
	public void TestPaging() {
		Integer totalResult =  testMapper.queryCount();
		List<Test> list = new ArrayList<Test>();
		page.setTotalResult(totalResult);
		
		page.setCurrentPage(1);
		list =  testMapper.queryList(page);
		page.setTotalResult(totalResult);
		
		for (Test test : list) {
			logger.debug(test.toString());
		}
		page.setCurrentPage(2);
		list =  testMapper.queryList(page);
		for (Test test : list) {
			logger.debug(test.toString());
		}
		page.setCurrentPage(3);
		list =  testMapper.queryList(page);
		for (Test test : list) {
			logger.debug(test.toString());
		}
	}
	@Override
	public int queryCount(){
		return testMapper.queryCount();
	};
	@Override
	public List<Test> testRowBounds(Test test){
		int page =  test.getPage();
		int rows =  test.getRows();
		logger.debug("查询内存分页信息");
		return testMapper.testRowBounds(test.getRowBounds());
	}

	@Override
	public List<Test> testProcedure() {
		Procedure procedure = new Procedure();
		procedure.setFields("");
		procedure.setTables("test");
		procedure.setOrderBy("");
		procedure.setWhere("");
		return null;
	}
}
