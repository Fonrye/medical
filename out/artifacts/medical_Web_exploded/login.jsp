<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
    <!-- 声明js代码域 -->
    <script type="text/javascript">
       //判断登录页面是不是顶层页面，如果不是则将其设置为顶层页面（解决框架中出现了登录页面）
       if(window != top){
         top.location.href=location.href;
       }
    </script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="userlogin?method=userLogin" method="post">
            <!-- 声明请求处理方法 
            <input type="hidden" name="method" value="userLogin" />-->
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>新农合慢性病报销系统</h1></div>
                 <!-- 声明jstl进行判断 -->
                 <c:choose>
                   <c:when test="${sessionScope.flag=='loginFalse1' }">
                      <div style="text-align: center;color:red;">账号或密码错误</div>
                   </c:when>
                   <c:when test="${sessionScope.flag=='loginFalse2' }">
                       <div style="text-align: center;color:red;">账号或密码不能空</div>
                   </c:when>
                 </c:choose>
                 <%session.invalidate(); %>
                 <%--<c:remove var="flag" scope="session"/> --%>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="userNumber" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="userPwd" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    
                </div>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            </form>          
        </div>
    </div>
</div>
</body>
</html>