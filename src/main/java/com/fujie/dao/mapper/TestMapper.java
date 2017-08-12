package com.fujie.dao.mapper;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.fujie.modle.Paging;
import com.fujie.modle.Test;
import com.fujie.modle.TypeEntity;

/**
 * 
 * 此类描述的是：
 * @author: fujie
 * @version: 2017年7月15日 下午5:26:58
 */
public interface TestMapper {
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年7月15日 下午5:27:03
	 */
	public void insertTest(Test test);
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年7月15日 下午5:27:07
	 */
	public TypeEntity queryTest();
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年8月1日 上午9:04:16
	 */
	public List<Test> queryList(Paging rowBounds);
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年8月2日 上午11:50:15
	 */
	public int queryCount();
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年8月2日 下午3:58:12
	 */
	public List<Test> testRowBounds(RowBounds rowBounds);
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年8月9日 上午10:45:35
	 */
	public List<Test> testProcedure(Test test);
}
