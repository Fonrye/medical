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
		$.get("system/familyhold",{method:"deleteFamilyhold",id:id},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("用户删除成功");
					window.location.href="system/familyhold?method=allFamilyhold&&index=1";
				} 
			}else{
				window.top.location.href="login.jsp";
			}
		});

	}
}

function change(index,size){
 	document.forms[0].action="system/familyhold?method=allFamilyhold&index="+index+"&size="+size;
 	document.forms[0].submit();
}

</script>
</head>
<body>
   <form action="system/familyhold?method=allFamilyhold&index=1" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>户主姓名:</label> <input type="text" name="xm" class="form-control"
					placeholder="请输入搜索关键字"  value="${xm }" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
		</div>
    </form>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 参合人员信息列表</strong>
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
			
			<c:forEach items="${pfh.list }" var="fh">
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
							<a class="button border-red" href="javaScript:void(0)" onclick="del('${fh.id}','${fh.jtbh }')">
							<span class="icon-trash-o"></span> 删除</a>
						</div></td>
				</tr>
			</c:forEach>
			
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/familyhold?method=allFamilyhold&index=1">首页</a>
	        <c:if test="${pfh.index !=1 }">
				<a href="system/familyhold?method=allFamilyhold&index=${pfh.index-1 }">上一页</a>
			</c:if> 
			<c:if test="${pfh.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pfh.numbers }" var="numb">
						<c:if test="${numb == pfh.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pfh.index }">
					<a href="system/familyhold?method=allFamilyhold&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pi.index !=pi.totalPageCount }">
				<a href="system/familyhold?method=allFamilyhold&index=${pfh.index+1 }">下一页</a>
			</c:if> 
			<c:if test="${pfh.index ==pfh.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/familyhold?method=allFamilyhold&index=${pfh.totalPageCount }">尾页</a>
			 共${pfh.totalCount }条记录
			  </div>
			  </td>
           </tr>
	</div>
	
</body>
</html>