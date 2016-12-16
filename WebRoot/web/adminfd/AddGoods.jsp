<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%--<!-- 新 Bootstrap 核心 CSS 文件 -->--%>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<%--<!-- 可选的Bootstrap主题文件（一般不用引入） -->--%>
<%--<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">--%>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<link rel="stylesheet" type="text/css" href="web/admin/css/Iframe.css" />
<script type="text/javascript" src="web/admin/js/jquery-1.8.3.js"></script>

</head>
<body>
	<span class="cp_title">添加商品</span>
	<div class="add_cp">
		<a href="goodsservlet?type=3">返回商品列表</a>
	</div>
	<div class="table_con">
		<%--		添加商品--%>
		<%--	id  商品名字    原价    打折价   商品图片  总库存  分类   描述 --%>
		<form action="goodsservlet?type=2" method="post"
			enctype="multipart/form-data">
			<%--		请求类型，2代表添加商品--%>
			<!-- 			<input type="hidden" name="type" value="2"> -->
			<%--		商家id，到时候要动态获取--%>
			<input type="hidden" name="businessid" value="1">
			<table style="width: 60%;height:80%;margin: 0 auto;">

				<tr>
					<td width="15%">商 品 名 字</td>
					<td align="center" style="margin: 0 auto;t"><input type="text"
						name="name" class="form-control" id="" placeholder="请输入产品名字">
					</td>
				</tr>
				<tr>
					<td width="15%"><s>原 价</s>
					</td>
					<td><input type="text" name="oldprice" class="form-control"
						id="" placeholder="请输入价格"></td>
				</tr>
				<tr>
					<td width="15%">打 折 价</td>
					<td><input type="text" name="price" class="form-control" id=""
						placeholder="不打折忽略该行即可"></td>
				</tr>
				<tr>
					<td width="15%">库 存 量</td>
					<td><input type="text" name="stock" class="form-control" id=""
						placeholder="请输入库存数量"></td>
				</tr>
				<tr style="height: 100px;">
					<td width="15%">分 类</td>
					<%--					这个地方需要通过三级分类id加载所有三级名称，返回值是 三级id数组，这个不是存到商品表里面，需要存到三级分类表中--%>
					<td><c:forEach items="${classthrees}" var="ct">
							<label class="checkbox-inline"> <input type="checkbox"
								id="inlineCheckbox1" name="threeclassid" value="${ct.id }">${ct.name
								} </label>
						</c:forEach>
					</td>


				</tr>
				<tr>
					<td width="15%">上传图片</td>
					<td style="color: gray;">最多支持四张商品图片</td>

				</tr>
				<tr>
					<td><input style="display: block;" type="file"
						name="uploadfile1" id="uploadfile1">
					</td>
					<td><input style="display: block;" type="file" name="img"
						id="uploadfile2">
					</td>
					<td><input style="display: block;" type="file" name="img"
						id="uploadfile3">
					</td>
					<td><input style="display: block;" type="file" name="img"
						id="uploadfile4">
					</td>
				</tr>
				<tr>
					<td style="color: gray;">预览效果</td>
				</tr>

				<tr style="height: 150px">
					<td><img alt="商品图预览1" src="web/admin/images/load.png"
						width="80px" height="100px" id="img1">
					</td>
					<td><img alt="商品图预览2" src="web/admin/images/load.png"
						width="80px" height="100px" id="img2">
					</td>
					<td><img alt="商品图预览3" src="web/admin/images/load.png"
						width="80px" height="100px" id="img3">
					</td>
					<td><img alt="商品图预览4" src="web/admin/images/load.png"
						width="80px" height="100px" id="img4"></td>
				</tr>
				<!-- 以下开始预览图片操作 -->
				<script>
					$("#uploadfile1").change(function() {
						var objUrl = getObjectURL(this.files[0]);
						if (objUrl) {
							$("#img1").attr("src", objUrl);
						}
					});
					$("#uploadfile2").change(function() {
						var objUrl = getObjectURL(this.files[0]);
						if (objUrl) {
							$("#img2").attr("src", objUrl);
						}
					});
					$("#uploadfile3").change(function() {
						var objUrl = getObjectURL(this.files[0]);
						if (objUrl) {
							$("#img3").attr("src", objUrl);
						}
					});
					$("#uploadfile4").change(function() {
						var objUrl = getObjectURL(this.files[0]);
						if (objUrl) {
							$("#img4").attr("src", objUrl);
						}
					});
					//建立一個可存取到該file的url
					function getObjectURL(file) {
						var url = null;
						if (window.createObjectURL != undefined) { // basic
							url = window.createObjectURL(file);
						} else if (window.URL != undefined) { // mozilla(firefox)
							url = window.URL.createObjectURL(file);
						} else if (window.webkitURL != undefined) { // webkit or chrome
							url = window.webkitURL.createObjectURL(file);
						}
						return url;
					}
				</script>
				<tr style="height: 100px;">
					<td>商品 描述</td>
					<td><textarea placeholder="填下商品描述，最多支持200字哟" rows="3"
							cols="30" name="description"></textarea></td>
				</tr>

				<tr>
					<td width="50%"><button type="reset" class="btn btn-warning"
							style="width: 60%;">重置上述数据</button></td>
					<td width="50%">
						<button style="width: 60%;" type="submit" class="btn btn-primary">提交商品信息</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>