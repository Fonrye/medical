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
function del(userId){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/user",{method:"deleteUser",userId:userId},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/userQuery";
				} 
			}else{
				window.top.location.href="login.jsp";
			}
		});

	}
}
</script>
</head>
<body>
  <form action="system/userQuery" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px; ">
			<div class="form-group">
				<label>条件:</label> 
				<select name="type" class="form-control">
					<option value="">请选择</option>
					<option value="userName" ${type=='userName'?'selected':'' } >用户姓名</option>
					<option value="userNumber" ${type=='userNumber'?'selected':'' }>用户账号</option>
				</select> 
				<input type="text" name="keywords" class="form-control" value="${keywords }"  placeholder="请输入查询条件"/>
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
			<a  href="system/user?method=queryUserRole" class="btn btn-success" >添加用户</a>
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 用户信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>
				<th width="5%">ID</th>
				<th width="15%">用户名称</th>
				<th width="10%">用户账号</th>
				<th width="10%">角色名称</th>
				<th width="10%">操作</th>
			</tr>
			
			<c:forEach items="${userList }" var="lu">
			<tr>
			   <th width="5%">${lu.userId }</th>
				<th width="15%">${lu.userName }</th>
				<th width="10%">${lu.userNumber }</th>
				<th width="10%">${lu.roleName }</th>
				<td><div class="button-group"> <a class="button border-main" href="system/user?method=queryUpdateUser&userId=${lu.userId }"><span class="icon-edit"></span> 修改</a>
				 <a class="button border-red" href="javascript:void(0)" onclick="del('${lu.userId }')"><span class="icon-trash-o"></span> 删除</a> </div></td>
			</tr>
			</c:forEach>
			
			

		</table>
		
	</div>
	</form>
</body>
</html>