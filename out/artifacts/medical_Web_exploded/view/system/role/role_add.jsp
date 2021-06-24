<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<title>创建角色</title>


<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="js/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" href="js/zTree_v3/css/demo.css">
<script src="js/jq.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/zTree_v3/js/jquery.ztree.all.js"></script>
<script src="js/admin.js"></script>
</head>

<script type="text/javascript">
   $(function(){
	   $("#submit").click(function(){
		   var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
           var nodes = treeObj.getCheckedNodes(true);
           var form = $("#form");
           for (var i = 0; i < nodes.length; i++){
        	   form.append("<input type='hidden' name='menuId' value='"+nodes[i].id+"' >");
		   }	   		   
	   })
   });
</script>
<body>
	<div class="panel admin-panel ">
		<div class="panel-head">
			<strong class="icon-reorder">新建角色</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="system/role?method=addRole " id="form">

                  <!--  
				<div class="form-group">
				   
					<div class="label">
						<label>角色编号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="roleId" id="roleId"
							data-validate="required:请输入编号" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span id="sproleId"
							style="line-height: 35px; font-size: 15px; color: red; display: none;">编号已存在！</span>
						<div class="tips"></div>
					</div>
				</div>
                   -->

				<div class="form-group">
					<div class="label">
						<label>角色名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="roleName" id="roleName"
							data-validate="required:请输入角色名" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>请选择权限:</label>
					</div>
					<div class="field">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" id="submit"
							type="submit">提交</button>
					</div>
				</div>

			</form>
		</div>
	</div>

</body>
<script type="text/javascript">
var setting = {

        key: {
            url:"#",//节点url
            name:"name"//节点名
        },
        data:{	
            simpleData:{
                enable: true,//true / false 分别表示 使用 / 不使用 简单数据模式
                idKey:"id",//节点id
                pIdKey:"MenuPid",//父节点id
                rootPId:0
            }
        },
        //有没有无所谓，这是展示树一些功能
        view:{
        	//设置 zTree 是否显示节点的图标。
            showIcon: false,
//            fontCss:{color:"#FFFFFF", background:"gray"}
        },
        //选择节点
        check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: { "Y": "p", "N": "s" }
		}
};

$(document).ready(function(){
	//页面加载完成后执行以下方法
    initZTree();
});

//初始化树
function initZTree(){
    $.ajax({
          url:"MenuTreeServlet",
          type:"post",
          success: function(data){
        	  //将获得的json格式的数据转为js格式
              eval("var zNode ="+data);
              //树的初始化（固定格式）
              var zTreeObj = $.fn.zTree.init($("#treeDemo"),setting, zNode); 
              //让第一个父节点展开
//              var rootNode_0 = zTreeObj.getNodeByParam('pid',0,null);
//              zTreeObj.expandNode(rootNode_0, true, false, false, false);
          },
          error: function(){
              
          }
      });
}

</script>

</html>