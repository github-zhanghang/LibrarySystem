<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>图书馆后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#fff;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/zc.jpg" class="radius-circle rotate-hover" height="50" width="50"  alt="" />图书馆后台管理中心</h1>
  </div>
  <div class="head-l">
  <a class="button button-little bg-green" href="../userfd/index.jsp" target="_blank"><span class="icon-home"></span> 用户首页</a>
   &nbsp;&nbsp;<a class="button button-little bg-red" href="../userfd/login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  
  <ul style="display:block">
    <li><a href="addadmin.jsp" target="right"><span class="icon-caret-right"></span>添加管理员</a></li>
    <li><a href="pass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="adduser.jsp" target="right"><span class="icon-caret-right"></span>添加用户信息</a></li>    
    <li><a href="motifyuser.jsp" target="right"><span class="icon-caret-right"></span>修改用户信息</a></li>  
    <li><a href="userlist.jsp" target="right"><span class="icon-caret-right"></span>用户管理</a></li>     
    <li><a href="adminlist.jsp" target="right"><span class="icon-caret-right"></span>管理员管理</a></li>  
    <li><a href="booklist.jsp" target="right"><span class="icon-caret-right"></span>图书管理</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>管理</h2>
  <ul>
    <li><a href="addbooks.jsp" target="right"><span class="icon-caret-right"></span>新书入库</a></li>
    <li><a href="borrowlist.jsp" target="right"><span class="icon-caret-right"></span>借还信息</a></li>
    <li><a href="classify.jsp" target="right"><span class="icon-caret-right"></span>分类管理</a></li>   
    <li><a href="addclassify.jsp" target="right"><span class="icon-caret-right"></span>添加类别</a></li>      
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">图书信息</a></li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="booklist.jsp" name="right" width="100%" height="100%"></iframe>
</div>

</body>
</html>