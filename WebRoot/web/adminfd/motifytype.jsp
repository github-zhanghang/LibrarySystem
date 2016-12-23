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
<script src="js/jquery-1.8.3.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改类别</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/updateTypeServlet">
      <div class="form-group">
        <div class="label">
          <label for="sitename">原类别：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
              <input  style="border:none; background-color:white;"  type="text" name="oldName" value="${type.typeName}" readonly="true"/>       
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新类别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="username" name="newName" size="50" placeholder="请输入新类别" data-validate="required:请输入新类别" />       
        </div>
      </div>           
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