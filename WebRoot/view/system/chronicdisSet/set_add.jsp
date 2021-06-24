<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<title></title>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jq.js"></script>
<script src="js/admin.js"></script>
<script type="text/javascript">

$(function(){
  //给用户名文本框添加失去焦点事件
  $("#illName").blur(function(){
    //发起ajax请求，校验账号是否被注册
    $.get("system/chronicdisSet?method=check",{illName:$("#illName").val()},function(data){
      if(eval(data)){
        //获取span对象
        var span = document.getElementById("illNameSpan");
        var submit = document.getElementById("submit");
        span.style.color="red";
        
        //将数据填充到span中
        span.innerHTML="该慢性病在本年度已经设置过";
        submit.disabled = true;
      }else{
	   //获取Span对象
	   var span=document.getElementById("illNameSpan");
	   var submit = document.getElementById("submit");
	   //设置span颜色
	   span.style.color="green";
	   //将数据填充到span中
	   span.innerHTML="";
	   submit.disabled = false;
		  }
    });
  })
})

</script>
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">慢病政策设置</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/chronicdisSet?method=add"> 

      <div class="form-group">
        <div class="label">
          <label>慢性病名称：</label>
        </div>
        <div class="field">
          <select name="illName" class="input w50" id="illName" data-validate="required:必填项" >
          	  <option value="">--请选择--</option>
              <c:forEach items="${Chronicdis }" var="list">
              <option value="${list.illName }">${list.illName }</option>
              </c:forEach>
            </select>
            <span id="illNameSpan"></span>
          </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>封顶线：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="moneyCapping"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>报销比例：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="percentage"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" id="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
	
</html>