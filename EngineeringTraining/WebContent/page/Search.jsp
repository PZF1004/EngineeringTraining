<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>搜索</title>
<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<style>
	* {
       box-sizing: border-box;
        }

	body {
		margin: 0;
		padding: 0;
        background: #A3D0C3;
        font-weight: 500;
        font-family: "Microsoft YaHei","宋体","Segoe UI", "Lucida Grande", Helvetica, Arial,sans-serif, FreeSans, Arimo;
	}

    #container {
        width: 500px;
        height: 820px;
        margin: 0 auto;
    }
    div.search {padding: 30px 0;}

    form {
        position: relative;
        width: 300px;
        margin: 0 auto;
    }

    input, button {
        border: none;
        outline: none;
    }

    input {
        width: 100%;
        height: 42px;
        padding-left: 13px;
    }

    button {
        height: 42px;
        width: 42px;
        cursor: pointer;
        position: absolute;
    }

    .bar1 {background: #A3D0C3;}
    .bar1 input {
   	 	border: 2px solid #7BA7AB;
        border-radius: 5px;
        background: #F9F0DA;
        color: #9E9C9C;
    }
    .bar1 button {
        top: 0;
        right: 0;
        background: #7BA7AB;
        border-radius: 0 5px 5px 0;
    }
    .bar1 button:before {
        content: "\f002";
        font-family: FontAwesome;
        font-size: 16px;
        color: #F9F0DA;
    }
    img{
    	width:15% ;
    	float=:left;
    	padding: 10px;
    	
    }
    
</style>
</head>
<body>
<div id="container"><div class="search bar1">
	<form action="../SearchServlet" method="post">
		<input type="text" name="search" placeholder="请输入您要搜索的内容...">
        <button type="submit"></button>
    </form>
    <div align="center">
    	<a href="../Sort?id=classID"><img alt="图片丢失" src="../images/paixu.png" title="按班级排序"></a>
    	<a href="../Sort?id=name"><img alt="图片丢失" src="../images/paixu.png" title="按姓名排序"></a>
    	<a href="../Sort?id=time"><img alt="图片丢失" src="../images/paixu.png" title="按进入时间排序"></a>
	</div>
</div></div>
<div>
	
</div>
</body>
</html>