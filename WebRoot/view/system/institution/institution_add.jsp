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
  <div class="panel-head" ><strong class="icon-reorder">增加经办机构编码信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/institution?method=addIns"> 


      <div class="form-group">
        <div class="label">
          <label>所属行政区域：</label>
        </div>
        <div class="field">
        <!-- 一个行政区域只能有一个经办机构 -->
          <select name="area" data-validate="required:请选择所属行政区域" class="input w50">
              <c:forEach items="${la }" var="a">
              	<c:if test="${a.areaCode!=0 }">
              		<option value="${a.areaCode},${a.grade}">${a.areaName }</option>
              	</c:if>
              </c:forEach>
            </select>
          </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>经办机构编码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="agenCode"  data-validate="required:请输入经办机构编码"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>经办机构名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="agenName"  data-validate="required:请输入经办机构名称"  />
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