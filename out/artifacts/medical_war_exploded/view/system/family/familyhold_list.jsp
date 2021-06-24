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
function del(id,jtbh){
	//判断用户选择是否发起ajax请求进行用户信息删除
	if(confirm("您确定要删除吗?")){
		//发起ajax请求进行用户信息的删除
		$.get("system/familyhold",{method:"deleteFamilyhold",jtbh:jtbh,id:id},function(data){
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

</script>
</head>
<body>
   <form action="" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>菜单名称:</label> <input type="text" name="" class="form-control"
					placeholder="请输入搜索关键字"  value="" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="view/system/family/familyhold_add.jsp?jtbh=${jtbh }" 
				class="btn btn-success">添加参合人员</a>
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 家庭参合人员信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>	<th width="7%">家庭编号</th>
				    <th width="7%">农合证号</th>
					<th width="7%">姓名</th>
					<th width="7%">与户主关系</th>
					<th width="7%">文化程度</th>
					<th width="7%">人员属性</th>
					<th width="7%">职业</th>
					<th width="7%">工作单位</th>
					<th width="7%">联系电话</th>
					<th width="10%">操作</th>
				</tr>
			
			<c:forEach items="${listFamilyhold }" var="fh">
				<tr>
				    <td>${fh.jtbh }</td>
					<td>${fh.nhzh }</td>
					<td>${fh.xm }</td>
					<td>${fh.yhzgx }</td>
					<td>${fh.whcd }</td>
					<td>${fh.rysx }</td>
					<td>${fh.zy }</td>
					<td>${fh.gzdw }</td>
					<td>${fh.lxdh }</td>
					
					<td><div class="button-group">
							<a class="button border-main" href="system/familyhold?method=findByIdFamilyhold&id=${fh.id }">
							<span class="icon-edit"></span> 修改</a>
							<%-- <a class="button border-red" href="javaScript:void(0)" onclick="del('${fh.id}','${fh.jtbh}')">
							<span class="icon-trash-o"></span> 删除</a> --%>
						</div></td>
				</tr>
			</c:forEach>
			
		</table>
		
	</div>
	</form>
</body>
</html>