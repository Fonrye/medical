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
<!--
$(function(){
  //给用户名文本框添加失去焦点事件
  $("#jtbh").blur(function(){
    //发起ajax请求，校验账号是否被注册
    $.get("system/family?method=checkJtbh",{jtbh:$("#jtbh").val()},function(data){
      if(eval(data)){
        //获取span对象
        var span = document.getElementById("jtbhSpan");
        var submit = document.getElementById("submit");
        span.style.color="red";
        
        //将数据填充到span中
        span.innerHTML="账号已存在";
        submit.disabled = true;
      }else{
	   //获取Span对象
	   var span=document.getElementById("jtbhSpan");
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
-->
//自动生成家庭编号
$(function(){
	//给用户名文本框添加失去焦点事件
	$("#zbh").blur(function(){
		//发起ajax请求
		$.get("system/family?method=addNo",{zbh:$("#zbh").val()},function(data){
			 //alert(data);
			 eval("var i ="+data);
			 $("#jtbh").val(i);
			

		});
	})
})


//页面加载成功请求省得信息
$(function(){
	 
	 //发起ajax请求，请求所有的县信息
	 
	 getData1(450421,"xjbh",1);
	 //页面加载成功给县下拉框添加onchange事件
	 $("#xjbh").change(function(){
		 //获取当前选择的县的areacode
		 var areaCode=$("#xjbh").val();
		 //发起ajax请求，请求当前县的镇信息
		 getData(areaCode,"xzbh",2);
	 });
	 //页面加载成功给市下拉框添加onchange事件
	 $("#xzbh").change(function(){
		 //获取当前选择的镇的areacode
		 var areaCode=$("#xzbh").val();
		 getData(areaCode,"cbh",3)
	 }) 
	  $("#cbh").change(function(){
		 //获取当前选择的村的areacode
		 var areaCode=$("#cbh").val();
		 getData(areaCode,"zbh",4)
	 }) 
	 
	//封装公共方法
	 function getData(areaCode,sid,grade){
		 //发送ajax请求，请求当前省的市信息
		 $.get("${pageContext.request.contextPath}/system/family",{method : "findArea",areaCode:areaCode,grade:grade},function(data){
			 //使用eval方法将数据转换为js对象
			 eval("var areas="+data);
			 //获取下拉框对象
			 var sel=$("#"+sid);
			 //清空原有内容
			 sel.empty();
			 //遍历
			 sel.append("<option value=''>----请选择----</option>")
			 for(var i=0;i<areas.length;i++){
				 sel.append("<option value='"+areas[i].areaCode+"'>"+areas[i].areaName+"</option>")
			 }
			 //触发省下拉框的change事件
			 $("#"+sid).trigger("change");
		 });
	 }
 })

   function getData1(areaCode,sid,grade){	 
	//发送ajax请求，请求当前县信息
	 $.get("${pageContext.request.contextPath}/system/family",{method : "findArea",areaCode:areaCode,grade:grade},function(data){
		 //使用eval方法将数据转换为js对象
		 eval("var areas="+data);
		 
		 //获取下拉框对象
		 var sel=$("#"+sid);
		 //清空原有内容
		 sel.empty();
		 //遍历
		 for(var i=0;i<areas.length;i++){
			 sel.append("<option value='"+areas[i].areaCode+"'>"+areas[i].areaName+"</option>")
		 }
		 //触发省下拉框的change事件
		 $("#"+sid).trigger("change");
	 });
}


</script>
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">增加家庭档案信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/family?method=addFamily"> 
    
    <div class="form-group">
        <div class="label">
          <label>县级编号：</label>
        </div>
        <div class="field">
         <select name="xjbh" id="xjbh" readonly="readonly" class="input w50">
             <option value='450421'>苍梧县</option>
         </select>
        </div>
      </div>
    
    <div class="form-group">
        <div class="label">
          <label>乡镇编号：</label>
        </div>
        <div class="field">
          <select name="xzbh" id="xzbh" class="input w50" data-validate="required:必填项">
            
         </select>
        </div>
      </div>
    
      <div class="form-group">
        <div class="label">
          <label>村编号：</label>
        </div>
        <div class="field">
         <select name="cbh" id="cbh" class="input w50" data-validate="required:必填项">
            
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>组编号：</label>
        </div>
        <div class="field">
          <select name="zbh" id ="zbh" class="input w50" data-validate="required:必填项">
            
         </select>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>家庭编号</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtbh"  id="jtbh" readonly="readonly"
          data-validate="required:必填项"  />
          <span id="jtbhSpan"></span>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>户属性：</label>
        </div>
        <div class="field">
          <select class="input w50" name="hsx"  data-validate="required:必填项" >
           <option value="">请选择</option>
           <option value="城市">城市</option>
           <option value="农村">农村</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>户主姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="hzxm"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>家庭人口数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtrks" value="1" readonly="readonly" id = "jtrks" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      <!-- 
      <div class="form-group">
        <div class="label">
          <label>农业人口数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nyrks"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
       -->
        <input type="hidden" class="input w50" name="nyrks" value="1"  />
        
      <div class="form-group">
        <div class="label">
          <label>家庭住址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtdz"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>创建档案时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" name="cjdasj"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      <!--  
      <div class="form-group">
        <div class="label">
          <label>登记员：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="djy" value="${sessionScope.user.userName}" readonly="readonly" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      -->
      <input type="hidden" class="input w50" name="djy" value="${sessionScope.user.userName}" readonly="readonly"  />
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
        <input
					type="reset" class="button bg-main icon-check-square-o" value="重置信息" />
          <button class="button bg-main icon-check-square-o" type="submit" id="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
	
</html>