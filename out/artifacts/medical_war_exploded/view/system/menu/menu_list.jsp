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
function del(menuId){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/menu",{method:"deleteMenu",menuId:menuId},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/menu?method=queryMenuList";
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
   <form action="system/menu?method=queryMenuList" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>菜单名称:</label> <input type="text" name="menuName" class="form-control"
					placeholder="请输入搜索关键字"  value="${menu.menuName }" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="system/menu?method=menuAddList" class="btn btn-success">添加菜单</a>
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 菜单信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>	
					<th>菜单ID</th>
					<th>上一级菜</th>
					<th>菜单名称</th>
					<th>访问URL</th>
					<th>操作</th>
				</tr>
			
			<c:forEach items="${menuList }" var="ml">
			<tr>
			   
			   <th width="5%">${ml.menuId }</th>
				<th width="15%">${ml.menMenuId }</th>
				<th width="15%">${ml.menuName }</th>
				<th width="15%">${ml.menuUrl }</th>
				<td><div class="button-group"> <a class="button border-main" href="view/system/menu/menu_edit.jsp?menuId=${ml.menuId}&&menuName=${ml.menuName }&&menuUrl=${ml.menuUrl } "><span class="icon-edit"></span> 修改</a> 
				<a class="button border-red" href="javascript:void(0)" onclick="del('${ml.menuId }')"><span class="icon-trash-o"></span> 删除</a> </div></td>
			</tr>
			</c:forEach>
			
			

		</table>
		
	</div>
	</form>
</body>
</html>