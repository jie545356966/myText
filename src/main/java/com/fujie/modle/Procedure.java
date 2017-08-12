package com.fujie.modle;
/**
 * 
 * 此类描述的是：
 * @author: fujie
 * @version: 2017年8月9日 上午11:13:04
 */
public class Procedure extends BaseEntity{
	/*查询字段*/
	private String fields;
	/*表名字段*/
	private String tables;
	/*条件查询*/
	private String where;
	/*排序*/
	private String orderBy;
	/*字段求和*/
	private String sumFields;
	
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	public String getTables() {
		return tables;
	}
	public void setTables(String tables) {
		this.tables = tables;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSumFields() {
		return sumFields;
	}
	public void setSumFields(String sumFields) {
		this.sumFields = sumFields;
	}
}
