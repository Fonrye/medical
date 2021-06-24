<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript">
	$(function() {
		//查询参合表里面的年份

		$.ajax({
			url : "system/participation?method=findAllYear",
			type : "POST",
			success : function(jsonStr) {//输出所有的部门列表
				//jsontstr---json object
				eval("var arr = " + jsonStr);
				//拼接所有的option字符串
				var str = '';
				for (var i = 0; i < arr.length; i++) {

					str += '<option value="'+arr[i].jfnd+'">' + arr[i].jfnd
							+ '</option>';
				}
				//一次性写入到select deptno列表中
				$("#year").html(str);
			}

		});

		$("#btn1").click(function() {
			var sfzh = $("#sfzh").val();
			var year = $("#year").val();
			$.get("system/reimbursement",{method : "findParticipation",sfzh : sfzh,year : year},function(data) {
			if ("false" == data) {
			    alert("该农民未参合！！！！！");
			} else {
				window.location.href = "system/reimbursement?method=findSfzhIllcard&&sfzh="+ sfzh;
			}
			})

		});
	})
</script>
</head>
<body>
	
	<div class="panel admin-panel ">
		<div class="panel-head">
			<strong class="icon-reorder">查询参合人员信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="">

				<div class="form-group">
					<div class="label">
						<label>身份证号：</label>
					</div>
					<div class="field">
						<input type="sfzh" name="sfzh" id="sfzh" class="form-control"
							placeholder="请输入身份证号" value="${sfzh }" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>年份：</label>
					</div>
					<div class="field">
						<select id="year" name="year" class="form-control"></select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="button"
							id="btn1">查询</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>