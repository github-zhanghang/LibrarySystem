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
	<form action="<%=request.getContextPath()%>/testServlet" method="get">
		<input type="text" name="text" placeholder="参数" />
		<p>
			<input type="submit" value="登录" name="submit_login" />
		</p>
	</form>
</body>
</html>