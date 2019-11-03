<%@page import="com.engineering.entity.Lab"%>
<%@page import="com.engineering.service.impl.LabServiceImpl"%>
<%@page import="com.engineering.service.ILabService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修改实验室信息</title>
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
	if (myform.labID.value == "" || myform.labName.value == "") {
		alert("实验室编号,实验室名字必须填写!!!");
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
	ILabService service = new LabServiceImpl();
	Lab lab = service.queryLab(no);
	System.out.println("jsp  " + no+" "+lab.getLabID() + " " + lab.getLabName() + " " + lab.getLabPlace() + " "
			+ lab.getLabTime() + lab.getIntroduction());
%>
<form action="../UpdateLabServlet?no=<%=no %>" method="post" onSubmit="return update(this)">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>修改实验室信息</th> </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>实验室编号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="labID" value="<%=lab.getLabID() %>" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>实验室名字</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="labName" value="<%=lab.getLabName() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>实验室地点</td>
    	<td class=forumrowhighlight height=24><input type="text" name="labPlace" value="<%=lab.getLabPlace() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>成立时间</td>
    	<td class=forumrowhighlight height=24><input type="date" name="labTime" value="<%=lab.getLabTime() %>" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow height=24>实验室介绍</td>
    	<td class=forumrowhighlight height=24><input type="text" name="Introduction" value="<%=lab.getIntroduction() %> "class="insert_input"></td></tr>
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
