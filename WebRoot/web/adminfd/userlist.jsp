<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>网站信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 用户信息列表</strong>
		</div>
		<div class="padding border-bottom">
			<a class="button border-yellow" href="adduser.jsp"><span
				class="icon-plus-square-o"></span> 添加用户</a>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="5%">ID</th>
				<th>学号</th>
				<th>姓名</th>
				<th>联系方式</th>
				<th>是否可以登录</th>
				<th width="250">操作</th>
			</tr>


			<c:forEach items="${sessionScope.readers}" var="user">
				<tr>
					<td>${user.readerId}</td>
					<td>${user.readerAccount}</td>
					<td>${user.readerName}</td>
					<td>${user.readerPhone}</td>
					<c:choose>
						<c:when test="${user.isEnable eq '1'} ">
							<td>否</td>
						</c:when>
						<c:otherwise>
							<td>是</td>
						</c:otherwise>
					</c:choose>
					<td><div class="button-group">
							<a type="button" class="button border-main" href="motifyuser.jsp"><span
								class="icon-edit"></span>修改</a> <a class="button border-red"
								href="javascript:void(0)" onclick="return del(17)"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
			</c:forEach>

			
			<!-- <tr class="heig"></tr> -->
			<tr>
				<td colspan="8"><div class="pagelist">
						<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
							href="">3</a><a href="">下一页</a><a href="">尾页</a>
					</div></td>
			</tr>
		</table>
	</div>
	<script>
function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>
</body>
</html>