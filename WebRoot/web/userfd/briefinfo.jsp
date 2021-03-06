<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新书推荐</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
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
								<li><a href="briefinfo.jsp">本馆简介</a>
								</li>
								<li><a href="distribute.jsp">馆藏分布</a>
								</li>
								<li><a href="opentime.jsp">开放时间</a>
								</li>
								<li><a href="contact.jsp">联系我们</a>
								</li>

							</ul></li>
						<li class="one"><a href="activityinfo.jsp">活动报道</a>
							<ul>
								<li><a href="news.jsp">新闻动态</a>
								</li>
								<li><a href="activityinfo.jsp">活动通知</a>
								</li>
							</ul></li>
						<li class="one"><a href="#">读者服务</a>
							<ul>
								<li><a href="rank.jsp">借阅排行榜</a>
								</li>
								<li><a href="#">借阅须知</a>
								</li>
							</ul></li>

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
							<li id="border_top"><a href="briefinfo.jsp">本馆简介</a></li>
							<li><a href="distribute.jsp">馆藏分布</a></li>
							<li><a href="opentime.jsp">开放时间</a>
							<li><a href="contact.jsp">联系我们</a>
							</li>
						</ul>
					</li>
					<li id="bottom_none"><a href="#"
						onClick="DoMenu('ChildMenu2')">活动报道</a>
						<ul id="ChildMenu2" class="collapsed">
							<li id="border_top"><a href="news.jsp">新闻动态</a></li>
							<li><a href="activityinfo.jsp">活动通知</a>
						</ul>
					</li>
					<li id="bottom_none"><a href="#"
						onClick="DoMenu('ChildMenu3')">读者服务</a>
						<ul id="ChildMenu3" class="collapsed">
							<li id="border_top"><a href="rank.jsp">借阅排行榜</a></li>
							<li><a href="#">借阅须知</a></li>
						</ul>
					</li>
					<li id="bottom_none"><a href="newbook.jsp"
						onClick="DoMenu('ChildMenu4')">新书推荐</a>
					</li>
					<li id="bottom_none"><a href="#"
						onClick="DoMenu('ChildMenu5')">借还信息</a>
						<ul id="ChildMenu5" class="collapsed">
							<li id="border_top"><a href="borrowinfo.jsp">借阅信息</a></li>
							<li id="border_top"><a href="collectioninfo.jsp">收藏</a></li>
							<li id="border_top"><a href="overtimeinfo.jsp">超期公告</a></li>
							<li id="border_top"><a href="#">预约</a></li>
							<li id="border_top"><a href="#">续借</a></li>

						</ul>
					</li>
				</ul>
				<div class="clear"></div>
			</div>
			<div class="right_2">
				<div class="right_nr">
					<div class="right_title">
						<span style="float:left;"><strong>本馆简介</strong>Library Info</span>
						<div class="clear"></div>
					</div>
					<div class="gyimages">
						<ul>
							<li class="gyimagesA">
								<div>
									<ul>
										<li class="gyimagesAzuo"><img src="images/zc.jpg"
											height="200px" />
										</li>
									</ul>
								</div></li>
							<li class="gyimagesB">&nbsp;&nbsp;&nbsp;&nbsp;郑州航空工业管理学院图书馆，是郑州航院文献信息中心，是为教学和科研服务的学术性机构，是学院信息化的重要基地。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;始建于1950年。1985年开始使用计算机管理，1992年建成图书馆集成管理系统，是河南省较早使用计算机集成管理系统的院校。1997年，南校区图书馆建成投入使用，建筑面积7900平方米。2005年9月，图书馆在东校区提供服务，并建成以南校区图书馆为中心，连通东校区及各系分馆，两校区图书资源共知共享、通借通还的资源建设管理体系。目前我馆藏书已达148
								多万册，逐步形成了充分适应我院教学、科研、专业发展需要，并在经济学学科、管理学学科领域具有鲜明特色的知识资源系统。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;发展：进入20
								世纪九十年代以来，图书馆自动化、网络化也取得了很大发展。在图书馆各项业务工作及管理方面，全面实行计算机管理。在电子资源数字化建设方面，坚持调研、试用、反馈、论证程序，确定数据库的购置，先后购进了17种优秀中外文数据库，并通过校园网为全院师生提供文献信息检索服务。初步形成了一个以信息服务为重心的全方位、多层次、开发式、高效率的文献信息服务体系。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;除精选资源，构建优质服务基础外，我馆积极开拓进取，努力拓展服务层面：开展馆际交流，提高管理水平和服务意识；开展馆际互借、馆际交换、文献传递，提高文献享用范围；建设系分馆管理系统，提高系分馆建设质量（培训、订购、加工），提高全院文献资源管理水平和利用效率。
							</li>
						</ul>
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
