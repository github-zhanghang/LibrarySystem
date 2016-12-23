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
  <div class="panel-head"><strong><span class="icon-key"></span> 修改管理员信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/updateMemberServlet?type=1">
      <div class="form-group">
        <div class="label">
          <label for="sitename">账号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
              <input  style="border:none; background-color:white;"  type="text" name="account" value="${manager.managerAccount}" readonly="true"/>       
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="newName" name="newName" size="50" placeholder="请输入姓名" data-validate="required:请输入姓名" value="${manager.managerName}"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="newPhone" size="50" placeholder="请输入联系方式" data-validate="required:请输入联系方式" value="${manager.managerPhone}"/>         
        </div>
      </div>
      <div class="form-group">
					<div class="label">
						<label for="sitename">职责：</label>
					</div>
					<div class="field">
						<select name="newDuty" class="input" 
							style="width:200px; line-height:17px;" onChange="showConditionInput(this)">
							<option value="超级管理员" >超级管理员</option>
							<option value="读者管理员" >读者管理员</option>
							<option value="罚款管理员" >罚款管理员</option>
							<option value="盘点管理员" >盘点管理员</option>
							<option value="采购管理员" >采购管理员</option>
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