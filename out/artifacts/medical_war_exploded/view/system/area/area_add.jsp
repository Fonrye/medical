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

<title>创建行政区域</title>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jq.js"></script>
<script src="js/admin.js"></script>
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">新建行政区域</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/area?method=addArea"> 

      <div class="form-group">
        <div class="label">
          <label>所属行政区域：</label>
        </div>
        <div class="field">
          <select name="area" data-validate="required:请选择权限" class="input w50">
              <c:forEach items="${la }" var="a">
              <option value="${a.areaCode},${a.grade}">${a.areaName }</option>
              </c:forEach>
            </select>
          </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>行政区域名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="areaName"  data-validate="required:请输入用户名"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
	
</html>