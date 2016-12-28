<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改书籍信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form
		action="http://localhost:8080/WisdomLibraryDemo/selectBooksServlet_user?type=0&account=131006132"
		method="post">
		<c:forEach items="${sessionScope.books}" var="book">
			<div class="anlie_nr">
				<div class="anlie_nr_left">
					<img src="${book.imageUrl}" width="100" height="126">
				</div>
				<div class="anlie_nr_right">

					<div class="anlie_title">
						<a href="bookdetail.jsp"> <strong style="">${book.bookName}是${book.bookAuthor}所作小说</strong>
						</a>
						<c:choose>
							<c:when test="${book.isBorrowed eq '1'}">
								<a>&nbsp;[已借] </a>
							</c:when>
							<c:otherwise>

								<a href="" onclick="return jie('${book.bookName}')">&nbsp;[借阅]
								</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${book.isCollected eq '1'}">
								<a>&nbsp;[已收藏] </a>
							</c:when>
							<c:otherwise>
								<a onclick="collection('${book.bookName}')">&nbsp;[收藏]</a>

							</c:otherwise>
						</c:choose>

						<a>[借阅次数：${book.borrowTimes}]</a>

					</div>
					<table class="contact_table">
						<tr>
							<td>书名</td>
							<td>${book.bookName}</td>
							<td>作者</td>
							<td>${book.bookAuthor}</td>
						</tr>
						<tr>
							<td>出版社</td>
							<td>${book.bookPress}</td>
							<td>类别</td>
							<td>${book.bookType}</td>
						</tr>
						<tr>
							<td>位置</td>
							<td>${book.bookAddress}</td>
							<td>剩余数量</td>
							<td>${book.stockCount-book.borrowedCount}</td>
						</tr>
					</table>
				</div>
				<div class="clear"></div>
			</div>
		</c:forEach>
		<input type="submit" value="提交" />
	</form>
</body>
</html>
