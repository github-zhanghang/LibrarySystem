<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery-1.8.3.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>

	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 图书信息列表</strong> <a href=""
				style="float:right; display:none;">添加字段</a>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left:10px;">
				<li><a class="button border-yellow" href="addbooks.jsp">
						添加图书</a>
				</li>
				<li>搜索：</li>
				<li><select name="typeName" class="input"
					style="width:200px; line-height:17px;">
						<option onclick="changesearch(this.value,'0')" value="">全部分类</option>
						<option onclick="changesearch(this.value,'1')" value="军事">军事</option>
						<option onclick="changesearch(this.value,'1')" value="医学">医学</option>
						<option onclick="changesearch(this.value,'1')" value="小说">小说</option>
						<option onclick="changesearch(this.value,'1')" value="计算机">计算机</option>
						<option onclick="changesearch(this.value,'1')" value="自然科学">自然科学</option>
				</select></li>

				<li><input type="text" placeholder="请输入书名" id="bookNameselect"
					name="bookNameselect" class="input"
					style="width:250px; line-height:17px;display:inline-block" /> <a
					class="button border-main icon-search" onclick="searchname()">
						搜索</a></li>
			</ul>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="100" style="text-align:left; padding-left:20px;">ID</th>
				<th width="10%">书名</th>
				<th>图片</th>
				<th>作者</th>
				<th>位置</th>
				<th>分类名称</th>
				<th>剩余数量</th>
				<th width="10%">注册时间</th>
				<th width="310">操作</th>
			</tr>
			<c:forEach items="${sessionScope.books}" var="book">
				<tr>
					<td style="text-align:left; padding-left:20px;"><input
						type="checkbox" name="id[]" value="${book.bookID}" />${book.bookID}</td>
					<td>${book.bookName}</td>
					<td width="10%"><img src="${book.imageUrl}" alt="" width="50"
						height="65" />
					</td>
					<td>${book.bookAuthor}</td>
					<td><font color="#00CC99">${book.bookAddress}</font>
					</td>
					<td>${book.bookType}</td>
					<td>${book.stockCount-book.borrowedCount}</td>
					<td>${book.createTime}</td>
					<td><div class="button-group">
							<a class="button border-main"
								href="../../changeInfoServlet?type=2&value=${book.bookName}"><span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								href="#" onclick="return del('${book.bookName}')"><span
								class="icon-trash-o"></span> 删除</a>
						</div></td>
				</tr>
			</c:forEach>
			<tr>
				<td style="text-align:left; padding:19px 0;padding-left:20px;"><input
					type="checkbox" id="checkall" /> 全选</td>
				<td colspan="7" style="text-align:left;padding-left:20px;"><a
					href="#" class="button border-red icon-trash-o"
					style="padding:5px 15px;" onclick="DelSelect('${sessionScope.books}')"> 删除</a></td>
			</tr>
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
							for (int i = 1; i <= totalPage; i++) {
								if (request.getSession().getAttribute("currentPage")
										.equals(String.valueOf(i))) {
						%>
						<a onclick="fenye(<%=i%>)" class="current"><%=i%></a>
						<%
							} else {
						%>
						<a onclick="fenye(<%=i%>)"><%=i%></a>
						<%
							}
							}
						%>

						<%
							if (Integer.parseInt((String) request.getSession().getAttribute(
									"currentPage")) < totalPage) {
						%>
						<a
							onclick="fenye(<%=Integer.parseInt((String) request.getSession()
						.getAttribute("currentPage")) + 1%>)">下一页</a>
						<%
							} else {
						%>
						<a onclick="fenye(<%=totalPage%>)">下一页</a>
						<%
							}
						%>

						<a
							onclick="fenye(<%=request.getSession().getAttribute("totalPage")%>)">尾页</a>
					</div>
				</td>
			</tr>
		</table>
	</div>

	

	<script type="text/javascript">
	     function fenye(mpage) { 
		    var type=<%=request.getSession().getAttribute("type")%>;
			var page = mpage;
			var typeName =<%=request.getSession().getAttribute("typeName")%>;
			var bookName =<%=request.getSession().getAttribute("bookName")%>;
			self.location = "/WisdomLibraryDemo/selectBooksServlet?type="+type
					+ "&page=" + page+  "&typeName=" + typeName+ "&bookName=" + bookName;
            
		}
		//搜索分类
		function changesearch(mname, mtype) {
			var type = mtype;
			var typeName = mname;
			self.location = "/WisdomLibraryDemo/selectBooksServlet?type="
					+ type + "&typeName=" + typeName;
		}
		//搜索图书		
		function searchname() {
		    var bookName = document.getElementById("bookNameselect").value;
			self.location = "/WisdomLibraryDemo/selectBooksServlet?type=2" + "&bookName=" + bookName;
		}

		//单个删除
		function del(mbookName) {
			if (confirm("您确定要删除吗?")) {
			var bookName=mbookName;
			self.location = "/WisdomLibraryDemo/deleteBookServlet?type=0" + "&bookName=" + bookName;
			}
		}

		//全选
		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		//批量删除
		function DelSelect(data) {
		     var a=[],bookIds;
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
			     a.push(this.value);
				 Checkbox = true;
				}
			});
			  bookIds=a.join("-");
			 
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
				//$("#listform").submit();
			    self.location = "/WisdomLibraryDemo/deleteBookServlet?type=1" + "&bookIds=" + bookIds;
				
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>