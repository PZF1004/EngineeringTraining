<%@page import="com.engineering.entity.Equipment"%>
<%@page import="com.engineering.service.impl.EquipmentServiceImpl"%>
<%@page import="com.engineering.service.IEquipmentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修改设备信息</title>
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
function update(myform) {
	if (myform.equipmentID.value == "" || myform.equipmentName.value == "") {
		alert("设备编号、设备名字必须填写!!!");
		return false;
	}
	return true;
}
</script>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	// 接口 xxx = new 实现类
	IEquipmentService service = new EquipmentServiceImpl();
	Equipment equipment = service.queryEquipment(no);
%>
<form action="../UpdateEquipmentServlet?no=<%=no %>" method="post" onSubmit="return update(this)">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>修改设备信息</th> </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>设备编号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="equipmentID" value="<%=equipment.getEquipmentID() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>设备名字</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="equipmentName" value="<%=equipment.getEquipmentName() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>设备数量</td>
    	<td class=forumrowhighlight height=24><input type="text" name=equipmentNumber value="<%=equipment.getEquipmentNumber() %>" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>设备地点</td>
    	<td class=forumrowhighlight height=24><input type="text" name=equipmentPlace value="<%=equipment.getEquipmentPlace() %>" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>设备负责人</td>
    	<td class=forumrowhighlight height=24><input type="text" name=equipmentManager value="<%=equipment.getEquipmentManager() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>设备价格</td>
    	<td class=forumrowhighlight height=24><input type="text" name="equipmentPrice" value="<%=equipment.getEquipmentPrice() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>设备状况</td>
    	<td class=forumrowhighlight height=24><input type="text" name="equipmentStatus" value="<%=equipment.getEquipmentStatus() %> "class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>设备简介</td>
    	<td class=forumrowhighlight height=24><input type="text" name="introduction" value="<%=equipment.getIntroduction() %> " class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>购买日期</td>
    	<td class=forumrowhighlight height=24><input type="date" name="equipmentTime" value="<%=equipment.getEquipmentTime() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrowhighlight colSpan=2 height=24></td>
    </tr>
</table>
	<div align="center">
		<input type="submit" value="确认修改" class="button" /> 
		<input type="reset" value="重新填写" class="button" />
	</div>
</form>
</body>
</html>
