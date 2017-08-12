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
<title>测试参数传递</title>
</head>
<body>
	 <!--test01-->     
	 <legend><h1>Test01</h1> </legend> 
	<form id="form1" action="myTest/test01.do" method="post">
		<tr>
		    <label class="control-label" for="input01">姓名</label>
			<input class="input-xlarge" id="name" name="name">
		</tr>
		<tr>
			 <label class="control-label" for="input02">年龄</label>
		 	 <input class="input-xlarge" id="age" name="age">
	 	</tr>
	 	 <!--bt1按钮-->
	 	<tr>
		  	<label class="control-label" />
		       <div  class="controls">
		         	<button id="bt1" class="btn btn-danger">提交</button>
		       </div>	
	    </tr>
  </form>
        <div class="controls">
		 <label class="control-label" for="input01">test01返回的信息：</label>
			<tr>
				<td>姓名:${name}</td>
				<td>年龄:${age}</td>
				<td>内容:${content}</td>
				<td>返回结果:${result}</td>
			</tr>
	 </div>
  
  <!--test02-->
  	<legend><h1>Test02</h1> </legend>
      <form id="form2" action="myTest/test02.do" method="post">
			 <label class="control-label" for="input01">姓名</label>
				<input class="input-xlarge" id="name" name="name">
			 <label class="control-label" for="input02">年龄</label>
				<input class="input-xlarge" id="age" name="age">
			<label class="control-label" for="input03">书名</label>
				<input class="input-xlarge" id="bookName" name="bookName">
			 <label class="control-label" for="input04">书号</label>
				<input class="input-xlarge" id="code" name="code">
			 <label class="control-label" for="input05">类型</label>
				<input class="input-xlarge" id="type" name="type">

		  <!--bt2按钮-->
			<label class="control-label" />
			     <div  class="controls">
			       <button id="bt2" class="btn btn-danger">提交</button>
			     </div>	
		    </form>
           
	       <div class="controls">
		 <label class="control-label" for="input01">test02返回的信息：</label>
			<tr>
				<td>姓名:${myUser.name}</td>
				<td>年龄:${myUser.age}</td>
				<td>书名:${book.bookName}</td>
				<td>书号:${book.code}</td>
				<td>类型:${book.type}</td>
				<td>运动类型:${book.type}</td>
			</tr>
	 </div>
	<script type="text/javascript">

		$('#bt1').click(function(){
			$("#form1").submit(	);
		})
		
		$('#bt2').click(function(){
			$("#form2").submit(	);
		})		

	</script>
</body>
</html>