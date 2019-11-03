<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加管理员</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/CSS" href="../css/Admin.css"/>
<script language=javascript src="../js/Admin.js"></script>
<style type=text/css>
	.STYLE1 {
		font-weight:bold;color:#0099ff
	}
	.insert_input{
	 border:none;
     background-color: #eafefe;
     width: 100%;
     height:100%
	} 
</style>
<script>
function increase(myform) {
	if (myform.adminID.value == "" || myform.adminName.value == "" || myform.password.value == "") {
		alert("管理员编号,管理员姓名，密码必须填写!!!");
		return false;
	}
	return true;
}
</script>
<body>
<br>
<form action="../AddAdminServlet" method="post" onSubmit="return increase(this)">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>请添加管理员信息</th> </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>管理员编号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="adminID" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>管理员姓名</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="adminName" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow width="10%" height=24>性别</td>
    	<td class=forumrowhighlight height=24>
    		<label for="nan">男 </label> <input name="sex" type="radio" id="nan" value="男" checked="checked"> 
			<label for="nv">女</label> <input name="sex" type="radio" id="nv" value="女" >
    	</td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>所在院系</td>
    	<td class=forumrowhighlight height=24><input type="text" name="dept" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>密码</td>
    	<td class=forumrowhighlight height=24><input type="text" name="password" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>实验室编号</td>
    	<td class=forumrowhighlight height=24><input type="text" name="labID" class="insert_input"></td>
    </tr>
</table>
	<div align="center">
		<input type="submit" value="确认添加" class="button" /> 
		<input type="reset" value="重新填写" class="button" />
	</div>
</form>
</body>
</html>
