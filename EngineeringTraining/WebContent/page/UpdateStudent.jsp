<%@page import="com.engineering.service.impl.StudentServiceImpl"%>
<%@page import="com.engineering.service.IStudentService"%>
<%@page import="com.engineering.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修改学生信息</title>
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
	textarea{
	border:none;
    background-color: #eafefe;
    width: 100%;
    height:100%;
	}
</style>
<script>
function update(myform) {
	if (myform.stuno.value == "" || myform.name.value == "" || myform.labID.value == "") {
		alert("学号，学生姓名，实验室编号必须填写!!!");
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
	IStudentService service = new StudentServiceImpl();
	Student student = service.queryStudent2(no);
%>
<form action="../UpdateStudentServlet2?no=<%=no %>" method="post" onSubmit="return update(this)" enctype="multipart/form-data">
<table cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  	<tr><th colSpan=2 height=24>修改学生信息</th> </tr>
  	<tr>
    	<td class=forumrow height=24>上传照片</td>
    	<td class=forumrowhighlight height=24><input type="file" name="picture" class="insert_input"/></td>
    </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>学号</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="stuno" value="<%=student.getStuno()==null?"":student.getStuno() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow width="20%" height=24>姓名</td>
    	<td class=forumrowhighlight width="80%" height=24><input type="text" name="name" value="<%=student.getName()==null?"":student.getName() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>性别</td>
    	<td class=forumrowhighlight height=24><input type="text" name="sex" value="<%=student.getSex()==null?"":student.getSex() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>电话</td>
    	<td class=forumrowhighlight height=24><input type="text" name="phone" value="<%=student.getPhone()==null?"":student.getPhone() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>院系</td>
    	<td class=forumrowhighlight height=24><input type="text" name="dept" value="<%=student.getDept()==null?"":student.getDept() %>" class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>班级</td>
    	<td class=forumrowhighlight height=24><input type="text" name="classID" value="<%=student.getClassID()==null?"":student.getDept() %> "class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>实验室编号</td>
    	<td class=forumrowhighlight height=24><input type="text" name="labID" value="<%=student.getLabID()==null?"":student.getLabID() %> "class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>职务</td>
    	<td class=forumrowhighlight height=24><input type="text" name="position" value="<%=student.getPosition()==null?"":student.getPosition() %> " class="insert_input"></td>
    </tr>
    <tr>
    	<td class=forumrow height=24>进入时间</td>
    	<td class=forumrowhighlight height=24><input type="date" name="entryTime" value="<%=student.getEntryTime().equals("1111-11-11")?"":student.getEntryTime() %>" class="insert_input" ></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>比赛经历</td>
    	<td class=forumrowhighlight height=24>
    		<textarea rows="2" cols="100" maxlength="200" name="gameExperience" class="insert_input"><%=student.getGameExperience()==null?"":student.getGameExperience() %></textarea>
    	</td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>获奖信息</td>
    	<td class=forumrowhighlight height=24>
    		<textarea rows="2" cols="100" maxlength="200" name="winInformation" class="insert_input"><%=student.getWinInformation()==null?"":student.getWinInformation() %></textarea>
    	</td>
    </tr>
	<tr>
    	<td class=forumrow height=24>毕业时间</td>
    	<td class=forumrowhighlight height=24><input type="date" name="graduationTime" class="insert_input" value="<%= student.getGraduationTime().equals("1111-11-11")?"":student.getGraduationTime()%>"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>就业单位</td>
    	<td class=forumrowhighlight height=24><input type="text" name="employmentUnit" value="<%=student.getEmploymentUnit()==null?"":student.getEmploymentUnit() %> "class="insert_input"></td>
    </tr>
  	<tr>
    	<td class=forumrow height=24>毕业后的突出表现</td>
    	<td class=forumrowhighlight height=24>
    		<textarea rows="2" cols="100" maxlength="200" name="performance" class="insert_input"><%=student.getPerformance()==null?"":student.getPerformance() %></textarea>
    	</td>
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
