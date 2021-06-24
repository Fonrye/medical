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
			<strong><span class="icon-key"></span>参合缴费信息修改</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="system/switch?method=update">
				<div class="form-group">
					<div class="label">
						<label for="sitename">缴费年份：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="<%=request.getParameter("year") %>" name="year"
							size="50" readonly="readonly" />
					</div>
				</div>
				<!-- 用户账号 -->
				<div class="form-group">
					<div class="label">
						<label for="sitename">缴费金额：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="<%=request.getParameter("money") %>" name="money"
							size="50" data-validate="required:请输入缴费金额"/>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">缴费开始时间：</label>
					</div>
					<div class="field">
						<input type="date" class="input w50" value="<%=request.getParameter("start") %>" name="start" size="50"
							 data-validate="required:选择缴费开始时间"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label for="sitename">缴费结束时间</label>
					</div>
					<div class="field">
						<input type="date" class="input w50" value="<%=request.getParameter("end") %>" name="end" size="50"
							data-validate="required:请选择缴费结束时间"/>
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