<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/xgxt_login.css" />
<title>用户登录</title>
</head>
<body>

	<div id="header">
		<div class="header_title">
			<span class="title_con">图书馆信息服务系统</span>
		</div>
	</div>

	<div id="content">
		<center>
			<div class="con">
				<div class="con_title">
					<span class="con_title_sp">登录</span>
				</div>
				<div class="con_panel">
					<div class="con_input">
						<span>用户名：</span><input type="text" placeholder="学号" />
					</div>
					<div class="con_input">
						<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="text"
							placeholder="密码" />
					</div>
					<div class="con_select">
						<input type="radio" name="t1" value="学生" />学生 <input type="radio"
							name="t1" value="管理员" />管理员
					</div>
					<form action="index.jsp" method="post">
						<input type="submit" value="登    录" class="submit-btn" />
					</form>
				</div>
			</div>
		</center>
	</div>
</body>
</html>
