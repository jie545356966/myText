<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<title>表单绑定测试页面</title>
</head>
<body>
	<legend><h1>Form表单标签渲染绑定页面</h1> </legend> 
	<form:form action="myTest/testSave.do" method="post" commandName="user"  modelAttribute="user">
		<table>
			<tr>
				<td>
					<form:hidden path="id"/>
				</td>
			</tr>
			<tr>
				<td>
					工号:<form:input path="code"/>
				</td>
			</tr>
			<tr>
				<td>
					姓名:<form:input path="name"/>
				</td>
			</tr>
		    <tr>
				<td>
					密码:<form:password path="password"/>
				</td>
			</tr>
			<tr>
				<td>
					年龄:<form:input path="age"/>
				</td>
			</tr>
			<tr>
				<td>
					生日:<form:input path="birthday"/>
				</td>
			</tr>
			<tr>
				<td> 
					请选择性别:<form:select  path="sex">
		          		 	 <form:option value="0">男</form:option>
		           			 <form:option value="1">女</form:option>
        			</form:select>
        		</td>
			</tr>
			<%--
			<tr>
				<td> 
					请选择职业(Map):<form:radiobuttons  path="jobs" items="${user.jobs}"></form:radiobuttons>
        		</td>
			</tr>
			<tr>
				<td> 
					<br>特长(Array):</br>
					<form:checkboxes  path="specialty"  items="${user.specialty}"></form:checkboxes >
        		</td>
			</tr>
			<tr>
				<td> 
					<br>爱好(Set):</br>
					<form:checkboxes  path="hobby"  items="${user.hobby}"></form:checkboxes>
        		</td>
			</tr>
			<tr>
				<td> 
					<br>联系方式(Map):</br>
					<form:radiobuttons  path="contact"  items="${user.contact}"></form:radiobuttons>
        		</td>
			</tr>
			--%>
			<tr>	
				<td>
					<br>备注:</br>
					<form:textarea path="content"/>
				</td>
			</tr>
		<tr>  
            <td colspan="2">
            	<input type="submit" value="保存"/>
            </td>  
        </tr> 
		</table>  
	</form:form>
</body>
</html>