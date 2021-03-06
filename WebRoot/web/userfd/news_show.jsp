<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新书推荐</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<link href="css/cssss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/lan.css">
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
								<li><a href="#">预约</a>
								</li>
								<li><a href="#">续借</a>
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
						<span style="float:left;"><strong>新闻</strong>News</span>
						<div class="clear"></div>
					</div>
					<div class="case_right_box">
						<dl class="case_show">
							<dt>大学采购信息</dt>
							<dd class="case_show_dd1">
								<span>时间：2016-09-24 </span> <span>来源：新华网</span> <span>浏览量：167</span>
							</dd>
							<dd class="case_show_dd2">&nbsp;&nbsp;
								中山市威可利节能环保设备有限公司成立于2012年6月，是一家专业从事健康节能饮水器、饮水机、校园饮水设备研发、生产、销售与投资于一体化经营的高科技企业，致力于提供健康、节能、安全的公共饮水设备与整体服务解决方案。威可利位于中国著名的小家电产业基地珠三角腹地中山东凤镇，处于物流中心，物流配送便捷、高效，为广大经销商客户提供优质配送业务。
								威可利成立以来，始终贯彻“诚信第一、顾客至上”的经营理念，并囊括了行业内最卓越的具有十年从业经验的技术工程师，拥纳了一批高素质的专业技术人才和资深管理职业人才，企业现有员工达158名。公司在短短的两年时间里一跃成为行业的领航者，签约渠道商（代理、经销、OEM、校园投资项目商）已有600多家，各类饮水机年产能10多万台，发展速度稳居行业第一。公司依仗强劲的综合实力，成熟的项目方案，完善的技术品质，全方位的售后服务在竞争中脱颖而出，战略客户涵盖了医院、学校、工厂、政府机关等，其中学校项目中大学以及高等学院合作伙伴数量众多.
								受广大客户的好评，并先后获得数十项国家发明专利与实用专利技术机行业十大品牌、质量·服务·信誉3A企业、国家工业生产许可权威企业，并获得企业最高信誉级别“3A级信用企业”。
							</dd>
							<dd class="news_show_dd">
								<img src="images/zd.jpg" alt="">
							</dd>
						</dl>
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
