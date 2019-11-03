<%@page import="com.engineering.entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
<style type="text/css">
	html,body{
		width:100%;
		height:100%
	}
	body{
   		background:url(images/success.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
	}
	.masked font,h1,p{
		display: block;
        width: 600px;
        height: 100px;
        /*渐变背景*/
        background-image: -webkit-linear-gradient(left, #3498db, #f47920 10%, #d71345 20%, #f7acbc 30%,
            #ffd400 40%, #3498db 50%, #f47920 60%, #d71345 70%, #f7acbc 80%, #ffd400 90%, #3498db);
        color: transparent; /*文字填充色为透明*/
        -webkit-text-fill-color: transparent;
        -webkit-background-clip: text;          /*背景剪裁为文字，只将文字显示为背景*/
         background-size: 200% 100%;            /*背景图片向水平方向扩大一倍，这样background-position才有移动与变化的空间*/
         /* 动画 */
         animation: masked-animation 4s infinite linear;
	}
    @keyframes masked-animation {
		0% {
			background-position: 0 0;   /*background-position 属性设置背景图像的起始位置。*/
		}
		100% {
            background-position: -100% 0;
        }
    }
</style>
</head>
<body>
<%
	Administrator administrator = (Administrator) session.getAttribute("administrator");
	if(administrator.getAdminID()==null){
		out.println("您还未登录，将在3秒后跳转到登陆界面...");
		response.setHeader("refresh", "3;url=login.jsp");
	}else{
%>
	<div align="center" class="masked">
		<h1 style="font-size:80px">登录成功</h1>
			<font size="13">欢迎管理员【<%=administrator.getAdminName() %>】</font>
	</div>
<%		
	}
%>

</body>
</html>