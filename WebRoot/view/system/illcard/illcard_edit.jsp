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
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">修改慢病证</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/illcard?method=update"> 

      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="xm" id="xm" value="${li[0].xm }" data-validate="required:请输入姓名" autocomplete="off"/><!-- autocomplete是历史输入记录，on是开启，off是关闭 -->
          <input type="hidden" name="id" value="${li[0].id }">
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>农合证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nhzh" id="nhzh" value="${li[0].nhzh }" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label>身份证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sfzh" id="sfzh" value="${li[0].sfzh }" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label>慢病证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="illCardId" id="illCardId" value="${li[0].illCardId }" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div> 
        
          
      <div class="form-group">
        <div class="label">
          <label>疾病名称：</label>
        </div>
        <div class="field">
          <select name="illname" id="illname" data-validate="required:请选择" class="input w50">
              <c:forEach items="${lc }" var="c">
              	<option value="${c.illName }"${li[0].illName==c.illName?'selected':'' }>${c.illName }</option>
              </c:forEach>
          </select>
          <div class="tips"></div>
        </div>
      </div>
        
      <div class="form-group">
        <div class="label">
          <label>开始时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" value="${li[0].startTime }" name="startTime"  />
          <div class="tips"></div>
        </div>
      </div>  
      
      <div class="form-group">
        <div class="label">
          <label>结束时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" value="${li[0].endTime }" name="endTime"  />
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