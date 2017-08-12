<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
     	<script src="${pageContext.request.contextPath}/static/js/1.9.1/jquery.min.js" type="text/javascript"></script>
        <title>AjaxTest</title>
    </head>
    <body>
   	<div>
	   	<span class="fl">$.ajax请求测试</span> 
	   	<tr>
	        <br/>名字:<input class="div" type="text" id="name" name="name" />         
	        <br/>学号:<input class="div" type="text" id="code" name="code" /> 
	        <br/>密码:<input class="div" type="password" id="password" name="password" /> 
	        <br/>年龄:<input class="div" type="text" id="age" name="age" /> 
	        <br/>生日:<input class="div" type="date" id="birthday" name="birthday" />
	    </tr>	    	 
	     <div id="divtest">
	     <div class="title">
	         <span class="fr">
	           <input id="bt1" type="button" value="提交" onclick="sbmit()"/>
	         </span>
	     </div>
	     
	     
	 <div class="title">
	         <span class="fr">
	           <input id="bt2" type="button" value="新增" onclick="insterTest()"/>
	         </span>
	     </div>
    </div> 
	 <ul id='ul1'></ul>
	 
	 	     
	 <div class="title">
	         <span class="fr">
	           <input id="bt3" type="button" value="测试Mybits缓存" onclick="testMybits()"/>
	         </span>
	     </div>
    </div> 
    <ul id='ul1'></ul>
    
    	<div class="title">
	         <span class="fr">
	           <input id="bt3" type="button" value="测试分页" onclick="queryTest()"/>
	         </span>
	     </div>
    </div> 
    <ul id='ul1'></ul>
    
	 <script type="text/javascript">
	 var user = new Object();	 	
	 	function sbmit(){
		 	user.name = $('#name').val();
		 	user.code = $('#code').val();
		 	user.age = $('#age').val();
		 	user.birthday = $('#birthday').val();
		 	user.pwd = $('#password').val();	 
	 		$.ajax({
			    url : "<%=basePath%>myTest/testAjax.do",  
			    type : "POST",  
			    data : JSON.stringify(user)  , //转JSON字符串  
			    dataType: 'json',  
			    contentType:'application/json;charset=UTF-8', //contentType很重要     
			    success : function(data) { 
			    		alert(JSON.stringify(data));  			    			        
		    	}  
			});
	 	}	
	 	function insterTest(){
	 		$.ajax({
	 			url:"<%=basePath%>myTest/insterTest.do",  
	 			type:"POST",
	 			dataType:"json",
	 			contentType:"application/json;charset=UTF-8",
	 			success :function(data){
	 				alert(JSON.stringify(data));
	 			}
	 		})
	 	}
	 	
	 	function testMybits(){
	 		$.ajax({
	 			url:"<%=basePath%>myTest/queryMybits.do",  
	 			type:"POST",
	 			dataType:"json",
	 			contentType:"application/json;charset=UTF-8",
	 			success :function(data){
				
	 			}
	 		})
	 	}
	 	
	 	function queryTest(){
	 		$.ajax({
	 			url:"<%=basePath%>my/queryTest.do",  
	 			type:"POST",
	 			dataType:"json",
	 			contentType:"application/json;charset=UTF-8",
	 			success :function(data){
	 				alert(JSON.stringify(data));
	 			}
	 		})
	 	}
	 	
	 	
	 function queryMytest(){
		 $.ajax({
			 url:"<%=basePath%>my/queryTest.do",
			 type:"post",
			 dataType:"json",
			 contentType:"application/json;charset=UTF-8",
			 success:function(data){
				 
			 }
		 })
		 
	 }
	 	
	 </script>
 	</body>
</html>