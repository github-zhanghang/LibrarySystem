<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
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

  <div class="padding border-bottom">  
  <a class="button border-yellow" href="addclassify.jsp"><span class="icon-plus-square-o"></span> 添加类别</a>
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>
      <th width="15%">图书类别</th>
      <th width="15%">注册时间</th>
      <th width="10%">操作</th>
    </tr>
    <tr>
      <td>1</td>
      <td>军事</td>
      <td>2016-12-12</td>
      <td><div class="button-group"> <a class="button border-main" href="cateedit.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
    <tr>
     <td>1</td>
      <td>军事</td>
      <td>2016-12-12</td>
      <td><div class="button-group"> <a class="button border-main" href="cateedit.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
    <tr>
      <td>1</td>
      <td>军事</td>
      <td>2016-12-12</td>
      <td><div class="button-group"> <a class="button border-main" href="cateedit.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
    <tr>
     <td>1</td>
      <td>军事</td>
      <td>2016-12-12</td>
      <td><div class="button-group"> <a class="button border-main" href="cateedit.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
    <tr>
      <td>1</td>
      <td>军事</td>
      <td>2016-12-12</td>
      <td><div class="button-group"> <a class="button border-main" href="cateedit.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
    <tr>
     <td>1</td>
      <td>军事</td>
      <td>2016-12-12</td>
      <td><div class="button-group"> <a class="button border-main" href="cateedit.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
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
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){			
		
	}
}
</script>

</body>
</html>