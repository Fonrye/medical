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
<script type="text/javascript">
  //创建计数器
  var count = -1;
  //声明延时发送编号变量
  var id;
  //声明全局变量
  var lp;
  var la;
  //页面加载完成页面资源初始化
  $(function(){
	//给搜索框添加键盘弹起事件
	$("#xm").keyup(function(event){
		//alert("aaa");
		//声明正则表达是判断空格
		var reg =/^\s+$/g;
		//获取event对象
		var eve = window.event||event;
		//获取用户当前点击的键盘值
		var code = eve.keyCode;
		//判断code的值是否符合要求
		if(code>=65&code<=90||code>=48&code<=57||code>=96&code<=105||code==8||code==32){
			//获取用户当前搜索框中的数据
			var xm = $("#xm").val();
			if(xm==""||reg.test(xm)){
				//隐藏div
				$("#dataDiv").css("display","none");
				return;
			}
			//清除之前要发出的请求
			window.clearTimeout(id);
			//延时发送请求,0.5秒
			id = window.setTimeout(function(){
				$.get("system/illcard",{method:"search",xm:xm},function(data){
					//将获得的值用eval转化成js格式
					
					lp = eval(data);
					//获取div对象
					var dt = $("#dataDiv")
					//清空原有内容
					dt.empty();
					if(lp.length>0){
						//显示隐藏的div
						dt.css("display","");
					}
					//将提示语填充到div中
					for(var i = 0;i<lp.length;i++){
						
						dt.append("<div style='padding:2px'>姓名："+lp[i].xm+"   身份证号："+lp[i].sfzh+"   参合证号："+lp[i].chzh+"   家庭编号:"+lp[i].jtbh+"</div>");
					}
					//给提示语添加鼠标选择效果
					$("#dataDiv div").mouseover(function(){
						//清空所有提示语的div背景颜色
						$("#dataDiv div").css("background-color","");
						//将当前选择的div背景颜色变成灰色
						$(this).css("background-color","gray");
						//将计数器的值变为当前选择的值
						count = $(this).index();
					})
					//给提示语div添加单击事件，用例选择提示语
						$("#dataDiv div").click(function(){
							//将当前选择的div中提示语数据改变到搜索框中
							//$("#search").val($(this).html());选择全部
							$("#xm").val(lp[count].xm);
							$("#nhzh").val(lp[count].chzh);
							$("#sfzh").val(lp[count].sfzh);
							$("#illCardId").val(lp[count].chzh+lp[count].sfzh);
							//隐藏当前填充所有提示语的div
							$("#dataDiv").css("display","none");
						})
				});
			},500);
		}
		//判断用户点击的是否是键盘下键
		if(code==40){
			//判断是否有提示语
			if($("#dataDiv div").length>0){
				//判断计数器的值是否大于div长度
				count = count<$("#dataDiv div").length-1?++count:0;
				//清空所有提示语的div的背景颜色
				$("#dataDiv div").css("background-color","");
				//让选中的提示语div背景变灰色
				$("#dataDiv div:eq("+count+")").css("background-color","gray");
				//将当前选择的div中提示语数据改变到搜索框中
				//$("#search").val($("#dataDiv div:eq("+count+")").html());选择全部
				$("#xm").val(lp[count].xm);
				$("#nhzh").val(lp[count].chzh);
				$("#sfzh").val(lp[count].sfzh);
				$("#illCardId").val(lp[count].chzh+lp[count].sfzh);
			}
		}
		//判断用户点击的是否是键盘上键
		if(code==38){
			//判断是否有提示语
			if($("#dataDiv div").length>0){
				//判断计数器的值是否大于div长度
				count = count>0?--count:$("#dataDiv div").length-1;
				//清空所有提示语的div的背景颜色
				$("#dataDiv div").css("background-color","");
				//让选中的提示语div背景变灰色
				$("#dataDiv div:eq("+count+")").css("background-color","gray");
				//将当前选择的div中提示语数据改变到搜索框中
				$("#xm").val(lp[count].xm);
				$("#nhzh").val(lp[count].chzh);
				$("#sfzh").val(lp[count].sfzh);
				$("#illCardId").val(lp[count].chzh+lp[count].sfzh);
			}
		}
		//当用户键盘点击确定，隐藏div
		if(code==108||code==13){
			$("#dataDiv").css("display","none");
		}
		//当用户删除，则将身份证号清空
		if(code==8){
			$("#nhzh").val(null);
			$("#sfzh").val(null);
			$("#illCardId").val(null);
		}
	});
	if($("#dataDiv").css("display","none")){
		$("#submit").attr("disabled",true);//设置提交按钮为不可提交
	};
	$.get("system/illcard",{method:"findAllChronicdis"},function(data){
		var lc = eval(data);
		var ill = $("#illname");
		for(var i = 0;i<lc.length;i++){
			ill.append("<option value='"+lc[i].illName+"'>"+lc[i].illName+"</option>");
		}
	});
	$("#illname").change(function(){
		if($("#illname").val().length>0){
			$("#submit").attr("disabled",false);//设置提交按钮为可提交
		}else{
			$("#submit").attr("disabled",true);//设置提交按钮为不可提交
		}
	});
  });
 
</script>
</head>
<body>
<div class="panel admin-panel ">
  <div class="panel-head" ><strong class="icon-reorder">创建医疗机构</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="system/illcard?method=SaveIllCard"> 

      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="xm" id="xm"  data-validate="required:请输入姓名" autocomplete="off"/><!-- autocomplete是历史输入记录，on是开启，off是关闭 -->
          <div class="tips"></div>
        </div>
        
        <div class="label">
        </div>
        <div class="field">
          <div id="dataDiv" class="input" style="width: 750px; border:solid 1px;
       		border-color: gray ;display:none; font-size:12px;color:black;" ></div>
          <div class="tips"></div>
        </div>
        
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>农合证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nhzh" id="nhzh" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label>身份证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sfzh" id="sfzh" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label>慢病证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="illCardId" id="illCardId" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div> 
        
          
      <div class="form-group">
        <div class="label">
          <label>疾病名称：</label>
        </div>
        <div class="field">
          <select name="illname" id="illname" data-validate="required:请选择" class="input w50">
              <option value="">---请选择---</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
        
      <div class="form-group">
        <div class="label">
          <label>开始时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" name="startTime"  />
          <div class="tips"></div>
        </div>
      </div>  
      
      <div class="form-group">
        <div class="label">
          <label>结束时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" name="endTime"  />
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