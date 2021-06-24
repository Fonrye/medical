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
/*
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
*/
</script>
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">修改家庭档案信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/family?method=updateFamily"> 
    
    <div class="form-group">
        <div class="label">
          <label>县级编号：</label>
        </div>
        <div class="field">
         <select name="xjbh" class="input w50">
            <c:forEach items="${listArea }" var="la">
               <c:if test="${la.grade == 1 }">
                <option value="${la.areaCode }" ${family.xjbh ==la.areaCode?'selected':'' }>${la.areaName }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
    
    <div class="form-group">
        <div class="label">
          <label>乡镇编号：</label>
        </div>
        <div class="field">
          <select name="xzbh" class="input w50">
            <c:forEach items="${listArea }" var="la">
               <c:if test="${la.grade == 2 }">
                <option value="${la.areaCode }" ${family.xzbh ==la.areaCode?'selected':'' }>${la.areaName }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
    
      <div class="form-group">
        <div class="label">
          <label>村编号：</label>
        </div>
        <div class="field">
         <select name="cbh" class="input w50">
            <c:forEach items="${listArea }" var="la">
               <c:if test="${la.grade == 3 }">
                <option value="${la.areaCode }" ${family.cbh ==la.areaCode?'selected':'' }>${la.areaName }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>组编号：</label>
        </div>
        <div class="field">
          <select name="zbh" class="input w50">
            <c:forEach items="${listArea }" var="la">
               <c:if test="${la.grade == 4 }">
                <option value="${la.areaCode }" ${family.zbh ==la.areaCode?'selected':'' }>${la.areaName }</option>
               </c:if>
            </c:forEach>
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>家庭编号</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtbh" value="${family.jtbh }" readonly="readonly" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>户属性：</label>
        </div>
        <div class="field">
          <select class="input w50" name="hsx" data-validate="required:必填项">
           <option value="农村" ${family.hsx=='农村'?'selected':'' }>农村</option>
           <option value="城市" ${family.hsx=='城市'?'selected':'' }>城市</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>户主姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="hzxm" value="${family.hzxm }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>家庭人口数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtrks" value="${family.jtrks }" readonly="readonly" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>农业人口数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nyrks" value="${family.nyrks }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>家庭住址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtdz" value="${family.jtdz }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>创建档案时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" name="cjdasj" value="${family.cjdasj }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>登记员：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="djy" value="${family.djy }" readonly="readonly" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>

      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
        <input
					type="reset" class="button bg-main icon-check-square-o" value="重置信息" />
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
	
</html>