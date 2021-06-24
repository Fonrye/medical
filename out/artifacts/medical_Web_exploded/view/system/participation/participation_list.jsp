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
//var jfnd1 = {jfnd:'${jfnd}'}
//var areaCode1 = {areaCode:'${areaCode}'.length > 0 ? "${areaCode}" :""}
$(function(){
	//通过Ajax获取所有的行政区域列表并输出
	$.ajax({
		url:"system/participation?method=findAllArea",
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
	
	$.ajax({
		url:"system/participation?method=findAllYear",
		type:"POST",
		success:function(jsonStr){//输出所有的部门列表
			//jsontstr---json object
			eval("var arr = "+ jsonStr);
			//拼接所有的option字符串
			var str = '<option value="">--全部--</option>';
			for(var i=0;i<arr.length;i++){
				
			 	str+='<option value="'+arr[i].jfnd+'">'+arr[i].jfnd+'</option>';
			}
			//一次性写入到select deptno列表中
			$("#jfnd").html(str);
		}
	
	});
	
	//给导出按钮绑定点击事件
	$("#btn2").click(function(){
		//获取三个查询条件的值
		var xm = $("#xm").val();
		var areaCode = $("#areaCode").val();
		var jfnd = $("#jfnd").val();
		var qssj = $("#qssj").val();
		var jssj = $("#jssj").val();
		
		//通过 Ajax获取请求得到数据并通过回调函数输出
		//alert(xm+"  "+areaCode+"  "+jfnd+"  "+qssj+"  "+jssj);
		//访问指定的Servlet，不使用Ajax（因为Ajax是通过回调函数处理结果的，导出XLS是直接返回流，所以也不使用转发和重定向）
		if(confirm("您确定要导出吗?")){
			
		location.href="system/participation?method=exportXls&xm="+xm+"&areaCode="+areaCode+"&jfnd="+jfnd+"&qssj="+qssj+"&jssj="+jssj;
		}
	});
});
</script>
</head>
<body>
   <form action="system/participation?method=findAll&index=1" method="post" class="form-inline">
     
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
		 <a href="system/participation?method=findAllFamily&index=1" class="btn btn-success">参合登记</a>
			<div class="form-group">
				<label>姓名:</label> <input type="text" name="xm" id="xm" value="${xm }" class="form-control"
					placeholder="请输入搜索关键字" />
			</div>
			<div class="form-group">
				<label>行政区域:</label> 
				<select id="areaCode" name="areaCode" class="form-control"></select>
			</div>
			<div class="form-group">
				<label>年份:</label> 
				<select id="jfnd" name="jfnd" class="form-control"></select>
			</div>
			<div class="form-group">
				<label>缴费起始时间:</label> <input type="date" name="qssj" id="qssj" value="${qssj }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>缴费结束时间:</label> <input type="date" name="jssj" id="jssj" value="${jssj }" class="form-control"/>
			</div>
			<input type="submit" id="btn1" class="btn btn-danger" value="查询"> 
			<input type="button" id="btn2" class="btn btn-success" value="导出Excel">
		</div>
    </form>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 家庭档案信息列表</strong>
		</div>

		<table class="table table-hover text-center">
			<tr>	<th width="7%">参合证号</th>
				    <th width="7%">参合发票号</th>
					<th width="7%">家庭编号</th>
				     <th width="7%">姓名</th>
					<th width="7%">缴费金额</th>
					<th width="7%">缴费年度</th>
					<th width="7%">缴费时间</th>
					<th width="7%">身份证号</th>
					<!-- <th width="7%">操作员</th> -->
					
				</tr>
			
			<c:forEach items="${pp.list }" var="p">
				<tr>
				    <td>${p.chzh }</td>
					<td>${p.chfph }</td>
					<td>${p.jtbh }</td>
					<td>${p.xm }</td>
					<td>${p.jfje }</td>
					<td>${p.jfnd }</td>
					<td>${p.jfsj }</td>
					<td>${p.sfzh }</td>
					<%-- <td>${p.czy }</td> --%>
					
				</tr>
			</c:forEach>
			
		</table>
		<tr>
			
	        <td colspan="8"><div class="pagelist"> 
	        <a href="system/participation?method=findAll&index=1&areaCode=${areaCode }&xm=${xm}&jfnd=${jfnd }&qssj=${qssj}&jssj=${jssj}">首页</a>
	        <c:if test="${pp.index !=1 }">
				<a href="system/participation?method=findAll&index=${pp.index-1 }&areaCode=${areaCode }&xm=${xm}&jfnd=${jfnd }&qssj=${qssj}&jssj=${jssj}">上一页</a>
			</c:if> 
			<c:if test="${pp.index ==1 }"><a href="javascript:void(0)">上一页</a></c:if> 
			
			 
			 
			 <c:forEach items="${pp.numbers }" var="numb">
						<c:if test="${numb == pp.index }">
			<span class="current">${numb }</span>
			
			</c:if>
				<c:if test="${numb != pp.index }">
					<a href="system/participation?method=findAll&index=${numb }">${numb }</a>
				</c:if>
			</c:forEach> 
					
					
			<c:if test="${pi.index !=pi.totalPageCount }">
				<a href="system/participation?method=findAll&index=${pp.index+1 }&areaCode=${areaCode }&xm=${xm}&jfnd=${jfnd }&qssj=${qssj}&jssj=${jssj}">下一页</a>
			</c:if> 
			<c:if test="${pp.index ==pp.totalPageCount }">
			<a href="javascript:void(0)">下一页</a>
			</c:if> 
			 
			<a href="system/participation?method=findAll&index=${pp.totalPageCount }&areaCode=${areaCode }&xm=${xm}&jfnd=${jfnd }&qssj=${qssj}&jssj=${jssj}">尾页</a>
			 共${pp.totalCount }条记录
			  </div>
			  </td>
           </tr>
	</div>
	
</body>
</html>