<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加工作室信息</title>
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
	if (myform.labID.value == "" || myform.labName.value == "") {
		alert("工作室编号,工作室名字必须填写!!!");
		return false;
	}
	return true;
}
</script>
<body>

<br>
<form action="../AddLabServlet" method="post" onSubmit="return increase(this)">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>请添加要插入的信息</th> </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>工作室编号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="labID" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>工作室名字</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="labName" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>工作室地点</td>
    	<td class=forumrowhighlight height=24><input type="text" name="labPlace" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>成立时间</td>
    	<td class=forumrowhighlight height=24><input type="date" name="labTime" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow height=24>工作室介绍</td>
    	<td class=forumrowhighlight height=24><input type="text" name="Introduction" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrowhighlight colSpan=2 height=24></td>
    </tr>
</table>
	<div align="center">
		<input type="submit" value="确认添加" class="button" /> 
		<input type="reset" value="重新填写" class="button" />
	</div>
</form>

</body>
</html>
