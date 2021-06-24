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
  $("#sfzh").blur(function(){
    //发起ajax请求，校验账号是否被注册
    $.get("system/familyhold?method=checkSfzh",{sfzh:$("#sfzh").val()},function(data){
      if(eval(data)){
        //获取span对象
        var span = document.getElementById("sfzhSpan");
        var submit = document.getElementById("submit");
        span.style.color="red";
        
        //将数据填充到span中
        span.innerHTML="账号已存在";
        submit.disabled = true;
      }else{
	   //获取Span对象
	   var span=document.getElementById("sfzhSpan");
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
  <div class="panel-head" ><strong class="icon-reorder">增加家庭参合人员信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/familyhold?method=addFamilyhode"> 
    
    <div class="form-group">
        <div class="label">
          <label>家庭编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtbh" value="<%=request.getParameter("jtbh") %>" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
    
    <div class="form-group">
        <div class="label">
          <label>农合证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nhzh" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
    
      <div class="form-group">
        <div class="label">
          <label>医疗证卡号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="ylzkh" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <!--  
      <div class="form-group">
        <div class="label">
          <label>户内编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="hnbh" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      -->
      
      <div class="form-group">
        <div class="label">
          <label>姓名</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="xm"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>与户主关系：</label>
        </div>
        <div class="field">
          <select class="input w50" name="yhzgx"  data-validate="required:必填项" >
            <option value="">请选择</option>
            <option value="户主">户主</option>
            <option value="夫妻">夫妻</option>
            <option value="儿女">儿女</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>身份证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sfzh" id="sfzh"  data-validate="required:必填项"  />
          <span id="sfzhSpan"></span>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <select class="input w50" name="xb"  data-validate="required:必填项" >
            <option value="">请选择</option>
            <option value="男">男</option>
            <option value="女">女</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>健康状况：</label>
        </div>
        <div class="field">
          <select class="input w50" name="jkzk"  data-validate="required:必填项" >
            <option value="">请选择</option>
            <option value="健康">健康</option>
            <option value="患病">患病</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>民族：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="mz"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>文化程度：</label>
        </div>
        <div class="field">
          <select class="input w50" name="whcd"  data-validate="required:必填项" >
            <option value="">请选择</option>
            <option value="小学">小学</option>
            <option value="初中">初中</option>
            <option value="高中">高中</option>
            <option value="中专">中专</option>
            <option value="本科">本科</option>
            <option value="研究生">研究生</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <!-- 
      <div class="form-group">
        <div class="label">
          <label>年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nl"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
       -->
       <input type="hidden" class="input w50" name="nl"  value="0" />
       
      <div class="form-group">
        <div class="label">
          <label>出生日期：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" name="csrq"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>人员属性：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="rysx"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>是否农村户口：</label>
        </div>
        <div class="field">
          <select class="input w50" name="sfnchk"  data-validate="required:必填项">
          <option value="">请选择</option>
          <option value="是">是</option>
          <option value="否">否</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>职业：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="zy"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>工作单位：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="gzdw"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>联系电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="lxdh"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>常住地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="czdz"  data-validate="required:必填项"  />
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
          <button class="button bg-main icon-check-square-o" type="submit" id="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
	
</html>