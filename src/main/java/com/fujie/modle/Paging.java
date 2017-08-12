package com.fujie.modle;

import org.springframework.stereotype.Service;

@Service
public class Paging {
	
	/*默认展示条数20*/
	private int showCount = 20;
	/*总页数*/
	private int totalPage;
	/*总记录条数*/
	private int totalResult;
	/*当前页数*/
	private int currentPage = 1;
	/*当前索引条数*/
	private int currentResult;

	/**
	 * 
	 * 此方法描述的是：获取展示条数
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:00:06
	 */
	public int getShowCount() {
		return showCount;
	}
	/**
	 * 
	 * 此方法描述的是：如果展示页数大于50行或者小于1都将值设为默认值30行
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:00:03
	 */
	public void setShowCount(int showCount) {
		if(showCount>50&&showCount<1){
			showCount  = 30;
		}
		this.showCount = showCount;
	}
	/**
	 * 
	 * 此方法描述的是：获取总页数
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:02:47
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 
	 * 此方法描述的是：计算总页数,总页数等于总条数除展示页数
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:06:19
	 */
	private void setTotalPage() {
		if(totalResult%showCount==0){
			this.totalPage = totalResult/showCount;
		}else {
			this.totalPage = totalResult/showCount+1;
		}
	}
	/**
	 * 
	 * 此方法描述的是：获取总条数
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:10:12
	 */
	public int getTotalResult() {
		return totalResult;
	}
	/**
	 * 
	 * 此方法描述的是：设置总条数
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:09:01
	 */
	public void setTotalResult(int totalResult) {
		if(totalResult<1){
			totalResult = 0;
		}
		this.totalResult = totalResult;
		/*设置总页数*/
		setTotalPage();
	}
	/**
	 * 
	 * 此方法描述的是：获取当前页数,保证当前页值不为0或负数,保证不大于总页数
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:10:24
	 */
	public int getCurrentPage() {
		if(currentPage<=0){
			currentPage = 1;
		}
		if(currentPage>getTotalPage()){
			currentPage = getTotalPage();
		}
		return currentPage;
	}
	/**
	 * 
	 * 此方法描述的是：设置当前页
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:14:49
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 
	 * 此方法描述的是：获取当前条数索引id
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:15:04
	 */
	public int getCurrentResult() {
		currentResult = (getCurrentPage()-1)*showCount;
		if(currentResult<0){
			currentResult = 0;
		}
		return currentResult;
	}
	/**
	 * 
	 * 此方法描述的是：设置当前索引id
	 * @author: fujie
	 * @version: 2017年8月2日 上午10:16:19
	 */
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	
	
}
