<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="script/jquery.js"></script>
<script language="JavaScript" src="script/menu.js"></script>

<script type="text/javascript">
$().ready(function(){
	$(".level1Style").css("cursor","pointer").click(function(){
		$(this).next().toggle()
	})


});
</script>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
</head>
<body style="margin: 0">
<div id="Menu">
    <ul id="MenuUl">
        <s:iterator value="#application.topMenu"> 
        	<s:if test="%{#session.user.getPrivilege(name)}">    
		        <li class="level1">
			        <div class="level1Style"><img src="style/images/MenuIcon/${id}.gif" class="Icon" />${name}</div>
			        <ul class="MenuLevel2">
			        	<s:iterator value="childrenPri">
			        		<s:if test="%{#session.user.getPrivilege(name)}">		        		
					             <li class="level2">
					                 <div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_single.gif" /> <a target="right" href="${pageContext.request.contextPath}${url}.action">${name}</a></div>
					             </li>
					         </s:if>
			         	</s:iterator>
			        </ul>
		        </li>
	        </s:if> 
        </s:iterator>
    </ul>
</div>
</body>
</html>
