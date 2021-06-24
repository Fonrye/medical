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

$(function(){
	//通过Ajax获取所有的行政区域列表并输出
	$.ajax({
		url:"system/statistic?method=allArea",
		type:"POST",
		success:function(jsonStr){//输出所有的部门列表
			//jsontstr---json object
			eval("var arr = "+ jsonStr);
			//拼接所有的option字符串
			var str = '<option value="">--全部--</option>';
			for(var i=0;i<arr.length;i++){
			
				str+='<option value="'+arr[i].areaCode+'">'+arr[i].areaName+'</option>';

			}
			//一次性写入到select deptno列表中
			$("#areaCode").html(str);
		}
	
	});
	
	//通过Ajax获取所有的病种列表并输出
	$.ajax({
		url:"system/statistic?method=allChronicdis",
		type:"POST",
		success:function(jsonStr){//输出所有的部门列表
			//jsontstr---json object
			eval("var arr = "+ jsonStr);
			//拼接所有的option字符串
			var str = '<option value="">--全部--</option>';
			for(var i=0;i<arr.length;i++){
			
				str+='<option value="'+arr[i].illName+'">'+arr[i].illName+'</option>';

			}
			//一次性写入到select deptno列表中
			$("#illName").html(str);
		}
	
	});
	
	//给导出按钮绑定点击事件
	$("#btn2").click(function(){
		//获取三个查询条件的值
		var name = $("#name").val();
		//var areaCode = $("#areaCode").val();
		var illName = $("#illName").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		
		//通过 Ajax获取请求得到数据并通过回调函数输出
		//alert(xm+"  "+areaCode+"  "+jfnd+"  "+qssj+"  "+jssj);
		//访问指定的Servlet，不使用Ajax（因为Ajax是通过回调函数处理结果的，导出XLS是直接返回流，所以也不使用转发和重定向）
		if(confirm("您确定要导出吗?")){
			
		location.href="system/statistic?method=exportXls&name="+name+"&illName="+illName+"&startTime="+startTime+"&endTime="+endTime;
		}
	});
	
})

</script>
</head>
<body>
   <form action="system/statistic?method=findAllReim&index=1" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>报销人姓名:</label> <input type="text" id="name" name="name" value="${name }" class="form-control"
					placeholder="请输入搜索关键字"  />
			</div>
			<!-- 
			<div class="form-group">
				<label>行政区域:</label> 
				<select id="areaCode" name="areaCode" class="form-control"></select>
			</div>
			 -->
			<div class="form-group">
				<label>疾病名称:</label> 
				<select id="illName" name="illName" class="form-control"></select>
			</div>
			
			<div class="form-group">
				<label>开始时间:</label> <input type="date" id="startTime" name="startTime" value="${startTime }" class="form-control"
					/>
			</div>
			<div class="form-group">
				<label>结束时间:</label> <input type="date" id="endTime" name="endTime" value="${endTime }" class="form-control"
					/>
			</div>
			
			<input type="submit" class="btn btn-danger" value="查询"> 
			<input type="button" id="btn2" class="btn btn-success" value="导出Excel">
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
					<th >年份</th><!-- 未审核，已审核 -->
					
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
					<td>${p.year }</td>
					
					
				</tr>
			</c:forEach>
					
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/statistic?method=findAllReim&index=1&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">首页</a>
	        <c:if test="${pr.index !=1 }">
				<a href="system/statistic?method=findAllReim&index=${pr.index-1 }&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">上一页</a>
			</c:if> 
			<c:if test="${pr.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pr.numbers }" var="numb">
						<c:if test="${numb == pr.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pr.index }">
					<a href="system/statistic?method=findAllReim&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pr.index !=pr.totalPageCount }">
				<a href="system/statistic?method=findAllReim&index=${pr.index+1 }&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">下一页</a>
			</c:if> 
			<c:if test="${pr.index ==pr.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/statistic?method=findAllReim&index=${pr.totalPageCount }&name=${name }&startTime=${startTime}&endTime=${endTime }&status=${status}">尾页</a>
			 共${pr.totalCount }条记录
			  </div>
			  </td>
           </tr>
	</div>
	</form>
</body>
</html>