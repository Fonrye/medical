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
//验证账号是否存在
//页面加载成功给HTML元素添加事件
$(function(){
  //给用户名文本框添加失去焦点事件
  $("#jgbm").blur(function(){
    //发起ajax请求，校验账号是否被注册
    $.get("system/medical?method=checkJgbm",{jgbm:$("#jgbm").val()},function(data){
      if(eval(data)){
        //获取span对象
        var span = document.getElementById("jgbmSpan");
        var submit = document.getElementById("submit");
        span.style.color="red";
        
        //将数据填充到span中
        span.innerHTML="账号已存在";
        submit.disabled = true;
      }else{
	   //获取Span对象
	   var span=document.getElementById("jgbmSpan");
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
  <div class="panel-head" ><strong class="icon-reorder">增加医疗机构信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/medical?method=addMedical"> 
    
    <div class="form-group">
        <div class="label">
          <label>医疗机构编码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jgbm" id="jgbm" 
          data-validate="required:请输入医疗机构编码"  />
          <span id="jgbmSpan"></span>
        </div>
      </div>
    
    <div class="form-group">
        <div class="label">
          <label>组织机构编码：：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="zzjgbm"  data-validate="required:请输入组织机构编码"  />
          <div class="tips"></div>
        </div>
      </div>
    
      <div class="form-group">
        <div class="label">
          <label>机构名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jgmc"  data-validate="required:请输入机构名称"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>地区编码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="dqbm"  data-validate="required:请输入地区编码"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>行政区域编码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="areacode"  data-validate="required:请输入行政区域编码"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>隶属关系：</label>
        </div>
        <div class="field">
         <select name="lsgx" class="input w50">
            <c:forEach items="${listS201 }" var="s">
               <c:if test="${s.type == 1 }">
                <option value="${s.itemname }">${s.itemname }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>机构级别：：</label>
        </div>
        <div class="field">
         <select name="jgjb" class="input w50">
            <c:forEach items="${listS201 }" var="s">
               <c:if test="${s.type == 2 }">
                <option value="${s.itemname }">${s.itemname }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>申报定点类型：</label>
        </div>
        <div class="field">
         <select name="sbddlx" class="input w50">
            <c:forEach items="${listS201 }" var="s">
               <c:if test="${s.type == 3 }">
                <option value="${s.itemname }">${s.itemname }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>批准定点类型：</label>
        </div>
        <div class="field">
         <select name="pzddlx" class="input w50">
            <c:forEach items="${listS201 }" var="s">
               <c:if test="${s.type == 3 }">
                <option value="${s.itemname }">${s.itemname }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>所属经济类型：</label>
        </div>
        <div class="field">
         <select name="ssjjlx" class="input w50">
            <c:forEach items="${listS201 }" var="s">
               <c:if test="${s.type == 4 }">
                <option value="${s.itemname }">${s.itemname }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>卫生机构大类：</label>
        </div>
        <div class="field">
         <select name="wsjgdl" class="input w50">
            <c:forEach items="${listS201 }" var="s">
               <c:if test="${s.type == 5 }">
                <option value="${s.itemname }">${s.itemname }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>卫生机构小类：</label>
        </div>
       <div class="field">
         <select name="wsjgxl" class="input w50">
            <c:forEach items="${listS201 }" var="s">
               <c:if test="${s.type == 5 }">
                <option value="${s.itemname }">${s.itemname }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>主管单位：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="zgdw"  data-validate="required:请输入主管单位"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>开业时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" name="kysj"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>法人代表：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="frdb"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>注册资金：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="zczj"  data-validate="required:必填项"  />
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