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
			<strong class="icon-reorder"> 借阅信息列表</strong>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left:10px;">
				<li>查询：</li>

				<li><select name="type" class="input"
					style="width:200px; line-height:17px;">
						<option onclick="changesearch(this.value)" value="0">请选择</option>
						<option onclick="changesearch(this.value)" value="2">超期</option>
						<option onclick="changesearch(this.value)" value="3">未归还</option>
				</select>
				</li>

				<li><input type="text" placeholder="请输入书名或学号" id="value"
					name="value" class="input"
					style="width:250px; line-height:17px;display:inline-block" /> <a
					href="javascript:void(0)" class="button border-main icon-search"
					onclick="changesearchreader('4')"> 搜索</a>
				</li>
			</ul>

		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="5%">ID</th>
				<th>姓名</th>
				<th>学号</th>
				<th>联系方式</th>
				<th>书籍名称</th>
				<th>借书时间</th>
				<th>还书时间</th>
				<th>是否超期</th>
				<th width="250">操作</th>
			</tr>
			<c:forEach items="${sessionScope.borrows}" var="borrow">
				<tr>
					<td>${borrow.borrowId}</td>
					<td>${borrow.readerInfo.readerName}</td>
					<td>${borrow.readerInfo.readerAccount}</td>
					<td>${borrow.readerInfo.readerPhone}</td>
					<td>${borrow.bookName}</td>
					<td>${borrow.borrowTime}</td>
					<c:choose>
						<c:when test="${borrow.isReturned eq '0'} ">
							<td>${borrow.returnTime}</td>
						</c:when>
						<c:otherwise>
							<td>未归还</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${borrow.isOverDue eq '0'} ">
							<td><font color="#00CC99">是</font></td>
						</c:when>
						<c:otherwise>
							<td>否</td>
						</c:otherwise>
					</c:choose>
					<td><div class="button-group">
							<a class="button border-red" href="javascript:void(0)"
								onclick="return del('${borrow.readerInfo.readerAccount}','${borrow.bookName}')"><span
								class="icon-trash-o"></span> 归还</a>
						</div></td>
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
	<form action="../../borrowAndReturnServlet" id="form1">
		<input type="hidden" name="type" value="1"> <input
			type="hidden" id="account" name="account"> <input
			type="hidden" id="bookName" name="bookName">
	</form>
	<script>
	//搜索分类
	function changesearch(mtype) {
			var type = mtype;
			self.location = "/WisdomLibraryDemo/selectBorrowsServlet?type="
					+ type;
		}
		function changesearchreader(mtype) {
			var type = mtype;
			var value=document.getElementById("value").value;
			self.location = "/WisdomLibraryDemo/selectBorrowsServlet?type="
					+ type+"&value="+value;
		}
		function del(account,bookName) {
			if (confirm("您确定要归还吗?")) {
                $('#account').val(account);
                $('#bookName').val(bookName);
				$('#form1').submit();
			}
		}
		function fenye(mpage) { 
		    var type=<%=request.getSession().getAttribute("type")%>;
			var page = mpage;
			var value =<%=request.getSession().getAttribute("value")%>;
			self.location = "/WisdomLibraryDemo/selectBorrowsServlet?type="+type
					+ "&page=" + page+ "&value=" + value;
            
		}
	</script>
</body>
</html>