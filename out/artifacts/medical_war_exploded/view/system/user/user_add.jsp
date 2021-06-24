<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>用户注册</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

<script type="text/javascript" src="jquery/jquery-1.9.1.js"></script>
<!--声明js代码域  -->
<script type="text/javascript">
	
	//验证账号是否存在
	//页面加载成功给HTML元素添加事件
	$(function(){
	  //给用户名文本框添加失去焦点事件
	  $("#usernumber").blur(function(){
	    //发起ajax请求，校验账号是否被注册
	    $.get("system/user?method=checkUserNumber",{usernumber:$("#usernumber").val()},function(data){
	      if(eval(data)){
	        //获取span对象
	        var span = document.getElementById("unumberSpan");
	        var submit = document.getElementById("submit");
	        span.style.color="red";
	        submit.disabled = true;
	        //将数据填充到span中
	        span.innerHTML="账号已存在";
	      }else{
		   //获取Span对象
		   var span=document.getElementById("unumberSpan");
		   var submit = document.getElementById("submit");
		   //设置span颜色
		   span.style.color="green";
		   //将数据填充到span中
		   span.innerHTML="账号可以使用";
		   submit.disabled = false;
			  }
	    });
	  })
	})
	
	
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span>用户添加</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="system/user?method=addUser">
			<!--声明请求的方法名  
				<input type="hidden" name="method" value="userReg" />-->
				<!-- 用户名 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename">用户名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="username" name="username"
							size="50" placeholder="请输入用户名" data-validate="required:请输入用户名" /><span id="unameSpan"></span>
					</div>
				</div>
				<!-- 用户账号 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename">账号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="usernumber" name="usernumber"
							size="50" placeholder="请输入账号" data-validate="required:请输入账号" />
							<span id="unumberSpan"></span>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">新密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50" name="password" size="50"
							placeholder="请输入新密码"
							data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">确认新密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50"
							size="50" placeholder="请再次输入新密码"
							data-validate="required:请再次输入新密码,repeat#password:两次输入的密码不一致" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label for="sitename">角色</label>
					</div>
					<div class="field">
						<select name="roleId" class="input w50">
							<c:forEach items="${roleList }" var="role">
								<option value="${role.roleId }">${role.roleName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit" id="submit" >
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>