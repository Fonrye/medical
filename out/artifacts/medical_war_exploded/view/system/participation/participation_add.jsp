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
/**
function del(id,jtbh){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/familyhold",{method:"deleteFamilyhold",id:id,jtbh:jtbh},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/familyhold?method=findAllFamilyhold&&jtbh="+jtbh;
				} 
			}else{
				window.top.location.href="login.jsp";
			}
		});

	}
}
**/
var se = 0;
function ch(checkbox,jtbh,nhzh,xm,yhzgx,whcd,rysx,zy,sfzh,lxdh){
	if (checkbox.checked == true){
		$("#tb").append("<tr id = "+nhzh+"><td >"+jtbh+"<input type='hidden' name='jtbh' value="+jtbh+"></td><td>"+nhzh+"<input type='hidden' name='nhzh' value="+nhzh+"></td><td>"+xm+"<input type='hidden' name='xm' value="+xm+"></td><td>"+yhzgx+"</td><td>"+whcd+"</td><td>"+rysx+"</td><td>"+zy+"</td><td>"+sfzh+"<input type='hidden' name='sfzh' value="+sfzh+"></td><td>"+lxdh+"</td></tr>");
		se = se+1;
		$.get("system/participation",{method:"allMoney",se:se},function(data){
			$("#money").val(data);
		})
	}else{
		se = se-1;
		$.get("system/participation",{method:"allMoney",se:se},function(data){
			$("#money").val(data);
		})
		$("#"+nhzh).empty(); 
		while($("#"+nhzh).length>0){
			$("#"+nhzh).remove();
		}
	}
}

</script>
</head>
<body>
   <form action="system/participation?method=getDate" method="post" class="form-inline">
     
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<input type="hidden" name="czy" value="${sessionScope.user.userName }">
			
			<div class="form-group">
				<label>缴费总金额:</label> <input type="text"  id="money" readonly="readonly" class="form-control"/>
			</div>
			
			<input type="submit" class="btn btn-danger" value="提交"> 
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 家庭参合人员未缴费信息列表</strong>
		</div>

		<table class="table table-hover text-center">
		<!-- <input type="hidden" name="czy" value="${sessionScope.user.userName }"> -->
			<tr>	<th width="2%">选择</th>
					<th width="7%">家庭编号</th>
				    <th width="7%">农合证号</th>
					<th width="7%">姓名</th>
					<th width="7%">与户主关系</th>
					<th width="7%">文化程度</th>
					<th width="7%">人员属性</th>
					<th width="7%">职业</th>
					<th width="7%">身份证号</th>
					<th width="7%">联系电话</th>
					<!-- <th width="10%">操作</th> -->
				</tr>
			
			<c:forEach items="${familyhold }" var="fh">
				<tr>
					<td><input type="checkbox"  onclick="ch(this,'${fh.jtbh}','${fh.nhzh }','${fh.xm }','${fh.yhzgx }','${fh.whcd }','${fh.rysx }','${fh.zy }','${fh.sfzh }','${fh.lxdh }')"></td>
				    <td>${fh.jtbh }</td>
					<td>${fh.nhzh }</td>
					<td>${fh.xm }</td>
					<td>${fh.yhzgx }</td>
					<td>${fh.whcd }</td>
					<td>${fh.rysx }</td>
					<td>${fh.zy }</td>
					<td>${fh.sfzh }</td>
					<td>${fh.lxdh }</td>
					
				</tr>
			</c:forEach>
			
		</table>
		
	</div>
	<table style="display: none;" class="table table-hover text-center" id="tb" >
			
			
	</table>	
			
	</form>
	
</body>
</html>