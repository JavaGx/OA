<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>您已退出Itcast OA系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/blue/logout.css" />
</head>

<body>
	<table border="0" cellspacing="0" cellpadding="0" width="100%" style="height: 100%;">
		<tr>
			<td align="center">
				<div id="Logout">
					<div id="AwokeMsg"><img id="LogoutImg" src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif" border="0" /><img id="LogoutTitle" src="${pageContext.request.contextPath}/style/blue/images/logout/logout1.gif" border="0" /></div>
					<div id="LogoutOperate">
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif" border=0 /> <a href="${pageContext.request.contextPath}/loginUI.jsp">重新进入系统</a>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif" border=0 /> <a href="javascript: window.close();">关闭当前窗口</a>
                    </div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
