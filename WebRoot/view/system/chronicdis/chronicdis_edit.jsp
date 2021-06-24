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

<title>修改行政区域</title>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jq.js"></script>
<script src="js/admin.js"></script>
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">修改慢性病信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/chronicdis?method=updateChr"> 

      <div class="form-group">
        <div class="label">
          <label>慢性病编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  value="<%=request.getParameter("illCode") %>" disabled="disabled" />
          <input type="hidden" class="input w50" name="illCode" value="<%=request.getParameter("illCode") %>"  />
          </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>慢性病名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="illName" value="<%=request.getParameter("illName") %>"data-validate="required:慢性病名称" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>慢性病码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="pyCode" value="<%=request.getParameter("pyCode") %>" data-validate="required:慢性病码"/>
        
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>慢性病五笔码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="wbCode" value="<%=request.getParameter("wbCode") %>" data-validate="required:慢性病五笔码" />
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