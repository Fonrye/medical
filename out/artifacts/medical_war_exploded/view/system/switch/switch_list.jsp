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
function del(year){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/switch",{method:"delete",year:year},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/switch?method=findAllSwitch&&index=1";
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
   <form action="system/switch?method=findAllSwitch&&index=1" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>缴费年度:</label> <input type="text" name="year" class="form-control"
					placeholder="请输入年份"  value="${year }" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="view/system/switch/switch_add.jsp" class="btn btn-success">添加参加缴费年度信息</a>
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 设置参合缴费信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>
				<th width="10%">年份</th>
				<th width="10%">缴费金额</th>
				<th width="10%">缴费开始时间</th>
				<th width="10%">缴费结束时间</th>
				<th width="10%">操作</th>
			</tr>
			
			<c:forEach items="${pt.list }" var="pt">
			<tr>
			   <th width="10%">${pt.year }</th>
				<th width="10%">${pt.money }</th>
				<th width="10%">${pt.start }</th>
				<th width="10%">${pt.end }</th>
				<td><div class="button-group"> <a class="button border-main" href="view/system/switch/switch_edit.jsp?year=${pt.year }&&money=${pt.money }&&start=${pt.start }&&end=${pt.end }"><span class="icon-edit"></span> 修改</a> 
				<a class="button border-red" href="javascript:void(0)" onclick="del('${pt.year }')"><span class="icon-trash-o"></span> 删除</a> </div></td>
			</tr>
			</c:forEach>
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/switch?method=findAllSwitch&&index=1">首页</a>
	        <c:if test="${pt.index !=1 }">
				<a href="system/switch?method=findAllSwitch&&index=${pt.index-1 }">上一页</a>
			</c:if> 
			<c:if test="${pt.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pt.numbers }" var="numb">
						<c:if test="${numb == pt.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pt.index }">
					<a href="system/switch?method=findAllSwitch&&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pt.index !=pt.totalPageCount }">
				<a href="system/switch?method=findAllSwitch&&index=${pt.index+1 }">下一页</a>
			</c:if> 
			<c:if test="${pt.index ==pt.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/switch?method=findAllSwitch&&index=${pt.totalPageCount }">尾页</a>
			 共${pt.totalCount }条记录
			  </div>
			  </td>
           </tr>
		
	</div>
	</form>
</body>
</html>