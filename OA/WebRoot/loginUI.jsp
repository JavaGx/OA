<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv=Content-Type content="text/html; charset=gbk" />
	<title>Itcast OA</title>
	<link href="${pageContext.request.contextPath}/style/blue/login.css" type=text/css rel=stylesheet />
	
<script type="text/javascript">

		$(function(){		
			document.forms[0].LoginName.focus();
		});
		
		// 在被嵌套时就刷新上级窗口
		if(window.parent != window){
			window.parent.location.reload(true);
		}
	</script>
</head>
<body LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<s:form name="actForm" action="user_login.action">
    <div id="CenterAreaBg">
        <div id="CenterArea">
            <div id="LogoImg"><img border="0" src="${pageContext.request.contextPath}/style/blue/images/logo.png" /></div>
            <div id="LoginInfo">
                <table border=0 cellspacing=0 cellpadding=0 width=100%>
                    <tr>
                        <td width=45 class="Subject"><img border="0" src="${pageContext.request.contextPath}/style/blue/images/login/userId.gif" /></td>
                        <td><input size="20" class="TextField" type="text" name="LoginName" /></td>
                        <td rowspan="2" style="padding-left:10px;"><input type="image" src="${pageContext.request.contextPath}/style/blue/images/login/userLogin_button.gif"/></td>
                    </tr>
                    <tr>
                        <td class="Subject"><img border="0" src="${pageContext.request.contextPath}/style/blue/images/login/password.gif" /></td>
                        <td><input size="20" class="TextField" type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td colspan="3"><s:fielderror value="#errorInfo"></s:fielderror>  </td>
                    </tr>
                </table>
            </div>
            <div id="CopyRight"><a href="javascript:void(0)">&copy; 2010 版权所有 itcast</a></div>
        </div>
    </div>
</s:form>
</body>

</html>

