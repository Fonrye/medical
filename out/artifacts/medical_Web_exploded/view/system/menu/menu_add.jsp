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
			<strong><span class="icon-key"></span>菜单添加</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="system/menu?method=addMenu">
			
				<div class="form-group">
					<div class="label">
						<label for="sitename">所属菜单</label>
					</div>
					<div class="field">
						<select name=menMenuId class="input w50">
							<c:forEach items="${menuList }" var="menu">
								<option value="${menu.menMenuId }">${menu.menuName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<!-- 菜单名称 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename">菜单名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="menuName" name="menuName"
							size="50" placeholder="请输入用户名" data-validate="required:请输入菜单名称" /><span id="unameSpan"></span>
					</div>
				</div>
				<!-- 用户账号 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename">访问Url：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="menuUrl" name="menuUrl"
							size="50" placeholder="请输入账号" data-validate="required:请输入访问Url" /><span id="unumberSpan"></span>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>