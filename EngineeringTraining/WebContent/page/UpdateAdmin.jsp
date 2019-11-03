<%@page import="com.engineering.entity.Administrator"%>
<%@page import="com.engineering.service.impl.AdministratorServiceImpl"%>
<%@page import="com.engineering.service.IAdministratorService"%>
<%@page import="com.engineering.entity.Lab"%>
<%@page import="com.engineering.service.impl.LabServiceImpl"%>
<%@page import="com.engineering.service.ILabService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修改管理员信息</title>
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
	if (myform.adminID.value == "" || myform.adminName.value == "" || myform.password.value == "") {
		alert("管理员编号,管理员姓名，密码必须填写!!!");
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
	IAdministratorService service = new AdministratorServiceImpl();
	Administrator administrator = service.queryAdministrator(no);
%>
<form action="../UpdateAdminServlet?no=<%=no %>" method="post" onSubmit="return update(this)">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>修改管理员信息</th> </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>管理员编号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="adminID" value="<%=administrator.getAdminID() %>" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>管理员姓名</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="adminName" value="<%=administrator.getAdminName() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>管理员性别</td>
    	<td class=forumrowhighlight height=24><input type="text" name="sex" value="<%=administrator.getSex() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>管理员所在院系</td>
    	<td class=forumrowhighlight height=24><input type="text" name="dept" value="<%=administrator.getDept() %>" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow height=24>密码</td>
    	<td class=forumrowhighlight height=24><input type="text" name="password" value="<%=administrator.getPassword() %> "class="insert_input"></td></tr>
  	<tr>
  	<tr>
    	<td class=forumrow height=24>实验室编号</td>
    	<td class=forumrowhighlight height=24><input type="text" name="labID" value="<%=administrator.getLabID() %> "class="insert_input"></td></tr>
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
