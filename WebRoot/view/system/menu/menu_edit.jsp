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


<title>编辑菜单</title>


<link rel="stylesheet"href="css/pintuer.css">
<link rel="stylesheet"href="css/admin.css">
<link rel="stylesheet"href="js/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet"href="js/zTree_v3/css/demo.css">
<script src="js/jq.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/zTree_v3/js/jquery.ztree.all.js"></script>
<script src="js/admin.js"></script>
</head>


<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">编辑菜单</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/menu?method=updateMenu" id="form">  
           

      <div class="form-group">
        <div class="label">
          <label>菜单编号：</label>
        </div>
        <div class="field" >
          <input type="text" class="input w50"  value="<%=request.getParameter("menuId") %>" disabled="disabled"/>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="hidden" class="input w50" name="menuId" id="menuId" value="<%=request.getParameter("menuId") %>" />
          <div class="tips"></div>
        </div>
      </div>        
      
      
      <div class="form-group">
        <div class="label">
          <label>菜单名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="menuName" value="<%=request.getParameter("menuName") %>" />
           <input type="hidden" class="input w50" name="menuName" id="menuName" value="<%=request.getParameter("menuName") %>" />
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>访问Url：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="menuUrl" value="<%=request.getParameter("menuUrl") %>" />
           <input type="hidden" class="input w50" name="menuUrl" id="menuUrl" value="<%=request.getParameter("menuUrl") %>" />
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" id="submit" type="submit"> 提交</button>
        </div>
      </div>
         </form> 
  </div>
</div>

</body>

	
</html>