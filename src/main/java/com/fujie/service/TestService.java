package com.fujie.service;

import java.util.List;

import com.fujie.modle.Test;
import com.fujie.modle.TypeEntity;

/**
 * 
 * 此类描述的是：
 * @author: fujie
 * @version: 2017年7月15日 下午5:43:47
 */
public interface TestService {
		/**
		 * 
		 * 此方法描述的是：
		 * @author: fujie
		 * @version: 2017年7月15日 下午5:43:52
		 */
		public void addTest();
		/**
		 * 
		 * 此方法描述的是：
		 * @author: fujie
		 * @version: 2017年7月15日 下午5:43:54
		 */
		public TypeEntity findTest();
		/**
		 * 
		 * 此方法描述的是：
		 * @author: fujie
		 * @version: 2017年8月1日 上午9:21:36
		 */
		public void TestMybitsCache();
		/**
		 * 
		 * 此方法描述的是：分页测试
		 * @author: fujie
		 * @version: 2017年8月2日 上午10:16:13
		 */
		public void TestPaging();
		/**
		 * 
		 * 此方法描述的是：
		 * @author: fujie
		 * @version: 2017年8月2日 下午4:34:04
		 */
		public int queryCount();
		/**
		 * 
		 * 此方法描述的是：通过mybaits的RowBounds方法分页返回
		 * @author: fujie
		 * @version: 2017年8月2日 下午5:30:13
		 */
		public List<Test> testRowBounds(Test test);
		/**
		 * 
		 * 此方法描述的是：
		 * @author: fujie
		 * @version: 2017年8月9日 上午11:28:59
		 */
		public List<Test> testProcedure();
}
