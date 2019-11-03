<%@page import="com.engineering.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.engineering.entity.Lab"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>实验室详细信息</title>
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
function increase(myform) {
	if (myform.labID.value == "" || myform.labName.value == "") {
		alert("实验室编号,实验室名字必须填写!!!");
		return false;
	}
	return true;
}
function del(no){
	var flag = window.confirm("是否真的要删除？");
	if(flag){
		window.location.href = "DeleteStudentServlet?no=" + no;
	}
}
function update(no){
	var flag = window.confirm("是否要修改？");
	if(flag){
		window.location.href = "page/UpdateStudent.jsp?no=" + no;
	}
}
</script>
<body>
<%
	Lab lab = (Lab)request.getAttribute("lab");
	if(lab != null){
%>
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
  	<tr><th width="100%" height="20" background="tab/bg.gif">【<%=lab.getLabName() %>】</th></tr>
  	<tr>
    	<td align="center" valign="middle" width="100%" height="80" background="tab/bg.gif" bgcolor="#FFFFFF">编号为【<%=lab.getLabID() %>】的【<%=lab.getLabName() %>】位于【<%=lab.getLabPlace()==null?"":lab.getLabPlace() %>】 <br>
    		它成立于【<%=lab.getLabTime().equals("1111-11-11")?"":lab.getLabTime()%>,】 <font color=green><%=lab.getIntroduction()==null?"":lab.getIntroduction() %></font>
      	</td>
     </tr>
</table>
<%
	}
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="tab/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="3%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox" value="checkbox" />
            </div></td>
            <td width="5%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">学号</span></div></td>
            <td width="12%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">姓名</span></div></td>
            <td width="5%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">性别</span></div></td>
            <td width="16%" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">院系</span></div></td>
            <td width="12%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">班级</span></div></td>
            <td width="23%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">工作室编号</span></div></td>
            <td width="15%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
          </tr>
         <%
			List<Student> students = (List<Student>)request.getAttribute("students") ;
			for(Student student:students){
		 %>
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox2" value="checkbox" />
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><a href="StudentInfo?stuno=<%=student.getStuno() %>"><div align="center" class="STYLE1"><div align="center"><%=student.getStuno() %></div></div></a></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getName() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getSex()==null?"":student.getSex() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getDept()==null?"":student.getDept() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getClassID()==null?"":student.getClassID() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=lab.getLabName() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF">
            	<div align="center">
            		<span class="STYLE4">
            			<a href="javascript:update(<%=student.getStuno() %>)"><img src="tab/edt.gif" width="16" height="16" />编辑</a>&nbsp; &nbsp;
            			<a href="javascript:del(<%=student.getStuno() %>)"><img src="tab/del.gif" width="16" height="16" />删除</a>
            		</span>
            	</div>
            </td>
          </tr>
        <% 
        	} 
        %>
        </table></td>
        <td width="8" background="tab/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
