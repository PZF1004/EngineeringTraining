<%@page import="com.engineering.entity.Lab"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加学生信息</title>
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
	if (myform.stuno.value == "" || myform.name.value == "" ||myform.labID.value == "" ) {
		alert("学生的学号，姓名,实验室编号必须填写!!!");
		return false;
	}
	return true;
}
</script>
</head>
<%
	//Lab lab = (Lab)request.getAttribute("lab");
	
%>
<body>

<br>
<form action="../AddStudentServlet3" method="post" onSubmit="return increase(this)" enctype="multipart/form-data">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>请添加学生信息</th> </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>学号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="stuno" class="insert_input"></td></tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>姓名</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="name" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow width="10%" height=24>性别</td>
    	<td class=forumrowhighlight height=24>
    		<label for="nan">男 </label> <input name="sex" type="radio" id="nan" value="男" checked="checked"> 
			<label for="nv">女</label> <input name="sex" type="radio" id="nv" value="女" >
    	</td>
    </tr>
    <tr>
    	<td class=forumrow height=24>电话</td>
    	<td class=forumrowhighlight height=24><input type="text" name="phone" class="insert_input"></td>
    </tr>
    
  	<tr>
    	<td class=forumrow height=24>院系</td>
    	<td class=forumrowhighlight height=24><input type="text" name="dept" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>班级</td>
    	<td class=forumrowhighlight height=24><input type="text" name="classID" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>工作室编号</td>
    	<td class=forumrowhighlight height=24><input type="text" name="labID" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>进入时间</td>
    	<td class=forumrowhighlight height=24><input type="date" name="entryTime" class="insert_input"></td>
    </tr>
    
    <tr>
    	<td class=forumrow height=24>职务</td>
    	<td class=forumrowhighlight height=24><input type="text" name="position" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>比赛经历</td>
    	<td class=forumrowhighlight height=24>
    		<textarea rows="2" cols="100" maxlength="200" name="gameExperience" placeholder="输入内容不超过100个字"></textarea>
    	</td>
    </tr>
    <tr>
    	<td class=forumrow height=24>获奖信息</td>
    	<td class=forumrowhighlight height=24>
    		<textarea rows="2" cols="100" maxlength="200" name="winInformation" placeholder="输入内容不超过100个字"></textarea>
    	</td>
    	
    </tr>
    <tr>
    	<td class=forumrow height=24>毕业时间</td>
    	<td class=forumrowhighlight height=24><input type="date" name="graduationTime" class="insert_input"></td>
    </tr>
    
    <tr>
    	<td class=forumrow height=24>就业单位</td>
    	<td class=forumrowhighlight height=24><input type="text" name="employmentUnit" class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>毕业后的突出表现</td>
    	<td class=forumrowhighlight height=24>
    		<textarea rows="2" cols="100" maxlength="200" name="performance" placeholder="输入内容不超过100个字"></textarea>
    	</td>
    </tr>
    <tr>
    	<td class=forumrow height=24>上传照片</td>
    	<td class=forumrowhighlight height=24><input type="file" name="picture" class="insert_input"/></td>
    </tr>
</table>
	<div align="center">
		<input type="submit" value="确认添加" class="button" /> 
		<input type="reset" value="重新填写" class="button" />
	</div>
</form>
</body>
</html>
