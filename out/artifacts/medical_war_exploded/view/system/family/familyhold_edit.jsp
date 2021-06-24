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
  <div class="panel-head" ><strong class="icon-reorder">修改家庭参合人员信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/familyhold?method=updateFamilyhode"> 
    
    <div class="form-group">
        <div class="label">
          <label>家庭编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="jtbh" value="${Familyhold.jtbh }" readonly="readonly"/>
          <input type="hidden" class="input w50" name="id" value="${Familyhold.id }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
    
    <div class="form-group">
        <div class="label">
          <label>农合证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nhzh" value="${Familyhold.nhzh }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
    
      <div class="form-group">
        <div class="label">
          <label>医疗证卡号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="ylzkh" value="${Familyhold.ylzkh }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>户内编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="hnbh" value="${Familyhold.hnbh }" readonly="readonly" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>姓名</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="xm" value="${Familyhold.xm }"  data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>与户主关系：</label>
        </div>
        <div class="field">
          <select class="input w50" name="yhzgx"  data-validate="required:必填项" >
            <option value="户主" ${Familyhold.yhzgx=='户主'?'selected':'' }>户主</option>
            <option value="夫妻" ${Familyhold.yhzgx=='夫妻'?'selected':'' }>夫妻</option>
            <option value="儿女" ${Familyhold.yhzgx=='儿女'?'selected':'' }>儿女</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>身份证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sfzh" value="${Familyhold.sfzh }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <select class="input w50" name="xb"  data-validate="required:必填项" >
            <option value="男" ${Familyhold.xb=='男'?'selected':'' }>男</option>
            <option value="女" ${Familyhold.xb=='女'?'selected':'' }>女</option>
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
            <option value="健康" ${Familyhold.jkzk=='健康'?'selected':'' }>健康</option>
            <option value="患病" ${Familyhold.jkzk=='患病'?'selected':'' }>患病</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>民族：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="mz" value="${Familyhold.mz }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>文化程度：</label>
        </div>
        <div class="field">
          <select class="input w50" name="whcd"  data-validate="required:必填项" >
            <option value="小学" ${Familyhold.whcd=='小学'?'selected':'' }>小学</option>
            <option value="初中" ${Familyhold.whcd=='初中'?'selected':'' }>初中</option>
            <option value="高中" ${Familyhold.whcd=='高中'?'selected':'' }>高中</option>
            <option value="中专" ${Familyhold.whcd=='中专'?'selected':'' }>中专</option>
            <option value="本科" ${Familyhold.whcd=='本科'?'selected':'' }>本科</option>
            <option value="研究生" ${Familyhold.whcd=='研究生'?'selected':'' }>研究生</option>
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
          <input type="text" class="input w50" name="nl" value="${Familyhold.nl }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
       -->
       
      <div class="form-group">
        <div class="label">
          <label>出生日期：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" name="csrq" value="${Familyhold.csrq }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>人员属性：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="rysx" value="${Familyhold.rysx }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>是否农村户口：</label>
        </div>
        <div class="field">
          <select class="input w50" name="sfnchk"  data-validate="required:必填项">
          <option value="是" ${Familyhold.sfnchk=='是'?'selected':'' }>是</option>
          <option value="否" ${Familyhold.sfnchk=='否'?'selected':'' }>否</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>职业：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="zy" value="${Familyhold.zy }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>工作单位：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="gzdw" value="${Familyhold.gzdw }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>联系电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="lxdh" value="${Familyhold.lxdh }" data-validate="required:必填项"  />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>常住地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="czdz" value="${Familyhold.czdz }" data-validate="required:必填项"  />
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