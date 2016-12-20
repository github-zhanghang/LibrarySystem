<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<form method="post" action="" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 图书信息列表</strong> <a href=""
					style="float:right; display:none;">添加字段</a>
			</div>
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li><a class="button border-main icon-plus-square-o" href="addbooks.jsp">
							添加图书</a></li>
					<li>搜索：</li>
			
					<if condition="$iscid eq 1">
					<li><select name="cid" class="input"
						style="width:200px; line-height:17px;" onchange="changesearch()">
							<option value="">请选择分类</option>
							<option value="">军事</option>
							<option value="">医学</option>
							<option value="">自然科学</option>
							<option value="">计算机</option>
					</select></li>
					</if>
					<li><input type="text" placeholder="请输入搜索关键字" name="keywords"
						class="input"
						style="width:250px; line-height:17px;display:inline-block" /> <a
						href="javascript:void(0)" class="button border-main icon-search"
						onclick="changesearch()"> 搜索</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="100" style="text-align:left; padding-left:20px;">ID</th>
					<th width="10%">书名</th>
					<th>图片</th>
					<th>作者</th>
					<th>位置</th>
					<th>分类名称</th>
					<th>剩余数量</th>
					<th width="10%">注册时间</th>
					<th width="310">操作</th>
				</tr>
				<volist name="list" id="vo">
				<tr>
					<td style="text-align:left; padding-left:20px;"><input
						type="checkbox" name="id[]" value="" /> 1</td>
					<td>三国演义</td>
					<td width="10%"><img src="images/san.jpg" alt="" width="50"
						height="65" />
					</td>
					<td>罗贯中</td>
					<td><font color="#00CC99">A-01-001</font>
					</td>
					<td>小说</td>
					<td>22</td>
					<td>2016-07-01</td>
					<td><div class="button-group">
							<a class="button border-main" href="motifybooks.jsp"><span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								href="javascript:void(0)" onclick="return del(1,1,1)"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:left; padding-left:20px;"><input
						type="checkbox" name="id[]" value="" /> 1</td>
					<td>三国演义</td>
					<td width="10%"><img src="images/san.jpg" alt="" width="50"
						height="65" />
					</td>
					<td>罗贯中</td>
					<td><font color="#00CC99">A-01-001</font>
					</td>
					<td>小说</td>
					<td>22</td>
					<td>2016-07-01</td>
					<td><div class="button-group">
							<a class="button border-main" href="motifybooks.jsp"><span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								href="javascript:void(0)" onclick="return del(1,1,1)"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:left; padding-left:20px;"><input
						type="checkbox" name="id[]" value="" /> 1</td>
					<td>三国演义</td>
					<td width="10%"><img src="images/san.jpg" alt="" width="50"
						height="65" />
					</td>
					<td>罗贯中</td>
					<td><font color="#00CC99">A-01-001</font>
					</td>
					<td>小说</td>
					<td>22</td>
					<td>2016-07-01</td>
					<td><div class="button-group">
							<a class="button border-main" href="motifybooks.jsp"><span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								href="javascript:void(0)" onclick="return del(1,1,1)"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:left; padding-left:20px;"><input
						type="checkbox" name="id[]" value="" /> 1</td>
					<td>三国演义</td>
					<td width="10%"><img src="images/san.jpg" alt="" width="50"
						height="65" />
					</td>
					<td>罗贯中</td>
					<td><font color="#00CC99">A-01-001</font>
					</td>
					<td>小说</td>
					<td>22</td>
					<td>2016-07-01</td>
					<td><div class="button-group">
							<a class="button border-main" href="motifybooks.jsp"><span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								href="javascript:void(0)" onclick="return del(1,1,1)"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:left; padding-left:20px;"><input
						type="checkbox" name="id[]" value="" /> 1</td>
					<td>三国演义</td>
					<td width="10%"><img src="images/san.jpg" alt="" width="50"
						height="65" />
					</td>
					<td>罗贯中</td>
					<td><font color="#00CC99">A-01-001</font>
					</td>
					<td>小说</td>
					<td>22</td>
					<td>2016-07-01</td>
					<td><div class="button-group">
							<a class="button border-main" href="motifybooks.jsp"><span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								href="javascript:void(0)" onclick="return del(1,1,1)"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:left; padding-left:20px;"><input
						type="checkbox" name="id[]" value="" /> 1</td>
					<td>三国演义</td>
					<td width="10%"><img src="images/san.jpg" alt="" width="50"
						height="65" />
					</td>
					<td>罗贯中</td>
					<td><font color="#00CC99">A-01-001</font>
					</td>
					<td>小说</td>
					<td>22</td>
					<td>2016-07-01</td>
					<td><div class="button-group">
							<a class="button border-main" href="motifybooks.jsp"><span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								href="javascript:void(0)" onclick="return del(1,1,1)"><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:left; padding:19px 0;padding-left:20px;"><input
						type="checkbox" id="checkall" /> 全选</td>
					<td colspan="7" style="text-align:left;padding-left:20px;"><a
						href="javascript:void(0)" class="button border-red icon-trash-o"
						style="padding:5px 15px;" onclick="DelSelect()"> 删除</a>
				</tr>
				<tr>
					<td colspan="8"><div class="pagelist">
							<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
								href="">3</a><a href="">下一页</a><a href="">尾页</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}

</script>
</body>
</html>