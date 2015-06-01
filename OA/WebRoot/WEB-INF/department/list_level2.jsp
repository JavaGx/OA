<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML>
<HEAD>
    <TITLE>部门列表</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/jquery.js"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
    <LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <SCRIPT TYPE="text/javascript">
    </SCRIPT>
</HEAD>
<BODY>

<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 部门管理
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<DIV ID="MainArea">
    <TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle">
       
        <!-- 表头-->
        <THEAD>
            <TR ALIGN=center VALIGN=middle ID=TableTitle>
            	<TD WIDTH="150px">部门名称</TD>
				<TD WIDTH="150px">上级部门名称</TD>
				<TD WIDTH="200px">职能说明</TD>
				<TD>相关操作</TD>
            </TR>
        </THEAD>

		<!--显示数据列表-->
        <TBODY ID="TableData" CLASS="dataContainer" dataKey="departmentList2">
			<s:iterator value="#list">
				<tr class="TableDetail1 template">
					<td><s:a action="department_list?parentId=%{id}">${name}</s:a>&nbsp;</td>
					<td>${parent.name}&nbsp;</td> 
					<td>${description}&nbsp;</td>
					<td><s:a action="department_delete?id=%{id}&parentId=%{parent.id}" onclick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')">删除</s:a>
						<s:a action="department_editUI?id=%{id}&parentId=%{parent.id}">修改</s:a>
					</td>
				</tr>
			</s:iterator>
        </TBODY>
    </TABLE>
    
    <!-- 其他功能超链接 -->
    <DIV ID="TableTail">
        <DIV ID="TableTail_inside">
            <s:a action="department_addUI?parentId=%{#parent.id}"><IMG SRC="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
			<s:a action="department_list?parentId=%{#parent.parent.id}"><IMG SRC="${pageContext.request.contextPath}/style/blue/images/button/ReturnToPrevLevel.png" /></s:a>
        </DIV>
    </DIV>
</DIV>
</BODY>
</HTML>
