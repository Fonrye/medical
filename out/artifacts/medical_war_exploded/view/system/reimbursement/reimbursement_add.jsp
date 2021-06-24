<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
$(function(){
	$("#btn1").click(function() {
		var name = $("#name").val();
		var illcardNo = $("#illcardNo").val();
		var sfzh = $("#sfzh").val();
		var nhzh = $("#nhzh").val();
		var illName = $("#illName").val();
		var illMoney = $("#illMoney").val();
		var yyfph = $("#yyfph").val();
		var jzsj = $("#jzsj").val();
		$.get("system/reimbursement",{method:"checkIllcard",
			name:name,illcardNor:illcardNo,sfzh:sfzh,nhzh:nhzh,illName:illName,illMoney:illMoney,
			yyfph:yyfph,jzsj:jzsj},function(data) {
		if ("false" == data) {
		    alert("填写信息不合法或该参合农民没有慢性病证");
		} else {
			window.location.href = "system/reimbursement?method=money&&name="+name+"&&illcardNo="+illcardNo+"&&sfzh="+sfzh+"&&nhzh="+nhzh+"&&illName="+illName+"&&illMoney="+illMoney+"&&yyfph="+yyfph+"&&jzsj="+jzsj;
		}
		})

	});
})
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 参合农合信息</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>
				<th width="10%">姓名</th>
				<th width="10%">身份证号</th>
				<th width="10%">参合证号</th>
				<th width="10%">疾病名称</th>


			</tr>
					<tr>
						<td>${par.xm}</td>
						<td>${par.sfzh}</td>
						<td>${par.chzh }</td>
						<td>${li[0].illName }</td>

					</tr>
		</table>

	</div>

	<div class="panel admin-panel ">
		<div class="panel-head">
			<strong class="icon-reorder">添加参合报销信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="">
				
				<input type="hidden" id="name" name="name" value="${li[0].xm }">
				<input type="hidden" id="illcardNo" name="illcardNo" value="${li[0].illCardId}">
				<input type="hidden" id="sfzh" name="sfzh" value="${li[0].sfzh }">
				<input type="hidden" id="nhzh" name="nhzh" value="${li[0].nhzh }">


				<div class="form-group">
					<div class="label">
						<label>疾病名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="illName" name="illName" value="${li[0].illName }"
							data-validate="required:必填项" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>医疗总费用：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="illMoney" name="illMoney" "
							data-validate="required:必填项" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>医院发票号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="yyfph" name="yyfph" "
							data-validate="required:必填项" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>就诊时间：</label>
					</div>
					<div class="field">
						<input type="date" class="input w50" id="jzsj" name="jzsj"
							data-validate="required:必填项" />
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="button"
							id="btn1">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>