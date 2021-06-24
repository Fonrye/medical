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

</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">修改慢病政策设置</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/chronicdisSet?method=update"> 

      <div class="form-group">
        <div class="label">
          <label>年度：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="year" value="<%=request.getParameter("year") %>" readonly="readonly" data-validate="required:必填项"  />
          <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>疾病名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="illName" value="<%=request.getParameter("illName") %>" readonly="readonly" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>封顶线：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="moneyCapping" value="<%=request.getParameter("moneyCapping") %>" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>报销比例：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="percentage" value="<%=request.getParameter("percentage") %>" data-validate="required:必填项"  />
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