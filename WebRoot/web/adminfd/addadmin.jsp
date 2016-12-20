<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>添加管理员</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span> 添加管理员</strong>
		</div>
		<div class="body-content">
			<form action="<%=request.getContextPath()%>/addMemberServlet?type=1"
				method="post" class="form-x">
				<div class="form-group">
					<div class="label">
						<label for="sitename">管理员帐号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="account" size="50"
							placeholder="请输入账号" data-validate="required:请输入管理员账号"
							maxlength="10" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">姓名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="name" size="50"
							placeholder="请输入姓名" data-validate="required:请输入姓名" maxlength="20" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">联系方式：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="phone" size="50"
							placeholder="请输入手机号" data-validate="required:请输入手机号"
							maxlength="11" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">职责：</label>
					</div>
					<div class="field">

						<select name="duty" class="input"
							style="width:200px; line-height:17px;" onchange="changesearch()">
							<option value="超级管理员">超级管理员</option>
							<option value="读者管理员">读者管理员</option>
							<option value="罚款管理员">罚款管理员</option>
							<option value="盘点管理员">盘点管理员</option>
						</select>

					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50" id="password"
							name="password" size="50" placeholder="请输入密码"
							data-validate="required:请输入密码" maxlength="20" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">确认密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50" name="repassword"
							size="50" placeholder="请再次输入密码"
							data-validate="required:请再次输入密码,repeat#password:两次输入的密码不一致"
							maxlength="20" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>