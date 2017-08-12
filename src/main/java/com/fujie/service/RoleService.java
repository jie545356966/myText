

package com.fujie.service;

import java.util.List;

import com.fujie.modle.Role;
import com.fujie.modle.User;


public interface RoleService {
	/**
	 * 
	 * 此方法描述的是：通过id获取user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:06:46
	 */
	public List<Role> queryUser(int id);
	/**
	 * 
	 * 此方法描述的是：新增user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:08:27
	 */
	public void addUser(Role role);
	/**
	 * 
	 * 此方法描述的是：修改user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:12:51
	 */
	public void editUser(Role role);
	/**
	 * 
	 * 此方法描述的是：删除id的user
	 * @author: fujie
	 * @version: 2017年7月11日 下午5:09:53
	 */
	public void delUser(int id);
	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年8月4日 下午4:12:49
	 */
	public List<User> findUnRoleUser();
}
