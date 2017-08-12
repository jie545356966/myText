package com.fujie.modle;

import java.io.Serializable;



/**
 * 
 * 此类描述的是：结果集
 * @author: fujie
 * @version: 2017年7月17日 上午10:26:31
 */

public class ResultData implements Serializable{
		
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since Ver 1.1
	 */
	
	private static final long serialVersionUID = 7411529191040827789L;
		/*成功*/
	    public static final int SUCCESS = 1;
	    /*错误*/
	    public static final int ERROR = 0;
	    /*失败*/
	    public static final int FAILURE = -1;
	    
	    /*返回信息*/
		private  String msg  =  "";
		/*状态码*/
	    private  int state = FAILURE;
	    /*结果集*/
		private  Object  param= null;
		/**
		 * 
		 * 创建一个新的实例 ResultData.
		 *
		 * @param builder
		 */
		private ResultData(Builder builder){
			this.state = builder.state;
			this.msg = builder.msg;
			this.param = builder.param;			
		}
		
		/**
		 * 
		 * 此类描述的是：静态内部创建类
		 * @author: fujie
		 * @version: 2017年8月3日 下午3:24:45
		 */
		public static class Builder{
		    /*返回信息*/
			private String msg;
			/*状态码*/
			private int state;
		    /*结果集*/
			private Object  param;
			/*必需初始化参数*/
			public Builder(ResultEnum ResultEnum){
				 this.state = ResultEnum.state;
				 this.msg = ResultEnum.msg;				 
			 }
			public Builder(int  state,String msg){
				 this.state = state;
				 this.msg = msg;				 
			 }
			 /**
			  * 
			  * 此方法描述的是：加入状态值
			  * @author: fujie
			  * @version: 2017年8月3日 下午3:34:14
			  */
			 public Builder setState(int val){
				 this.state = val;
				 return this;
			 }
			 /**
			  * 
			  * 此方法描述的是：加入消息
			  * @author: fujie
			  * @version: 2017年8月3日 下午3:34:17
			  */
			 public Builder setMsg(String val){
				 this.msg = val;
				 return this;
			 }
			 /**
			  * 
			  * 此方法描述的是：加入结果集
			  * @author: fujie
			  * @version: 2017年8月3日 下午3:34:22
			  */
			public  Builder setParam(Object val){
				this.param = val;
				return this;
			}
			/**
			 * 
			 * 此方法描述的是：构造器方法
			 * @author: fujie
			 * @version: 2017年8月3日 下午3:25:44
			 */
			public  ResultData build(){			
				return new ResultData(this);
			}
		}
		/** 
	 	* 这个类是: 默认状态枚举类
	    * @author: WuXiaoFei
	    * @version: 0.1.0
	    * @date 2016年9月28日 下午5:57:47
	 */
	public enum ResultEnum{
		
		 SUCCEED(ResultData.SUCCESS,"请求成功"),
		 FAILING(ResultData.FAILURE,"请求失败"),
		 ERROR(ResultData.ERROR,"未知错误");
	
		private int state = ResultData.FAILURE;
		private String msg;
		private ResultEnum(int state, String msg)
		{
			this.state = state;
			this.msg = msg;
		}
		
		public int getState() {
			return state;
		}
		public String getMsg() {
			return msg;
		}
		
	 }
}
