<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加设备信息</title>
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
     height:100%;
	}
	textarea{
	border:none;
    background-color: #eafefe;
    width: 100%;
    height:100%;
	}
</style>
<script>
function increase(myform) {
	if (myform.equipmentID.value == "" || myform.equipmentName.value == "") {
		alert("设备编号、设备名字必须填写!!!");
		return false;
	}
	return true;
}
</script>
<body>
<br>
<form action="../AddEquipmentServlet" method="post" onSubmit="return increase(this)">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>添加设备信息</th> </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>设备编号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="equipmentID" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>设备名字</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="equipmentName" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>设备数量</td>
    	<td class=forumrowhighlight height=24><input type="text" name="equipmentNumber" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>设备地点</td>
    	<td class=forumrowhighlight height=24><input type="text" name="equipmentPlace" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>设备负责人</td>
    	<td class=forumrowhighlight height=24><input type="text" name="equipmentManager" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>设备价格</td>
    	<td class=forumrowhighlight height=24><input type="text" name="equipmentPrice" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>设备状况</td>
    	<td class=forumrowhighlight height=24><input type="text" name="equipmentStatus" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>设备简介</td>
    	<td class=forumrowhighlight height=24><input type="text" name="introduction" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>购买日期</td>
    	<td class=forumrowhighlight height=24><input type="date" name="equipmentTime" class="insert_input"></td>
    </tr>
</table>
	<div align="center">
		<input type="submit" value="确认添加" class="button" /> 
		<input type="reset" value="重新填写" class="button" />
	</div>
</form>
</body>
</html>
