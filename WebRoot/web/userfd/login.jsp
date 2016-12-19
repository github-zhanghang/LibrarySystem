<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
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
				<form action="<%=request.getContextPath()%>/loginServlet?" method="post">
					<div class="con_panel">
						<div class="con_input">
							<span>用户名：</span><input type="text" name="account"
								placeholder="学号" data-validate="required:请输入学号账号" maxlength="10"/>
						</div>
						<div class="con_input">
							<span>密&nbsp;&nbsp;&nbsp;码：</span><input type="password"
								name="password" placeholder="密码" data-validate="required:请输入密码账号"/>
						</div>
						<div class="con_input_code">
							<span>验证码：</span><input type="text" name="code" placeholder="验证码" data-validate="required:请输入验证码"/><img
								src="check.jsp" />
						</div>
						<div class="con_select">
							<input type="radio" name="type" value="0" checked/>学生 <input
								type="radio" name="type" value="1" />管理员
						</div>
						<input type="submit" value="登    录" class="submit-btn" />
					</div>
				</form>
			</div>
		</center>
	</div>
</body>
</html>
