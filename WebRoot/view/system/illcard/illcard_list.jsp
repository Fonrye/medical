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
function del(id,index){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/illcard",{method:"delete",id:id},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/illcard?method=findIllCard&index=1";
				} 
			}else{
				window.top.location.href="login.jsp";
			}
		});

	}
}
$(function(){
	//给导出按钮绑定点击事件
	$("#btn2").click(function(){
		//获取查询条件的值
		var xm = $("#xm").val();
		//通过 Ajax获取请求得到数据并通过回调函数输出
		//访问指定的Servlet，不使用Ajax（因为Ajax是通过回调函数处理结果的，导出XLS是直接返回流，所以也不使用转发和重定向）
		if(confirm("您确定要导出吗?")){
			
		location.href="system/illcard?method=exportXls&xm="+xm;
		}
	});
})
</script>
</head>
<body>
   <form action="system/illcard?method=findIllCard&index=1" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>姓名:</label> <input type="text" name="xm" id="xm" class="form-control"
					placeholder="请输入搜索关键字"  value="${xm }" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="view/system/illcard/illcard_add.jsp" class="btn btn-success">添加慢病证</a>
				<input type="button" id="btn2" class="btn btn-success" value="导出Excel">
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 信息列表</strong>
		</div>

		<table class="table table-hover text-center">
				<tr>
				<th width="10%">姓名</th>
				<th width="10%">慢病证号</th>
				<th width="10%">身份证号</th>
				<th width="10%">农合证号</th>
				<th width="10%">疾病名称</th>
				<th width="10%">开始时间</th>
				<th width="10%">结束时间</th>
				<th width="10%">操作</th>
			</tr>
				
			<c:forEach items="${pi.list }" var="i">
				<tr>
					<td>${i.xm}</td>
					<td>${i.illCardId}</td>
					<td>${i.sfzh }</td>
					<td>${i.nhzh }</td>
					<td>${i.illName }</td>
					<td>${i.startTime }</td>
					<td>${i.endTime }</td>
					<td><div class="button-group">
							<a class="button border-main" href="system/illcard?method=findIllcardById&&id=${i.id }">
							<span class="icon-edit"></span> 修改</a> 
							<a class="button border-red" href="javaScript:void(0)" onclick="del('${i.id}','${pi.index }')">
							<span class="icon-trash-o"></span> 删除</a>
						</div></td>
				</tr>
			</c:forEach>
			</table>
			<div class="pagelist"> 
	        <a href="system/illcard?method=findIllCard&index=1&xm=${xm }">首页</a>
	        <c:if test="${pi.index !=1 }">
				<a href="system/illcard?method=findIllCard&index=${pi.index-1 }&xm=${xm }">上一页</a>
			</c:if> 
			<c:if test="${pi.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pi.numbers }" var="numb">
						<c:if test="${numb == pi.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pi.index }">
					<a href="system/illcard?method=findIllCard&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pi.index !=pi.totalPageCount }">
				<a href="system/illcard?method=findIllCard&index=${pi.index+1 }&xm=${xm }">下一页</a>
			</c:if> 
			<c:if test="${pi.index ==pi.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/illcard?method=findIllCard&index=${pi.totalPageCount }&xm=${xm }">尾页</a>
			 共${pi.totalCount }条记录
			  </div>
	</div>
	</form>
</body>
</html>