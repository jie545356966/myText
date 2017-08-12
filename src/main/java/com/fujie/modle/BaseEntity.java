package com.fujie.modle;

import org.apache.ibatis.session.RowBounds;

/**
 * 
 * 此类描述的是：基础实体类
 * @author: fujie
 * @version: 2017年8月2日 下午4:59:42
 */
public class BaseEntity {
	/*偏移量*/
	private int start;
	/*当前页*/
	private int page = 1;
	/*显示条数 默认10行*/
	private int rows = 10;
	/*总条数*/
	private int total;
	/*总页数*/
	private int totalPage;
	/*分页控制器是否启动 */
	private boolean control;
	
	/**
	 * 
	 * 此方法描述的是：通过总条数创建RowsBounds
	 * @author: fujie
	 * @version: 2017年8月2日 下午4:05:20
	 */
	public void buildRowBounds(int total){
			/*设置总条数*/
			this.total = total<0?0:total;
			/*设置总页数*/
			if(total%rows==0){
				this.totalPage = total/rows;
			}else{
				this.totalPage = total/rows+1;
			}	
	}

	/**
	 * 
	 * 此方法描述的是：
	 * @author: fujie
	 * @version: 2017年8月2日 下午5:31:24
	 */
	public RowBounds getRowBounds(){
		this.page = getPage();
		this.rows = getRows();
		/*获取偏移量*/
		this. start = (page-1)*rows;
		return new RowBounds(start, rows);
	};

	public int getPage() {
		return this.page <= 0?1:this.page;
	}
	public void setPage(int page) {
	   this.page = page<1?1:page;
	}
	public int getRows() {
		return this.rows <=  0?1:this.rows;
	}
	public void setRows(int rows) {
		this.rows = rows<1?10:rows;
	}
	public int getTotal() {
		return total;
	}
	/**
	 * 
	 * 此方法描述的是：设置总条数后,计算并设置偏移量
	 * @author: fujie
	 * @version: 2017年8月3日 下午5:58:23
	 */
	public void setTotal(int total) {
		this.page = getPage();
		this.rows = getRows();
		this.total = total<0?0:total;
		this.start = (page-1)*rows;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getStart() {
		return start;
	}
	public boolean isControl() {
		return control;
	}
	public void setControl(boolean control) {
		this.control = control;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
