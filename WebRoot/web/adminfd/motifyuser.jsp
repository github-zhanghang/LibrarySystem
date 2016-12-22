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
  <div class="panel-head"><strong><span class="icon-key"></span> 修改读者信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/updateMemberServlet?type=0">
      <div class="form-group">
        <div class="label">
          <label for="sitename">账号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
              <input  style="border:none; background-color:white;"  type="text" name="account" value="${reader.readerAccount}" readonly="true"/>       
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="username" name="newName" size="50" placeholder="请输入姓名" data-validate="required:请输入姓名" value="${reader.readerName}"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="newPhone" size="50" placeholder="请输入联系方式" data-validate="required:请输入联系方式" value="${reader.readerPhone}"/>         
        </div>
      </div>
     
      <!-- <div class="form-group">
       <div class="label">
          <label>是否是在校生：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
          
          <label class="button active">
         	  <span class="icon icon-check"></span>             
              <input name="isshow" value="1" type="radio" checked="checked">是             
          </label>             
        
          <label class="button active"><span class="icon icon-times"></span>          	
              <input name="isshow" value="0"  type="radio" checked="checked">否
          </label>         
           </div>       
        </div>
      </div> -->
      
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