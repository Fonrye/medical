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

function onc(jtbh){
		//发起ajax请求进行用户信息的删除
		$.get("system/participation",{method:"findAllById",jtbh:jtbh},function(data){
			if("true"==data){
				if(eval(data)){
					alert("现在不是参合缴费时间或管理员未设置本年度缴费信息");	
				} 
			}else if("false"==data){
				alert("该家庭已经全部缴费");
			}else{
				window.location.href="system/participation?method=findAllById&&jtbh="+jtbh;
			}
		});

	
}

</script>
</head>
<body>
   <form action="system/participation?method=findAllFamily&index=1" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>户主姓名:</label> <input type="text" name="hzxm" class="form-control"
					placeholder="请输入搜索关键字"  value="${hzxm }" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
		</div>
    </form>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 家庭档案户主信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>	<th width="7%">家庭编号</th>
				    <th width="7%">户属性</th>
					<th width="7%">户主姓名</th>
					<th width="7%">家庭人口数</th>
					<th width="7%">农业人口数</th>
					<th width="7%">家庭住址</th>
					<th width="7%">创建档案时间</th>
					<th width="7%">登记员</th>
					
					<th width="10%">操作</th>
				</tr>
			
			<c:forEach items="${pf.list }" var="f">
				<tr>
				    <td>${f.jtbh }</td>
					<td>${f.hsx }</td>
					<td>${f.hzxm }</td>
					<td>${f.jtrks }</td>
					<td>${f.nyrks }</td>
					<td>${f.jtdz }</td>
					<td>${f.cjdasj }</td>
					<td>${f.djy }</td>
					
					<td><div class="button-group">
							<!--  
							  <a class="button border-main" href="system/participation?method=findAllById&jtbh=${f.jtbh }"> 
							<span class="icon-edit"></span>参合缴费</a>
							-->
							<a class="button border-red" href="javascript:void(0)" onclick="onc('${f.jtbh} ')"><span class="icon-trash-o"></span> 参合缴费</a> </div></td>
						</div></td>
				</tr>
			</c:forEach>
			
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/family?method=findAllFamily&index=1">首页</a>
	        <c:if test="${pf.index !=1 }">
				<a href="system/family?method=findAllFamily&index=${pf.index-1 }">上一页</a>
			</c:if> 
			<c:if test="${pf.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pf.numbers }" var="numb">
						<c:if test="${numb == pf.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pf.index }">
					<a href="system/family?method=findAllFamily&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pi.index !=pi.totalPageCount }">
				<a href="system/family?method=findAllFamily&index=${pf.index+1 }">下一页</a>
			</c:if> 
			<c:if test="${pf.index ==pf.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/family?method=findAllFamily&index=${pf.totalPageCount }">尾页</a>
			 共${pf.totalCount }条记录
			  </div>
			  </td>
           </tr>
	</div>
	
</body>
</html>