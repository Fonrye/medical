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
function del(jgbm,index){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/medical",{method:"deleteMedical",jgbm:jgbm},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/medical?method=findAllMedical&&index=1";
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
				<label>医疗机构名称:</label> <input type="text" name="" class="form-control"
					placeholder="请输入搜索关键字"  value="" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="system/medical?method=findAllS201" class="btn btn-success">添加医疗机构</a>
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 医疗机构信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>	<th width="7%">编号</th>
				    <th width="7%">组织机构编号</th>
					<th width="7%">机构级别</th>
					<th width="7%">机构名称</th>
					<th width="7%">批准定点类型</th>
					<th width="7%">所属经济类型</th>
					<th width="7%">卫生机构小类</th>
					<th width="7%">主管单位</th>
					<th width="7%">成立时间</th>
					<th width="7%">法人</th>
					<th width="7%">注册资金</th>
					<th width="10%">操作</th>
				</tr>
			
			<c:forEach items="${pm.list }" var="m">
				<tr>
				    <td>${m.jgbm }</td>
					<td>${m.zzjgbm }</td>
					<td>${m.jgjb }</td>
					<td>${m.jgmc }</td>
					<td>${m.pzddlx }</td>
					<td>${m.ssjjlx }</td>
					<td>${m.wsjgdl }</td>
					<td>${m.zgdw }</td>
					<td>${m.kysj }</td>
					<td>${m.frdb }</td>
					<td>${m.zczj }</td>
					<td><div class="button-group">
							<a class="button border-main" href="system/medical?method=findById&jgbm=${m.jgbm }">
							<span class="icon-edit"></span> 修改</a> 
							<a class="button border-red" href="javaScript:void(0)" onclick="del('${m.jgbm}','${pm.index }')">
							<span class="icon-trash-o"></span> 删除</a>
						</div></td>
				</tr>
			</c:forEach>
			
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/medical?method=findAllMedical&index=1">首页</a>
	        <c:if test="${pm.index !=1 }">
				<a href="system/medical?method=findAllMedical&index=${pm.index-1 }">上一页</a>
			</c:if> 
			<c:if test="${pm.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pm.numbers }" var="numb">
						<c:if test="${numb == pm.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pm.index }">
					<a href="system/medical?method=findAllMedical&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pi.index !=pi.totalPageCount }">
				<a href="system/medical?method=findAllMedical&index=${pm.index+1 }">下一页</a>
			</c:if> 
			<c:if test="${pm.index ==pm.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/medical?method=findAllMedical&index=${pm.totalPageCount }">尾页</a>
			 共${pm.totalCount }条记录
			  </div>
			  </td>
           </tr>
	</div>
	</form>
</body>
</html>