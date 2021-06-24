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
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span>用户信息修改</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="system/user?method=updateUser">
			<input type="hidden" name="userId" value="${user.userId }"/>
				<div class="form-group">
					<div class="label">
						<label for="sitename">用户名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${user.userName }" name="username"
							size="50" placeholder="请输入用户名" data-validate="required:请输入用户名" /><span id="unameSpan"></span>
					</div>
				</div>
				<!-- 用户账号 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename">账号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${user.userNumber }" name="usernumber"
							size="50" readonly="readonly" data-validate="required:请输入账号" /><span id="unumberSpan"></span>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">密码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${user.userPwd }" name="password" size="50"
							data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label for="sitename">角色</label>
					</div>
					<div class="field">
					  <div class="col-xs-6">
						<select name="roleId" class="input w50">
							<c:forEach items="${listRole }" var="role">
								<option value="${role.roleId }" ${user.roleId==role.roleId?'selected':'' }>${role.roleName }</option>
							</c:forEach>
						</select>
					  </div>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
					<input
					type="reset" class="button bg-main icon-check-square-o" value="重置信息" />
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
							
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>