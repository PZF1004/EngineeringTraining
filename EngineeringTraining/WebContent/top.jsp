<%@page import="com.engineering.entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE2 {font-size: 9px}
.STYLE3 {
	color: #033d61;
	font-size: 12px;
}
-->
</style>
</head>
<body>
<%
	Administrator administrator = (Administrator) session.getAttribute("administrator");
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="70" background="images/top/top_3.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="24" background="images/top/top_1.gif">&nbsp;</td>
            <td width="505" background="images/top/top_2.gif">&nbsp;</td>
            <td>&nbsp;</td>
            <td width="21"><img src="images/top/top_4.gif" width="21" height="24"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="38"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="38" background="images/top/top_5.gif">&nbsp;</td>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="77%" height="25" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="50" height="19"><div align="center"><!-- 首页 -->
                    	<a href="loginSuccess.jsp" target="tab"><img src="images/top/top_7.gif" width="49" height="19"></a></div>
                    </td>
                    <td width="50"><div align="center"><img src="images/top/top_8.gif" width="48" height="19"></div></td>
                    <td width="50"><div align="center"><img src="images/top/top_9.gif" width="48" height="19"></div></td>
                    <td width="50"><div align="center"><img src="images/top/top_10.gif" width="48" height="19"></div></td>
     			    <td width="50"><div align="center"><!-- 退出 -->
     					<a href="exit.jsp" target="_top"><img src="images/top/top_11.gif" width="48" height="19"></a></div>
     				</td>
                    <td width="26"><div align="center"><img src="images/top/top_12.gif" width="26" height="19"></div></td>
                    <td width="100"><div align="center"><a href="page/UpdateAdmin.jsp?no=<%=administrator.getAdminID() %>" target="tab"><img src="images/top/top_13.gif" width="98" height="19"></a></div></td>
                    <td>&nbsp;</td>
                  </tr>
                </table></td>
                <td width="220" valign="bottom"  nowrap="nowrap"><div align="right"><span class="STYLE1"><span class="STYLE2">■</span>您的登陆时间是：<%=session.getAttribute("loginTime") %></span></div></td>
              </tr>
            </table></td>
            <td width="21"><img src="images/top/top_6.gif" width="21" height="38"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="8" style=" line-height:8px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" background="images/top/top_14.gif" style=" line-height:8px;">&nbsp;</td>
            <td width="505" background="images/top/top_15.gif" style=" line-height:8px;">&nbsp;</td>
            <td style=" line-height:8px;">&nbsp;</td>
            <td width="21" style=" line-height:8px;"><img src="images/top/top_16.gif" width="21" height="8"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="images/top/top_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="177" height="28" background="images/top/top_17.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20%"  height="22">&nbsp;</td>
            <td width="59%" valign="bottom"><div align="center" class="STYLE1">当前用户：<%=administrator.getAdminName() %></div></td>
            <td width="21%">&nbsp;</td>
          </tr>
        </table></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          	<tr>
 <!-- ******************************************************************************** -->         
            <td width="65" height="28"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="23" valign="bottom"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr> 
                    <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(images/top/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="#" target="_self"><div align="center" class="STYLE3">业务中心</div></a></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
            <td width="3"><img src="images/top/top_18.gif" width="3" height="28"></td>
  <!-- ******************************************************************************** -->                    
            <td width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">                   
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(images/top/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="#" target="_self"><div align="center" class="STYLE3">系统管理</div></a></td>
              </tr>
            </table></td>
            <td width="3"><img src="images/top/top_18.gif" width="3" height="28"></td>
 <!-- ******************************************************************************** -->         
            <td width="63"><table width="65" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(images/top/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="QueryAllAdminServlet" target="tab"><div align="center" class="STYLE3">管理员信息</div></a></td>
              </tr>
            </table></td>
            <td width="3"><img src="images/top/top_18.gif" width="3" height="28"></td>
 <!-- ******************************************************************************** -->         
            <td width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(images/top/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="#" target="_self"><div align="center" class="STYLE3">数据管理</div></a></td>
              </tr>
            </table></td>
            <td width="3"><img src="images/top/top_18.gif" width="3" height="28"></td>
 <!-- ******************************************************************************** -->         
            <td width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(images/top/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="#" target="_self"><div align="center" class="STYLE3">业务管理</div></a></td>
              </tr>
            </table></td>
            <td width="3"><img src="images/top/top_18.gif" width="3" height="28"></td>
 <!-- ******************************************************************************** -->         
            <td width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(images/top/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="#" target="_self"><div align="center" class="STYLE3">系统配置</div></a></td>
              </tr>
            </table></td>
            <td width="3"><img src="images/top/top_18.gif" width="3" height="28"></td>
 <!-- ******************************************************************************** -->                     
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="21"><img src="images/top/top_20.gif" width="21" height="28"></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>