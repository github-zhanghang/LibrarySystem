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
<title>分类列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">

		<div class="padding border-bottom">
			<a class="button border-yellow" href="addclassify.jsp"><span
				class="icon-plus-square-o"></span> 添加类别</a>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="5%">ID</th>
				<th width="15%">图书类别</th>
				<th width="15%">注册时间</th>
				<th width="10%">操作</th>
			</tr>
			<c:forEach items="${sessionScope.types}" var="type">
				<tr>
					<td>${type.typeId}</td>
					<td>${type.typeName}</td>
					<td>${type.createTime}</td>

					<td><div class="button-group">
							<a type="button" class="button border-main"
								href="../../changeInfoServlet?type=3&value=${type.typeName }"><span
								class="icon-edit"></span>修改</a> <a class="button border-red"
								href="javascript:void(0)"
								onclick="return del('${type.typeName}')"><span
								class="icon-trash-o"></span> 删除</a>
						</div></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="../../deleteTypeServlet" id="form1">

		<input type="hidden" id="typeName" name="typeName">
	</form>
	<script type="text/javascript">
		function del(typeName){
			if(confirm("您确定要删除吗?")){
				$('#typeName').val(typeName);
				$('#form1').submit();
			}
}
</script>

</body>
</html>