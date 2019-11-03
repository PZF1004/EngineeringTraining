<%@page import="com.engineering.entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录失败</title>
<style type="text/css">
	html,body{
		width:100%;
		height:100%
	}
	body{
   		background:url(images/fail.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
	}
	.main{
    text-align: center; /*让div内部文字居中*/
    border-radius: 20px;
    width: 500px;
    height: 350px;
    margin: auto;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}
</style>
</head>
<body>
	<div class="main">
		<font size="13" color="blue" valign="middle">登陆失败，将在三秒后跳转到登陆页面</font>
	</div>
	<%
		response.setHeader("refresh", "3;url=login.jsp");
	%>

</body>
</html>