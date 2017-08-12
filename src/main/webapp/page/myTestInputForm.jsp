<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增页面</title>
</head>
<body>
<div id="global">
	 <form class="form-horizontal" action="save.do" method="post">
	    <div class="control-group">	
	          <!-- Text input-->
	          <label class="control-label" for="input01">姓名</label>
	          <div class="controls">
	            <input type="text" class="input-xlarge" id="name">
	          </div>
	        </div><div class="control-group">
	
	          <!-- Text input-->
	          <label class="control-label" for="input01">年龄</label>
	          <div class="controls">
	            <input type="text" class="input-xlarge"  id="age"> 
	          </div>
	        </div><div class="control-group">
	
	          <!-- Text input-->
	          <label class="control-label" for="input01">电话号码</label>
	          <div class="controls">
	            <input type="text" class="input-xlarge" id="phone">
	          </div>
	        </div>
	
	    <div class="control-group">
	          <!-- Button -->
	          <div class="controls">
	            <button id="bt" class="btn btn-danger">提交</button>
	          </div>	
	  	</form>
	</div>
	<script type="text/javascript"  src="static/js/jquery-3.2.1.min.js" />
	<script type="text/javascript">
		$("#bt").on("click",function(){
			$("form").submit();
		})
	</script>
</body>
</html>