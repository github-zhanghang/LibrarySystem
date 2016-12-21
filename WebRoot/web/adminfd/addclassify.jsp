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
  <div class="panel-head"><strong><span class="icon-key"></span> 添加分类</strong></div>
  <div class="body-content">
     <form  action="<%=request.getContextPath()%>/addTypeServlet?" method="post" class="form-x">
      <div class="form-group">
        <div class="label">
          <label>分类：</label>
        </div>
        <div class="field">
          <select name="typeName" class="input w50">
            <option value="军事">军事</option>
            <option value="哲学">哲学</option>
            <option value="经济">经济</option>
            <option value="艺术">艺术</option>
            <option value="历史">历史</option>
            <option value="医学">医学</option>
            <option value="自然科学">自然科学</option>
          </select>
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