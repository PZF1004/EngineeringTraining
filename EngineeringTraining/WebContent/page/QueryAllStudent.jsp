<%@page import="com.engineering.entity.Page"%>
<%@page import="com.engineering.entity.Lab"%>
<%@page import="com.engineering.service.impl.LabServiceImpl"%>
<%@page import="com.engineering.service.ILabService"%>
<%@page import="com.engineering.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
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
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="tab/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="tab/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="tab/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[学生管理]-[学生信息]</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="checkbox62" value="checkbox" />
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="tab/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">新增</div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="tab/33.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">修改</div></td>
                  </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="tab/11.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="tab/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
<!-- ************************************************************************************ -->
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
            <td width="23%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">工作室</span></div></td>
            <td width="15%" height="22" background="tab/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
          </tr>
         <%
         	ILabService service2 = new LabServiceImpl();
         	Page p  = (Page)request.getAttribute("p") ;
 			for(Student student:p.getStudents()){
				String labID = student.getLabID();
				Lab lab = service2.queryLab(labID);
		 %>
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox2" value="checkbox" />
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><a href="StudentInfo?stuno=<%=student.getStuno() %>"><div align="center" class="STYLE1"><div align="center"><%=student.getStuno() %></div></div></a></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getName() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getSex() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getDept()==null?"":student.getDept() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=student.getClassID()==null?"":student.getClassID()%></span></div></td>
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
<!-- *************************************************************************************** -->
	<%
		//当前页数据量
		int pageSize = (p.getCurrentPage() == p.getTotalPage())?(p.getTotalCount()%p.getPageSize()):p.getPageSize();
	%>
  <tr>
    <td height="35" background="tab/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="tab/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有<%=p.getTotalCount() %>条记录，当前第 <%=p.getCurrentPage() %>/<%=p.getTotalPage() %> 页，本页共<%=pageSize %>条数据</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
              <%
                if(p.getCurrentPage() ==1){ //当前页是首页
              %>
  <!-- 下一页 --> <td width="40"><a href="QueryAllStudentByPageServlet?currentPage=<%=p.getCurrentPage()+1%> "><img src="tab/next.gif" width="43" height="15" /></a></td>
   <!-- 尾页 -->  <td width="45"><a href="QueryAllStudentByPageServlet?currentPage=<%=p.getTotalPage()%>"><img src="tab/last.gif" width="37" height="15" /></a></td>
               <%
                }else if(p.getCurrentPage() ==p.getTotalPage()){//当前页是尾页
                %>
  <!-- 首页  -->  <td width="45"><a href="QueryAllStudentByPageServlet?currentPage=1"><img src="tab/first.gif" width="37" height="15" /></a></td>
  <!-- 上一页 --> <td width="40"><a href="QueryAllStudentByPageServlet?currentPage=<%=p.getCurrentPage()-1%> "><img src="tab/back.gif" width="43" height="15" /></a></td>
                <%
                }else{ //当前页既不是首页也不是尾页
               %>
  <!-- 首页  -->  <td width="45"><a href="QueryAllStudentByPageServlet?currentPage=1"><img src="tab/first.gif" width="37" height="15" /></a></td>
  <!-- 上一页 --> <td width="40"><a href="QueryAllStudentByPageServlet?currentPage=<%=p.getCurrentPage()-1%> "><img src="tab/back.gif" width="43" height="15" /></a></td>
  <!-- 下一页 --> <td width="40"><a href="QueryAllStudentByPageServlet?currentPage=<%=p.getCurrentPage()+1%> "><img src="tab/next.gif" width="43" height="15" /></a></td>
   <!-- 尾页 -->  <td width="45"><a href="QueryAllStudentByPageServlet?currentPage=<%=p.getTotalPage()%>"><img src="tab/last.gif" width="37" height="15" /></a></td>
               <%
                }
               %>
                  <td width="100"><div align="center">
                  	<span class="STYLE1">转到第
                    	<input name="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                    	页 </span></div>
                  </td>
                  <td width="40"><img src="tab/go.gif" width="37" height="15" /></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="tab/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>