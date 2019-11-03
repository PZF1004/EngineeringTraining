<%@page import="java.io.OutputStream"%>
<%@page import="com.engineering.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.engineering.entity.Lab"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>学生详细信息</title>
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
     text-align:center;
     font-weight:bold;color:#0099ff
	}
div{
	background-color: #eafefe;
}
img {
    width: 10em;
    height: 10em;
    
}
</style>
<script>
function del(no){
	var flag = window.confirm("是否真的要删除？");
	if(flag){
		window.location.href = "DeleteStudentServlet?no=" + no;
	}
}
</script>
<body>
<%
	Lab lab = (Lab)request.getAttribute("lab");
	Student student = (Student)request.getAttribute("student");
%>
<div>
	<img alt="图片无法正常显示" src="${pageContext.request.contextPath}/ReadPictureServlet?stuno=<%=student.getStuno() %>" />
</div>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="tab/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
        	<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">学号</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getStuno() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">姓名</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getName() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">性别</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getSex() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">电话</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getPhone() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">院系</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getDept() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">班级</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getClassID() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">工作室编号</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getLabID() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">工作室名称</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=lab.getLabName() %></span></div></td>
    		</tr>
    		
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">职务</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getPosition()==null?"":student.getPosition() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">进入时间</span></div></td>
    			<td width="80%" height=20 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getEntryTime().equals("1111-11-11")?"":student.getEntryTime() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">比赛经历</span></div></td>
    			<td width="80%" height=40 bgcolor="#eafefe"><span class="STYLE1"><textarea rows="2" cols="100" maxlength="200" readonly="readonly"><%=student.getGameExperience()==null?"":student.getGameExperience() %></textarea></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">获奖信息</span></div></td>
    			<td width="80%" height=40 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><textarea rows="2" cols="100" maxlength="200" readonly="readonly"><%=student.getWinInformation()==null?"":student.getWinInformation() %></textarea></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">毕业时间</span></div></td>
    			<td width="80%" height=40 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getGraduationTime().equals("1111-11-11")?"":student.getGraduationTime() %></span></div></td>
   			</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">就业单位</span></div></td>
    			<td width="80%" height=40 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><%=student.getEmploymentUnit()==null?"":student.getEmploymentUnit() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="20%" height=20 background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">毕业后的突出表现</span></div></td>
    			<td width="80%" height=40 bgcolor="#eafefe"><div align="center"><span class="STYLE1"><textarea rows="2" cols="100" maxlength="200" readonly="readonly"><%=student.getPerformance()==null?"":student.getPerformance() %></textarea></span></div></td>
    		</tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
