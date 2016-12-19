<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>智慧图书馆信息服务系统</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link href="css/css.css" rel="stylesheet" type="text/css">

<link href="css/css2.css" rel="stylesheet" type="text/css">
<link href="css/e/templates/150716/style.css" type="text/css"
	rel="stylesheet" />
<script src="js/jquery-1[1].2.1.pack.js" type="text/javascript"></script>
<script src="js/muen.js" type="text/javascript"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/function.js" type="text/javascript"></script>
</head>


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
							<a style="color:#fff; text-decoration:none" ; href="login.jsp">登录</a>
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

		<div class="main">
			<div class="left">
				<div class="banner">
					<div align="center">
						<!-- 焦点图切换开始 更多请访问懒人图库 -->
						<DIV id=nav>
							<UL>
								<LI><IMG src="images/za.jpg" text="图1"
									pic="1">
									<DIV>一个海岛</DIV></LI>
								<LI><IMG src="images/zb.jpg" text="图2" pic="2">
									<DIV>一片麦穗</DIV></LI>
								<LI><IMG src="images/zc.jpg" text="图3" pic="3">
									<DIV>一树绿叶</DIV></LI>
								<LI><IMG src="images/zd.jpg" text="图4" pic="4">
									<DIV>一棵大树</DIV></LI>
								<LI><IMG src="images/zf.jpg" text="图5" pic="5">
									<DIV>一地葵花</DIV></LI>
							</UL>
							<DIV id=BG></DIV>
							<DIV id=mask></DIV>
							<DIV id=back>
								<IMG height=255 src="" width=685>
							</DIV>
						</DIV>
						<p>
							<SCRIPT type=text/javascript>
								var num = 0;
								$("#nav").hide();
								$("li img")
										.load(function() {
											num++;
											if (num == 4) {
												$("#nav").show();
											}
										})
										.click(
												function() {

													//如果已经处于active状态，return
													if (this.className
															.indexOf("active") != -1)
														return;

													//正文文字渐隐
													$("#frontText").fadeOut();
													$("#frontTextBack")
															.fadeOut();
													$("#frontTextSub")
															.fadeOut();

													//active状态的图片恢复原样
													$("li img.active")
															.fadeTo(200, 0.6)
															.removeClass(
																	"active")
															.animate({
																top : 5,
																width : 70,
																left : 1
															}, 300)
															.parent()
															.css(
																	{
																		"color" : "#aaa"
																	}); //

													//获取数据
													var i = $(this).attr("pic");
													var t = $(this)
															.attr("text")
															.split("|");

													//当前
													$(this)
															.animate({
																top : -5,
																width : 70,
																height : 40,
																left : 1
															}, 100)
															.addClass("active")
															.fadeTo(200, 1)
															.parent()
															.css(
																	{
																		"color" : "white"
																	});

													$("#back")
															.children()
															.addClass("gray")
															.end()
															.fadeTo(
																	500,
																	0.1,
																	function() {
																		//var IMG = new Image();
																		//IMG.s
																		$(this)
																				.children(
																						"img")
																				.attr(
																						"src",
																						"images/"
																								+ i
																								+ ".jpg")
																				.removeClass(
																						"gray"); //更改图片
																		$(this)
																				.fadeTo(
																						500,
																						1,
																						function() {
																							$(
																									"#frontText")
																									.html(
																											t[0])
																									.fadeIn(
																											200); //更改正文文字
																							$(
																									"#frontTextBack")
																									.html(
																											t[0])
																									.fadeIn(
																											200); //阴影文字
																							$(
																									"#frontTextSub")
																									.html(
																											t[1])
																									.fadeIn(
																											200)
																						} //副标题
																				);
																	})
												})

								//初始第一张图片

								var i = 0;

								show();

								function show() {
									if (i == $("li img").size())
										i = 0
									$("li img").eq(i).click();
									i++;
									//setTimeout(show(),1000);
								}

								document.oncontextmenu = function(e) {
									return false
								}

								if (self.location.search != "") {
									var V = self.location.search;
									V = V.substr(1, V.length);
									eval(V);
									var json = "{";
									if (option.skin == 0)
										$("#mask").hide();
									if (option.animate == 0) {
										$("#nav ul").hide();
									}
									$("#nav").width(
											option.width ? option.width : 685);
									$("#nav")
											.height(
													option.height ? option.height
															: 255);
									$("#back img").width($("#nav").width());
									$("#back img").height($("#nav").height());
									$(
											self.parent.document
													.getElementById("splash"))
											.children().height(
													$("#nav").height()).width(
													$("#nav").width());
								}
							</SCRIPT>
							<!-- 焦点图切换结束-->
					</div>
				</div>
				<div class="zaixian" style="margin-top:269px;">
					<div class="title_top">
						<div class="title">新闻中心</div>
						<a href="#"><img src="images/more2.gif" border="0"> </a>
						<div class="clear"></div>
					</div>
					<div class="zaixian_nr">
						<ul>
							<li><span>1、</span>2016年最新图书规划“出彩河南人”，展现不一样的风采...</li>
							<li><span>2、</span>2016年最新图书规划“出彩河南人”，展现不一样的风采...</li>

							<li><span>3、</span>2016年最新图书规划“出彩河南人”，展现不一样的风采...</li>
							<li><span>4、</span>2016年最新图书规划“出彩河南人”，展现不一样的风采...</li>
							<li style="border:none;"><span>5、</span>2016年最新图书规划“出彩河南人”，展现不一样的风采...</li>
						</ul>
					</div>

				</div>
				<div class="jianjie" style="margin-top:269px;">
					<div class="title_top">
						<div class="title">要闻</div>
						<a href="#"><img src="images/more2.gif" border="0"> </a>
						<div class="clear"></div>
					</div>
					<div class="jianjie_nr">
						<div class="xuxian_bottom" style="padding:16px 0;">
							<img src="images/e.jpg"><span>大家撒返回空数据库减肥了开始的积分楼上的几个了放大看几个地方
								开发大健康韩国开发大。</span>
							<div class="clear"></div>
						</div>
						<div style=" margin-top:6px;">
							圣诞节疯狂收到回复开始打回来发空间是地级市的减肥开始的大煞风景斯蒂芬斯蒂芬干啥的发生突发的涂鸦上与第三方股市地方。</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="right">
				<div class="yewulingyu">
					<span style="float:left;">校园文化</span><a href="#"
						style=" float:right; margin-top:4px;"><img
						src="images/more1.gif" width="28" height="13" border="0"> </a>
				</div>
				<div class="clear"></div>
				<div class="lingyu_nr">
					<ul>
						<li>安全文化月</li>
						<li>pc电脑艺术文化节</li>
						<li>迎新晚会</li>
						<li>元旦晚会</li>
						<li>安全文化月</li>
						<li>pc电脑艺术文化节</li>
						<li>迎新晚会</li>
						<li>元旦晚会</li>
					</ul>
				</div>
				<div class="tu_1">
					<img src="images/f1.jpg" border="0">
				</div>
				<div class="youqing">
					<div class="youqinglianjie">友情链接</div>
					<div class="youqinglianjie_2">
						<select name="pageselect" class="search"
							onchange="self.location.href=options[selectedIndex].value">
							<option value="auction" selected="selected">-------------友情链接------------</option>
							<option value="http://lib.henu.edu.cn">河南大学图书馆</option>
							<option value="http://lib.zzu.edu.cn/">郑州大学图书馆</option>
							<option value="http://www.chnlib.com/">中国图书馆</option>
							<option value="http://tushuguan.zzia.edu.cn/">郑州航空管理学院图书馆</option>
						</select>
					</div>
					<div class=" clear"></div>
				</div>
				<div class="clear"></div>
				<div class="tu_1">
					<img src="images/za.jpg" width="295" height="51" border="0">
				</div>
				<div class="dongtai">
					<div class="dongtai_top_left">网站动态</div>
					<div class="dongtai_top_right">
						<a href="#"><img src="images/more2.gif" border="0"> </a>
					</div>
					<div class="clear"></div>
					<div class="dongtai_nr">
						<a href="#">图书馆十周年庆回顾</a><br> <a href="#">图书馆十周年庆回顾</a><br>
						<a href="#">图书馆十周年庆回顾 </a>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>

		<div class="main_box main_box_style">
			<div class="main_box_inner">
				<div class="xmzs">

					<div class="com">
						<div class="title_top">
							<div class="title">热门图书</div>
							<a href="#"><img src="images/more2.gif" border="0"> </a>
							<div class="clear"></div>
						</div>
						<div class="marquee_pic marquee" id="m_181_0">

							<a class="prev"></a><a class="next"></a>
							<!--控制按钮-->
							<div class="inner">
								<ul>
									<li class="hx"><a href="#" target="_self"><img
											src="images/xi.jpg" border="0"
											style="width:120px;height:150px; target=" _self" title="XX胜景">西游记</a>
									</li>

									<li class="hx"><a href="#" target="_self"><img
											src="images/shui.jpg" border="0"
											style="width:120px;height:150px;target=" _self" title="XX胜景">水浒传</a>
									</li>

									<li class="hx"><a href="#" target="_self"><img
											src="images/hong.jpg" border="0"
											style="width:120px;height:150px; target=" _self" title="XX胜景">红楼梦</a>
									</li>

									<li class="hx"><a href="#" target="_self"><img
											src="images/san.jpg" border="0"
											style="width:120px;height:150px;title="XX胜景">三国演义</a></li>

									<li class="hx"><a href="#" target="_self"><img
											src="images/xi.jpg" border="0"
											style="width:120px;height:150px; target=" _self" title="XX胜景">西游记</a>
									</li>

									<li class="hx"><a href="#" target="_self"><img
											src="images/hong.jpg" border="0"
											style="width:120px;height:150px;target=" _self" title="XX胜景">红楼梦</a>
									</li>

									<li class="hx"><a href="#" target="_self"><img
											src="images/san.jpg" border="0"
											style="width:120px;height:150px; target=" _self" title="XX胜景">三国演义</a>
									</li>

								</ul>
							</div>
						</div>
						<script type="text/javascript">
							marquee("m_181_0", "left", 1500);
						</script>
					</div>
				</div>
			</div>
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
