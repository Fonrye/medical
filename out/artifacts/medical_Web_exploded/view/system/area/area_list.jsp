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
function del(areaCode,index){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/area",{method:"deleteArea",areaCode:areaCode},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/area?method=findArea&&index=1";
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
   <form action="" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>区域名称:</label> <input type="text" name="areaName" class="form-control"
					placeholder="请输入搜索关键字"  value="${area.areaName }" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="system/area?method=findAllArea" class="btn btn-success">添加行政区域</a>
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 行政区域信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>	
				<th width="15%">行政区域编号</th>
				<th width="15%">行政区域名称</th>
				<th width="10%">级别</th>
				<th width="10%">操作</th>
				</tr>
			
			<c:forEach items="${pa.list }" var="a">
				<tr>
					<td>${a.areaCode }</td>
					<td>${a.areaName }</td>
					<td>${a.grade }</td>
					<td><div class="button-group">
							<a class="button border-main" href="system/area?method=findAreaByAreaId&&areaCode=${a.areaCode }">
							<span class="icon-edit"></span> 修改</a> 
							<a class="button border-red" href="javaScript:void(0)" onclick="del('${a.areaCode}','${pa.index }')">
							<span class="icon-trash-o"></span> 删除</a>
						</div></td>
				</tr>
			</c:forEach>
			
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/area?method=findArea&index=1">首页</a>
	        <c:if test="${pa.index !=1 }">
				<a href="system/area?method=findArea&index=${pa.index-1 }">上一页</a>
			</c:if> 
			<c:if test="${pa.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pa.numbers }" var="numb">
						<c:if test="${numb == pa.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pa.index }">
					<a href="system/area?method=findArea&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pa.index !=pa.totalPageCount }">
				<a href="system/area?method=findArea&index=${pa.index+1 }">下一页</a>
			</c:if> 
			<c:if test="${pa.index ==pa.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/area?method=findArea&index=${pa.totalPageCount }">尾页</a>
			 共${pa.totalCount }条记录
			  </div>
			  </td>
           </tr>
	</div>
	</form>
</body>
</html>