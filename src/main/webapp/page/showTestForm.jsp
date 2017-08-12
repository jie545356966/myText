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
<title>User用户信息Test展示页面</title>
</head>
<body>
	<tr>  
         <td colspan="2">
         	<a  herf="<c:url  value='/myTest/addTestForm.do'></c:url>">新增用户</a>
         </td>  
	 </tr> 
	<table id="table_report" class="table table-striped table-bordered table-hover">				
				<thead>
					<tr>
					    <th>序号</th>
						<th>学号</th>
						<th>姓名</th>
						<th>密码</th>
						<th>性别</th>
						<th>年龄</th>
						<th>备注</th>
					</tr>
				</thead>
										
				<tbody>			
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty userList}">
						<c:if test="${result == 1 }">
						<c:forEach items="${userList}" var="user" varStatus="n">									
							<tr>
								<td class='center' style="width: 30px;">${n.index+1}</td>
								<td>${user.id }</td>
								<td><a>${user.code }</a></td>
								<td>${user.name }</td>
								<td>${user.password }</td>
								<td>${user.sex}</td>
								<td>${user.age}</td>
								<%-- <td>${user.birthday}</td>
									<td>${user.content}</td>
									<c:forEach  items="${user.hobby}"  var="hobby"   varStatus="s">
										<td>${hobby}</td>
									</c:forEach>
									<c:forEach  items="${user.specialty}"  var="spercialty"   varStatus="s">
										<td>${spercialty}</td>
									</c:forEach>
									<c:forEach  items="${user.jobs}"  var="jobs"   varStatus="s">
										<td>${jobs}</td>
									</c:forEach>
									<c:forEach  items="${user.contact}"  var="contact"   varStatus="s">
										<td>${contact}</td>
									</c:forEach>
			                     --%>
								 <td>${user.content}</td>
								<td>
									<a class='btn btn-mini btn-info'  onclick='update("${user.id}")'>修改</a>
									<a href="${pageContext.request.contextPath}/myTest//${user.id}/editTestForm.do" >修改</a>
								</td>
							</tr>						
						</c:forEach>
						</c:if>
						
						<c:if test="${result == 0 }">
							<tr>
								<td colspan="10" class="center">您无权查看</td>
							</tr>
						</c:if>
					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="10" class="center">没有相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>			
				</tbody>
			</table>
			<script type="text/javascript">
			//修改
			function update(data){
					$.post("/myTest/"+data+"/editTestForm.do");
				}
			</script>
</body>
</html>