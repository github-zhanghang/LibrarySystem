<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新书推荐</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<link href="css/cssss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/resetac.css" />
<link rel="stylesheet" type="text/css" href="css/activity.css" />
<link rel="stylesheet" type="text/css" href="css/thems.css">
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
						style="position: absolute; float: right; z-index: 2; left: 940px; top: 2px; width: 50px; height: 30px;">
						<p data-toggle="modal" data-target=".bs-example-modal-sm">登录</p>
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

						<li class="one"><a href="newbook.jsp">新书推荐</a></li>
						<li class="one"><a href="borrowinfo.jsp"
							style="background-image: none;">借还信息</a>
							<ul>
								<li><a href="borrowinfo.jsp">借阅信息</a></li>
								<li><a href="collectioninfo.jsp">收藏</a></li>
								<li><a href="overtimeinfo.jsp">超期公告</a></li>
								<li><a href="#">预约</a></li>
								<li><a href="#">续借</a></li>
							</ul>
						</li>
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
					<li id="bottom_none"><a href="#" onClick="DoMenu('ChildMenu5')">借还信息</a>
						<ul id="ChildMenu5" class="collapsed">
							<li id="border_top"><a href="borrowinfo.jsp">借阅信息</a>
							</li>
							<li id="border_top"><a href="collectioninfo.jsp">收藏</a>
							</li>
							<li id="border_top"><a href="overtimeinfo.jsp">超期公告</a>
							</li>
							<li id="border_top"><a href="#">预约</a>
							</li>
							<li id="border_top"><a href="#">续借</a>
							</li>

						</ul></li>
				</ul>
				<div class="clear"></div>
			</div>
			<div class="right_2">
				<div class="right_nr">
					<div class="right_title">
						<span style="float:left;"><strong>活动详情</strong>Activity</span>
						<div class="clear"></div>
					</div>



					<div class="pro_m">

						<div class="pro_md">
							<h1>台佳电子“精益化生产管理”参观交流</h1>
							<div class="time">
								<span>来源：admin</span> <span>发布时间：2014-07-09</span> <span>浏览次数：888次</span>
							</div>
							<div class="ctn">
								<p>为了深入开展推行“精益化生产管理”活动，将现场管理与提高生产效率、降低生产成本相结合，进一步提升企业竞争力为了深入开展推行“精益化生产管理”活动，将现场管理与提高生产效率、降低生产成本相结合，进一步提升企业竞争力为了深入开展推行“精益化生产管理”活动，将现场管理与提高生产效率、降低生产成本相结合，进一步提升企业竞争力为了深入开展推行“精益化生产管理”活动，将现场管理与提高生产效率、降低生产成本相结合，进一步提升企业竞争力</p>
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
</body>
</html>
