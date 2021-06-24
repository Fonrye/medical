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
function update(id,status,index){
	//判断用户选择是否发起ajax请求进行操作
	if(confirm("您确定要进行此操作吗?")){
		$.get("system/reimbursement",{method:"updateStatus",id:id,status:status},function(data){
			if("true"==data){//判断返回的是否是删除成功的字符串，还是session失效后的登录页面
				if(eval(data)){
					alert("操作成功");
					window.location.href="system/reimbursement?method=findAllReim&index=1";
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
   <form action="system/reimbursement?method=findAllReim&index=1" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>报销人姓名:</label> <input type="text" name="name" value="${name }" class="form-control"
					placeholder="请输入搜索关键字"  />
			</div>
			<div class="form-group">
				<label>报销状态:</label> <select name="status" class="input" 
						style="width:150px; height:40px;display:inline-block">
						<option value="">--请选择--</option>
						<option value="0">---未审核---</option>
						<option value="1">---已审核---</option>
						<option value="2">----已汇款----</option>
						<option value="3">----取消汇款----</option>
						</select>
			</div>
			
			<div class="form-group">
				<label>开始时间:</label> <input type="date" name="startTime" value="${startTime }" class="form-control"
					/>
			</div>
			<div class="form-group">
				<label>结束时间:</label> <input type="date" name="endTime" value="${endTime }" class="form-control"
					/>
			</div>
			
			<input type="submit" class="btn btn-danger" value="查询"> 
		</div>
    
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 报销信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>	
				   
					<th width="15%">姓名</th>
					<th width="10%">身份证号</th>
					<th width="15%">慢病证号</th>
					<th width="10%">疾病名称</th>
					<th width="10%">花费金额</th>
					<th width="10%">报销金额</th>
					<th width="10%">报销时间</th>
					<th >状态</th><!-- 未审核，已审核 -->
					<th width="10%">操作</th>
				</tr>
				
				<c:forEach items="${pr.list }" var="p">
				<tr>
				    
					<td>${p.name }</td>
					<td>${p.sfzh }</td>
					<td>${p.illcardNo }</td>
					<td>${p.illname }</td>
					<td>${p.illMoney }</td>
					<td>${p.money }</td>
					<td>${p.bxsj }</td>
					<td><c:if test="${p.status==0 }">待审核</c:if>
						<c:if test="${p.status==1 }">已审核</c:if>
						<c:if test="${p.status==2 }">已汇款</c:if>
						<c:if test="${p.status==3 }">取消汇款</c:if>
					</td>
					
					<td><c:if test="${p.status==0 }"><a class="button border-main" href="javascript:void(0)" onclick="update('${p.id}','${p.status }','${pr.index }')">
							<span class="icon-edit"></span>确认审核</a>
						</c:if>
						<c:if test="${p.status==1 }"><a class="button border-green" href="javascript:void(0)" onclick="update('${p.id}','${p.status }','${pr.index }')">
							<span class="icon-edit"></span>确认汇款</a>
						</c:if>
						<c:if test="${p.status==2 }"><a class="button border-red" href="javascript:void(0)" onclick="update('${p.id}','${p.status }','${pr.index }')">
							<span class="icon-edit"></span>取消汇款</a>
						</c:if>
						<c:if test="${p.status==3 }"><a class="button border-main" href="javascript:void(0)">
							<span class="icon-edit"></span>空连接</a>
						</c:if>
						
					</td>
				</tr>
			</c:forEach>
					
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/reimbursement?method=findAllReim&index=1&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">首页</a>
	        <c:if test="${pr.index !=1 }">
				<a href="system/reimbursement?method=findAllReim&index=${pr.index-1 }&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">上一页</a>
			</c:if> 
			<c:if test="${pr.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pr.numbers }" var="numb">
						<c:if test="${numb == pr.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pr.index }">
					<a href="system/reimbursement?method=findAllReim&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pr.index !=pr.totalPageCount }">
				<a href="system/reimbursement?method=findAllReim&index=${pr.index+1 }&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">下一页</a>
			</c:if> 
			<c:if test="${pr.index ==pr.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/reimbursement?method=findAllReim&index=${pr.totalPageCount }&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">尾页</a>
			 共${pr.totalCount }条记录
			  </div>
			  </td>
           </tr>
	</div>
	</form>
</body>
</html>