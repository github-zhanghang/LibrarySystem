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
<script src="js/jquery-1.8.3.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 用户信息列表</strong>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left:10px;">
				<li><a class="button border-yellow" href="adduser.jsp"><span
						class="icon-plus-square-o"></span>添加用户</a></li>

				<li><input type="text" placeholder="请输入姓名或学号" name="value"
					id="value" class="input"
					style="width:250px; line-height:17px;display:inline-block" /> <a
					href="javascript:void(0)" class="button border-main icon-search"
					onclick="changesearch()"> 搜索</a>
				</li>
			</ul>

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
						<c:when test="${user.isEnable eq '1'}">
							<td>是</td>
						</c:when>
						<c:otherwise>
							<td>否</td>
						</c:otherwise>
					</c:choose>
					<td><div class="button-group">
							<a type="button" class="button border-main"
								href="../../changeInfoServlet?type=0&value=${user.readerAccount }"><span
								class="icon-edit"></span>修改</a> <a class="button border-red"
								href="#"
								onclick="return del('${user.readerAccount }')"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
				<div class="pagelist">
						<%
							int totalPage = (Integer) request.getSession().getAttribute(
									"totalPage");
							if (Integer.parseInt((String) request.getSession().getAttribute(
									"currentPage")) < totalPage) {
						%>
						<a
							onclick="fenye(<%=Integer.parseInt((String) request.getSession()
						.getAttribute("currentPage")) - 1%>)">上一页</a>
						<%
							} else {
						%>
						<a onclick="fenye(<%=totalPage - 1%>)">上一页</a>
						<%
							}
						%>
						<%
						for (int i = 1; i <= totalPage; i++) 
						{
							if(request.getSession().getAttribute("currentPage").equals(String.valueOf(i))){
							%>
							    <a onclick="fenye(<%=i%>)" class="current"><%=i%></a>
							<% 
							}else{
							%>
								<a onclick="fenye(<%=i%>)"><%=i%></a>			
							<%
							}
						}
						%>		
						
						<% if (Integer.parseInt((String) request.getSession().getAttribute(
									"currentPage")) < totalPage) {
						%>
						<a onclick="fenye(<%=Integer.parseInt((String) request.getSession().getAttribute("currentPage")) + 1%>)">下一页</a>
						<%
							} else {
						%>
						<a onclick="fenye(<%=totalPage%>)">下一页</a>
						<%
							}
						%>				
					
					<a onclick="fenye(<%=request.getSession().getAttribute("totalPage")%>)">尾页</a>
					</div>
				</td>
			</tr>
		</table>
	</div>

	<form action="../../deleteMemberServlet" id="form1">
		<input type="hidden" name="type" value="0"> <input
			type="hidden" id="account" name="account">
	</form>
	<script type="text/javascript">
		function changesearch() {
			var value = document.getElementById("value").value;
			self.location = "/WisdomLibraryDemo/selectReadersServlet?type=3"
					+ "&value=" + value;
		}
		function del(id) {
			if (confirm("您确定要删除吗?")) {
			document.getElementById("account").className="current";
				$('#account').val(id);
				$('#form1').submit();
			}
		}
		function fenye(mpage) { 
		    var type=<%=request.getSession().getAttribute("type")%>;
		   // document.getElementById("caaa").className="current";
			var page = mpage;
			var value =<%=request.getSession().getAttribute("value")%>;
			self.location = "/WisdomLibraryDemo/selectReadersServlet?type="+type
					+ "&page=" + page+ "&value=" + value;
            
		}
	</script>
</body>
</html>