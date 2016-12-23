<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
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
			<strong><span class="icon-key"></span> 修改图书信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="<%=request.getContextPath()%>/updateBookServlet?oldName=${book.bookName}" enctype="multipart/form-data">
				<div class="form-group">
					<div class="label">
						<label for="sitename">书名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="newName" size="50"
							placeholder="请输入图书名字" data-validate="required:请输入图书名字" value="${book.bookName}"/>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">作者：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="newAuthor" size="50"
							placeholder="请输入作者" data-validate="required:请输入作者" value="${book.bookAuthor}"/>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">出版社：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="newPress"
							placeholder="请输入出版社" data-validate="required:请输入出版社" value="${book.bookPress}"/>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">存放位置：</label>
					</div>
					<div class="field">
						<select name="newAddress" class="input"
							style="width:200px; line-height:17px;" onchange="changesearch()">
							<option value="A-01-001">A-01-001</option>
							<option value="A-01-002">A-01-002</option>
							<option value="A-01-003">A-01-003</option>
							<option value="A-02-001">A-02-001</option>
							<option value="A-02-002">A-02-002</option>
							<option value="A-02-003">A-02-003</option>
							<option value="A-03-001">A-03-001</option>
							<option value="A-03-002">A-03-002</option>
							<option value="A-03-003">A-03-003</option>
							<option value="B-01-001">B-01-001</option>
							<option value="B-01-002">B-01-002</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">数量：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="newCount"
							placeholder="请输入数量" data-validate="required:请输入数量" value="${book.stockCount}"/>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">类别：</label>
					</div>
					<div class="field">
						<select name="newType" class="input"
							style="width:200px; line-height:17px;" onchange="changesearch()" >
							<option value="军事">军事</option>
							<option value="医学">医学</option>
							<option value="自然科学">自然科学</option>
							<option value="计算机">计算机</option>
							<option value="物理学">物理学</option>
							<option value="化学">化学</option>
							<option value="生物学">生物学</option>
							<option value="美术">美术</option>
						</select>

					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">上传图片：</label>
					</div>
					<input type="file" name="imageFile" id="imageFile"
						onchange="javascript:setImagePreview();" /> 
					<div id="localImage">
						  <img style="margin-left:0px;margin-top:10px;background: #f0f;" id="preview"
							width=80px height=100px src="${book.imageUrl}"/> 
					</div>
				</div>
				<!-- 以下开始预览图片操作 -->
				<script>
					function setImagePreview() {
						var docObj = document.getElementById("imageFile");
						var imgObjPreview = document.getElementById("preview");
						if (docObj.files && docObj.files[0]) {
							//火狐下，直接设img属性
							imgObjPreview.style.display = 'block';
							imgObjPreview.style.width = '80px';
							imgObjPreview.style.height = '100px';

							//imgObjPreview.src = docObj.files[0].getAsDataURL();  
							//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式   
							imgObjPreview.src = window.URL
									.createObjectURL(docObj.files[0]);
						} else {
							//IE下，使用滤镜    
							docObj.select();
							var imgSrc = document.selection.createRange().text;
							var localImagId = document
									.getElementById("localImage");
							//必须设置初始大小  
							localImagId.style.width = "80px";
							localImagId.style.height = "100px";
							//图片异常的捕捉，防止用户修改后缀来伪造图片
							try {
								localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
								localImagId.filters
										.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
							} catch (e) {
								alert("您上传的图片格式不正确，请重新选择!");
								return false;
							}
							imgObjPreview.style.display = 'none';
							document.selection.empty();
						}
						return true;
					}
				</script>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>