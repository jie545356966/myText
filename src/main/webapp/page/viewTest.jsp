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
<title>展示参数页面</title>
</head>
<body>
	 <div class="controls">
	 <label class="control-label" for="input01">返回的信息：</label>
			<tr>
				<td>姓名:${name}</td>
				<td>年龄：$[age]</td>
			</tr>
	 </div>
	<script type="text/javascript"  src="static/js/jquery-3.2.1.min.js" />

</body>
</html>