<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>网站信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 借阅信息列表</strong>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left:10px;">
				<li>查询：</li>
				<if condition="$iscid eq 1">
				<li><select name="cid" class="input"
					style="width:200px; line-height:17px;" onchange="changesearch()">
						<option value="">请选择</option>
						<option value="">学号</option>
						<option value="">书名</option>
						<option value="">超期</option>
						<option value="">未还图书</option>
				</select></li>
				</if>
				
				<li><input type="text" placeholder="请输入搜索关键字" name="keywords"
					class="input"
					style="width:250px; line-height:17px;display:inline-block" /> <a
					href="javascript:void(0)" class="button border-main icon-search"
					onclick="changesearch()"> 搜索</a></li>
			</ul>
			
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="5%">ID</th>
				<th>姓名</th>
				<th>学号</th>
				<th>联系方式</th>
				<th>书籍名称</th>
				<th>借书时间</th>
				<th>是否超期</th>
				<th width="250">操作</th>
			</tr>

			<tr>
				<td>17</td>
				<td>张航</td>
				<td>131006132</td>
				<td>1312343143</td>
				<td>三国演义</td>
				<td>2016-12-12</td>
				<td><font color="#00CC99">是</font>
				<td>
					<div class="button-group">
						<a type="button" class="button border-main" href="#"><span
							class="icon-edit"></span>归还</a> <a class="button border-red"
							href="javascript:void(0)" onclick="return del(17)"><span
							class="icon-trash-o"></span> 删除</a>
					</div>
				</td>
			</tr>

			<tr>
				<td>17</td>
				<td>张航</td>
				<td>131006132</td>
				<td>1312343143</td>
				<td>三国演义</td>
				<td>2016-12-12</td>
				<td><font color="#00CC99">是</font></td>
				<td>
					<div class="button-group">
						<a type="button" class="button border-main" href="#"><span
							class="icon-edit"></span>归还</a> <a class="button border-red"
							href="javascript:void(0)" onclick="return del(17)"><span
							class="icon-trash-o"></span> 删除</a>
					</div>
				</td>
			</tr>

			<tr>
				<td>17</td>
				<td>张航</td>
				<td>131006132</td>
				<td>1312343143</td>
				<td>三国演义</td>
				<td>2016-12-12</td>
				<td><font color="#00CC99">是</font></td>
				<td>
					<div class="button-group">
						<a type="button" class="button border-main" href="#"><span
							class="icon-edit"></span>归还</a> <a class="button border-red"
							href="javascript:void(0)" onclick="return del(17)"><span
							class="icon-trash-o"></span> 删除</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>17</td>
				<td>张航</td>
				<td>131006132</td>
				<td>1312343143</td>
				<td>三国演义</td>
				<td>2016-12-12</td>
				<td><font color="#00CC99">是</font></td>
				<td>
					<div class="button-group">
						<a type="button" class="button border-main" href="#"><span
							class="icon-edit"></span>归还</a> <a class="button border-red"
							href="javascript:void(0)" onclick="return del(17)"><span
							class="icon-trash-o"></span> 删除</a>
					</div>
				</td>
			</tr>

			<tr>
				<td>17</td>
				<td>张航</td>
				<td>131006132</td>
				<td>1312343143</td>
				<td>三国演义</td>
				<td>2016-12-12</td>
				<td><font color="#00CC99">是</font></td>
				<td>
					<div class="button-group">
						<a type="button" class="button border-main" href="#"><span
							class="icon-edit"></span>归还</a> <a class="button border-red"
							href="javascript:void(0)" onclick="return del(17)"><span
							class="icon-trash-o"></span> 删除</a>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="8"><div class="pagelist">
						<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
							href="">3</a><a href="">下一页</a><a href="">尾页</a>
					</div></td>
			</tr>
		</table>
	</div>
	<script>
function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>
</body>
</html>