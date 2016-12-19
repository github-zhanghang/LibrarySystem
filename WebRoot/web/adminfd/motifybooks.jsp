<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改图书信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">         
      <div class="form-group">
        <div class="label">
          <label for="sitename">书名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="bookname" size="50" placeholder="请输入图书名字" data-validate="required:请输入图书名字" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">作者：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="author" size="50" placeholder="请输入作者" data-validate="required:请输入作者" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">出版社：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="rpress" size="50" placeholder="请输入出版社" data-validate="required:请输入出版社" />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">存放位置：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="rpress" size="50" placeholder="请输入位置" data-validate="required:请输入位置" />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">类别：</label>
        </div>
        <div class="field">
        <if condition="$iscid eq 1">
					<li><select name="cid" class="input"
						style="width:200px; line-height:17px;"  onchange="changesearch()">
							<option value="">军事</option>
							<option value="">医学</option>
							<option value="">自然科学</option>
							<option value="">计算机</option>
					</select></li>
					</if>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">上传图片：</label>
        </div>
        <div class="field">
					<input style="display: block;" type="file"
						name="uploadfile1" id="uploadfile1">							
				 
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">预览效果：</label>
        </div>
        <div class="field">
				<img alt="图片预览" src=""
						width="80px" height="100px" id="img1">									 
        </div>
      </div>
      <!-- 以下开始预览图片操作 -->
				<script>
					$("#uploadfile1").change(function() {
						var objUrl = getObjectURL(this.files[0]);
						if (objUrl) {
							$("#img1").attr("src", objUrl);
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
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>