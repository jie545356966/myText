package com.fujie.service;

import java.util.List;
import java.util.Map;
import com.fujie.modle.User;

/**
 * 
 * 此类描述的是：User测试类
 * @author: fujie
 * @version: 2017年7月10日 下午4:39:35
 */

public interface UserService {
	
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:18:13
	 */
	public User initializeUser();
	/**
	 * 
	 * 此方法描述的是：通过id获取user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:06:46
	 */
	public User getUser(Integer id);
	/**
	 * 
	 * 此方法描述的是：查询全部的User
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:07:34
	 */
	public List<User> queryUserAll();
	/**
	 * 
	 * 此方法描述的是：新增user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:08:27
	 */
	public Boolean addUser(User user);
	/**
	 * 
	 * 此方法描述的是：修改user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:12:51
	 */
	public Boolean editUser(User user);
	/**
	 * 
	 * 此方法描述的是：删除id的user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:09:53
	 */
	public Boolean delUser(Integer id);
	/**
	 * 
	 * 此方法描述的是：删除所有user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:14:13
	 */
	public Boolean delUserAll();
}
