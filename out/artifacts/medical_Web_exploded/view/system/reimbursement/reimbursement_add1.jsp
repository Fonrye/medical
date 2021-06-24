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

<title>创建行政区域</title>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jq.js"></script>
<script src="js/admin.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn").click(function() {
		var name = $("#name").val();
		var illcardNo = $("#illcardNo").val();
		var sfzh = $("#sfzh").val();
		var nhzh = $("#nhzh").val();
		var illName = $("#illName").val();
		var illMoney = $("#illMoney").val();
		var yyfph = $("#yyfph").val();
		var jzsj = $("#jzsj").val();
		var allMoney = $("#allMoney").val();
		var money = $("#money").val();
		var bxsj = $("#bxsj").val();
		var year = $("#year").val();
		
		if (0.0 == money) {
		    alert("本年度的报销额度已经报完！！！");
		} else {
			window.location.href = "system/reimbursement?method=addReim&&name="+name+"&&illcardNo="+illcardNo+"&&sfzh="+sfzh+"&&nhzh="+nhzh+"&&illName="+illName+"&&illMoney="+illMoney+"&&yyfph="+yyfph+"&&jzsj="+jzsj+"&&allMoney="+allMoney+"&&money="+money+"&&bxsj="+bxsj+"&&year="+year;
		}

	});
})
</script>
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">确认报销信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action=""> 

      <div class="form-group">
        <div class="label">
          <label>报销人姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="name" name="name" value="${name }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>慢病证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="illcardNo" name="illcardNo" value="${illcardNo }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>身份号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="sfzh" name="sfzh" value="${sfzh }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>农合证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="nhzh" name="nhzh" value="${nhzh }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>疾病名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="illName" name="illName" value="${illName }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>医疗费用：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="illMoney" name="illMoney" value="${illMoney }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>已报销金额：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="allMoney" name="allMoney" value="${allMoney }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>本次报销金额：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="money" name="money" value="${money }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>医院发票号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="yyfph" name="yyfph" value="${yyfph }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>就诊时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="jzsj" name="jzsj" value="${jzsj }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>报销时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="bxsj" name="bxsj" value="${bxsj }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>报销年份：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="year" name="year" value="${year }" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
      
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" id="btn"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
	
</html>