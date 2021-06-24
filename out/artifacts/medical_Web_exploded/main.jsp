<%@ page language="java" import="java.util.*,com.gxuwz.medical.sfy.domain.*"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

<!--声明js代码域  -->
<script type="text/javascript">
	$(function() {
		//给退出登录添加单击事件
		$("#out").click(function() {
			return window.confirm("你真的要退出吗?");
		})
	})
</script>

</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/logo.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />新农合慢性病报销系统
			</h1>
		</div>

		<div class="head-l" style="position: relative; left: 980px;">
			<span style="font-size: 15px; color: white;">当前用户:${sessionScope.user.userName}</span>&nbsp;&nbsp;<a
				id="out" class="button button-little bg-red"
				href="userlogin?method=userOut"><span class="icon-power-off"></span>
				退出登录</a>
		</div>
	</div>

 <div class="leftnav">
   <div class="leftnav-title">
			<strong><span class="icon-list"></span>慢性病报销系统</strong>
		</div>
		<div >
                  
 					<c:forEach items="${loginmenulist }" var="lm">
						<c:if test="${lm.menMenuId==1 }">
						
							<li>
								<h2>
									<a href="javascript:void(0)" target="right" class="icon-pencil-square-o">
										<span class="icon-user"> ${lm.menuName }</span>
									</a>
								</h2>                          
								<ul class="" style="display: block">
									<c:forEach items="${loginmenulist }" var="lm2">
										<c:if test="${lm.menuId==lm2.menMenuId }">
											<li>
												<a href="<%=basePath %>${lm2.menuUrl }" target="right"> 
												<i class="icon-caret-right"></i> 
														<span>${lm2.menuName }</span>
												</a>
											</li>
										</c:if>
									</c:forEach>
								</ul>
						   </li>
						</c:if>
					</c:forEach>
				
				</div>
 </div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前语言：</b><span style="color: red;">中文</php></span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a
			href="##">英文</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="info.jsp" name="right"
			width="100%" height="100%"></iframe>
	</div>
	<div style="text-align: center;">
		<p>
			来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
		</p>
	</div>
</body>
</html>