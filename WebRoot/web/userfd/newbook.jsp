<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书列表</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<link href="css/cssss.css" rel="stylesheet" type="text/css" />
</head>
<script src="js/muen.js" type="text/javascript"></script>
<script src="js/nav.js" type="text/javascript"></script>
<body>
	<div class="juzhong">
		<div class="top">
			<div class="top_top">
				<span style="float:left; margin-left:14px;">欢迎访问高校智慧图书馆信息服务网！
					咨询热线: 12345678901</span><span style="float:right; margin-right:6px;">今天是:
					2016.12.22. 星期三</span>
				<div class="clear"></div>
			</div>
			<div class="logo_bg">
				<img src="images/bg1.jpg" width="499" height="100"
					style="float:left;">
				<div class="imgw">

					<img src="images/k.jpg" width="502" height="100"
						style=" float:right;">
					<div class="login"
						style="position: absolute; float: right; z-index: 2; left: 950px; top: 0px; width: 50px; height: 40px;">
						<p>
							<a style="color:#fff; text-decoration:none" href="login.jsp">登录</a>
						</p>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="muen">
				<div class="subnav">
					<ul id="nuw">
						<li class="one"><a href="index.jsp">&nbsp;&nbsp;&nbsp;首页</a>
						</li>
						<li class="one"><a href="briefinfo.jsp">关于我们</a>
							<ul>
								<li><a href="briefinfo.jsp">本馆简介</a></li>
								<li><a href="distribute.jsp">馆藏分布</a></li>
								<li><a href="opentime.jsp">开放时间</a></li>
								<li><a href="contact.jsp">联系我们</a></li>

							</ul>
						</li>
						<li class="one"><a href="activityinfo.jsp">活动报道</a>
							<ul>
								<li><a href="news.jsp">新闻动态</a></li>
								<li><a href="activityinfo.jsp">活动通知</a></li>
							</ul>
						</li>
						<li class="one"><a href="#">读者服务</a>
							<ul>
								<li><a href="rank.jsp">借阅排行榜</a></li>
								<li><a href="#">借阅须知</a></li>
							</ul>
						</li>

						<li class="one"><a href="newbook.jsp">新书推荐</a>
						</li>
						<li class="one"><a href="borrowinfo.jsp"
							style="background-image: none;">借还信息</a>
							<ul>
								<li><a href="borrowinfo.jsp">借阅信息</a>
								</li>
								<li><a href="collectioninfo.jsp">收藏</a>
								</li>
								<li><a href="overtimeinfo.jsp">超期公告</a>
								</li>
							</ul></li>
					</ul>
				</div>
				<div class="sousuo">
					<input name="" type="text" class="input" value="搜索"> <input
						name="Submit" type="image" id="Submit" value="提交"
						src="images/fangda.gif" style="float:left; margin:0 8px;">
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div class="main_2">
			<div class="left_2">
				<ul class="nav">
					<li id="bottom_none"><a href="#"
						onclick="DoMenu('ChildMenu1')">关于我们</a>
						<ul id="ChildMenu1" class="collapsed">
							<li id="border_top"><a href="briefinfo.jsp">本馆简介</a>
							</li>
							<li><a href="distribute.jsp">馆藏分布</a>
							</li>
							<li><a href="opentime.jsp">开放时间</a>
							<li><a href="contact.jsp">联系我们</a></li>
						</ul></li>
					<li id="bottom_none"><a href="#"
						onClick="DoMenu('ChildMenu2')">活动报道</a>
						<ul id="ChildMenu2" class="collapsed">
							<li id="border_top"><a href="news.jsp">新闻动态</a>
							</li>
							<li><a href="activityinfo.jsp">活动通知</a>
						</ul></li>
					<li id="bottom_none"><a href="#"
						onClick="DoMenu('ChildMenu3')">读者服务</a>
						<ul id="ChildMenu3" class="collapsed">
							<li id="border_top"><a href="rank.jsp">借阅排行榜</a>
							</li>
							<li><a href="#">借阅须知</a>
							</li>
						</ul></li>
					<li id="bottom_none"><a href="newbook.jsp"
						onClick="DoMenu('ChildMenu4')">新书推荐</a></li>
					<li id="bottom_none"><a href="#"
						onClick="DoMenu('ChildMenu5')">借还信息</a>
						<ul id="ChildMenu5" class="collapsed">
							<li id="border_top"><a href="borrowinfo.jsp">借阅信息</a>
							</li>
							<li id="border_top"><a href="collectioninfo.jsp">收藏</a>
							</li>
							<li id="border_top"><a href="overtimeinfo.jsp">超期公告</a>
							</li>


						</ul></li>
				</ul>
				<div class="clear"></div>
			</div>
			<div class="right_2">
				<div class="right_nr">
					<div class="right_title">
						<span style="float:left;"><strong>图书列表</strong>New Books</span>
						<div class="clear"></div>
					</div>
					<div class="anlie">
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
												<a><font color="#C99149">&nbsp;[已借]</font></a>
											</c:when>
											<c:otherwise>												
												<a href="#" onclick="return jie('${book.bookName}')">&nbsp;[借阅] </a>
											</c:otherwise>
										</c:choose>
                                        <c:choose>
											<c:when test="${book.isCollected eq '1'}">
											<a><font color="#C99149">&nbsp;[已收藏]</font></a>
											</c:when>
											<c:otherwise>
												<a href="#" onclick="collection('${book.bookName}')">&nbsp;[收藏]</a> 
												
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

						<div class="fangye">
							<div class="fanye_left">共 ${sessionScope.totalPage} 条
								当前为：${sessionScope.currentPage}/${sessionScope.totalPage}页 每页 15
								条</div>
							<div class="fanye_right">
								<%
									int totalPage = (Integer) request.getSession().getAttribute(
											"totalPage");
									if (Integer.parseInt((String) request.getSession().getAttribute(
											"currentPage")) < totalPage) {
								%>
								<a
									onclick="fenye(<%=Integer.parseInt((String) request.getSession()
						.getAttribute("currentPage")) - 1%>)">&lt;&lt;</a>
								<a href="#">&lt;</a>

								<%
									} else {
								%>
								<a onclick="fenye(<%=totalPage - 1%>)">&lt;&lt;</a> <a href="#">&lt;</a>

								<%
									}
								%>
								<%
									if (Integer.parseInt((String) request.getSession().getAttribute(
											"currentPage")) < totalPage) {
								%>
								<a href="#">&gt;</a> <a
									onclick="fenye(<%=Integer.parseInt((String) request.getSession()
						.getAttribute("currentPage")) + 1%>)">&gt;&gt;
								</a>

								<%
									} else {
								%>
								<a href="#">&gt;</a> <a onclick="fenye(<%=totalPage%>)">&gt;&gt;
								</a>

								<%
									}
								%>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="bottom">
			<div class="bottom_left">
				<a href="#">联系我们</a> | <a href="#">在线咨询</a> | <a href="#">官方网站</a> |
				<a href="#">隐私声明</a>
			</div>
			<div class="bottom_right">地址：郑州航空工业管理学院 邮政编码：4100000</div>
		</div>
	</div>
	<form action="../../borrowAndReturnServlet?account=131006130" id="form2" >
		<input type="hidden" id="bookNamejie" name="bookNamejie">
			<input type="hidden" name="type" value="0">
	</form>
	<form action="../../addCollectionServlet?account=${applicationScope.account}" id="form3">
		<input type="hidden" id="bookName" name="bookName">
	</form>
	<script type="text/javascript">
	     function fenye(mpage) { 
		    var type=<%=request.getSession().getAttribute("type")%>;
			var page = mpage;
			var typeName =<%=request.getSession().getAttribute("typeName")%>;
			var bookName =<%=request.getSession().getAttribute("bookName")%>;
			var value =<%=request.getSession().getAttribute("value")%>;
			self.location = "/WisdomLibraryDemo/selectBooksServlet_user?type="+type
					+ "&page=" + page+  "&typeName=" + typeName+ "&bookName=" + bookName+"&value="+value;
            
		}
		//单个借阅
		function jie(mbookName) {
			if (confirm("您确定要借阅吗?")) {
			var bookName=mbookName;
			var account=<%=request.getSession().getAttribute("account")%>;
			self.location = "/WisdomLibraryDemo/borrowAndReturnServlet?type=0"+"&account="+account+"&bookName="+bookName;
			}
		}
		//单个收藏
		function collection(mbookName) {
			if (confirm("您确定要收藏吗?")) {
			var bookName=mbookName;
			var account=<%=request.getSession().getAttribute("account")%>;
			self.location = "/WisdomLibraryDemo/addCollectionServlet?account="+account+"&bookName="+bookName;				
			}
		}
		</script>
</body>
</html>
