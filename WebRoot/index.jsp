<%@page import="com.library.dao.BookDetailDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP Test</title>
</head>
<body>
	<%
		Object message = request.getAttribute("loginResult");
		//if (message != null && !"".equals(message)) {
	%>
	<script type="text/javascript">
         alert("data:<%=request.getAttribute("loginResult")%>");
	</script>
	<%
		//}
	%>

	<form action="<%=request.getContextPath()%>/loginServlet" method="get">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="account" placeholder="请输入用户名" />
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="password" placeholder="请输入密码" />
				</td>
			</tr>
		</table>
		<p>
			学生<input style="margin-right:50px" type="radio" name="type"
				checked="checked" value="0" /> 管理员<input type="radio" name="type"
				value="1" />
		</p>
		<p>
			<input type="submit" value="登录" name="submit_login" />
		</p>
	</form>
</body>
</html>