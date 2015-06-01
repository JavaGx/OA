<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>【<s:property value="%{#forum.name}"/>】中的主题列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/forum.css" />

	<script type="text/javascript">
		function change(value){
			if(value==0){
				$("select[name='reverse']").attr("disabled","disabled");
			}
		}
		
		$().ready(function(){
			$("input[type='image']").click(function(){
				document.forms[0].submit();
			
			})
		
		
		});
	</script>
	
	<script type="text/javascript">
		function gotoPage(num){		
			var id=$("#id").val()
			//window.location.href="topic_list.action?forumId="+id+"&num="+num;
			$(document.forms[0]).append("<input type='hidden' name='num' value='"+num+"'/>");
			document.forms[0].submit();
		};
	</script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 【<s:property value="#forum.name"/>】中的主题列表
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<s:form action="topic_list.action">

<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%;">
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forum_list">论坛</s:a>
			<font class="MenuPoint"> &gt; </font>
			<s:property value="#forum.name"/>
			<span style="margin-left:30px;"><s:a action="topic_addUI?forumId=%{#forum.id}">
				<img align="absmiddle" src="${pageContext.request.contextPath}/style/blue/images/button/publishNewTopic.png"/></s:a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<!--表头-->
				<tr align="center" valign="middle">
					<td width="3" class="ForumPageTableTitleLeft">
						<img border="0" width="1" height="1" src="${pageContext.request.contextPath}/style/images/blank.gif" />
					</td>
					<td width="50" class="ForumPageTableTitle"><!--状态/图标-->&nbsp;</td>
					<td class="ForumPageTableTitle">主题</td>
					<td width="130" class="ForumPageTableTitle">作者</td>
					<td width="100" class="ForumPageTableTitle">回复数</td>
					<td width="130" class="ForumPageTableTitle">最后回复</td>
					<td width="3" class="ForumPageTableTitleRight">
						<img border="0" width="1" height="1" src="${pageContext.request.contextPath}/style/images/blank.gif" />
					</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="8"></td></tr>
				<tr height=3><td colspan=8></td></tr>
					
				<!--主题列表-->
				<tbody class="dataContainer" datakey="topicList">
					<s:iterator value="recordList">
						<tr height="35" id="d0" class="template">
							<td></td>
							<td class="ForumTopicPageDataLine" align="center"><img src="${pageContext.request.contextPath}/style/images/topicType_${type}.gif" /></td>
							<td class="Topic"><s:a cssClass="Default" action="topic_show?id=%{id}&forumId=%{#forum.id}">${title}</s:a></td>
							<td class="ForumTopicPageDataLine">
								<ul class="ForumPageTopicUl">
									<li class="Author">${author.username}</li>
									<li class="CreateTime">${createTime}</li>
								</ul>
							</td>
							<td class="ForumTopicPageDataLine Reply" align="center"><b>${replyCount}</b></td>
							<td class="ForumTopicPageDataLine">
								<ul class="ForumPageTopicUl">
									<li class="Author">${lastReply.author.username}</li>
									<li class="CreateTime">${lastReply.createTime}</li>
								</ul>
							</td>
							<td></td>
						</tr>
					</s:iterator>
					</tbody>
					<!--主题列表结束-->	
						
					<tr height="3"><td colspan="9"></td></tr>
				
			</table>
			<s:hidden name="forumId" value="%{#forum.id}"></s:hidden>
			<!--其他操作-->
			<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						<tr valign=bottom>
							<td></td>
							<td><s:select name="viewType" list="#{0:'全部主题',1:'全部精华贴'}"/>
								<s:select name="orderBy" onchange="change(this.value);"
									list="#{0:'默认排序（按最后更新时间排序，但所有置顶帖都在前面）',1:'按最后更新时间排序',2:'按主题发表时间排序',3:'按回复数量排序'}"/>
								<s:select name="reverse" list="#{false:'降序',true:'升序'}"/>
								<input type="image" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
							</td>
						</tr>
					</table>
				</div>
			</div>
			
		</div>
	</center>
</div>

<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：${currentPage}/${pageCount}页 &nbsp;
		每页显示：${pageSize}条 &nbsp;
		总记录数：${count}条
	</div>
	<div id=PageSelectorSelectorArea>
		<!--
		<IMG SRC="${pageContext.request.contextPath}/style/blue/images/pageSelector/firstPage2.png"/>
		-->
		<a href="javascript:void(0)" title="首页" style="cursor: hand;">
		<img src="${pageContext.request.contextPath}/style/blue/images/pageSelector/firstPage.png"/></a>
		<s:iterator begin="%{beginPageIndex}" end="%{endPageIndex}" var="pageNum">
			<s:if test="%{#pageNum==currentPage}">
				<span class="PageSelectorNum PageSelectorSelected">${pageNum}</span>
			</s:if>
			<s:else>
`				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPage(${pageNum});">${pageNum}</span>
			</s:else>
		</s:iterator>	
		<!--	
		<IMG SRC="${pageContext.request.contextPath}/style/blue/images/pageSelector/lastPage2.png"/>
		-->		
		<s:a action="topic_list.action?forumId=%{#forum.id}&num=%{pageCount}" title="尾页" style="cursor: hand;">
			<img src="${pageContext.request.contextPath}/style/blue/images/pageSelector/lastPage.png"/></s:a>
		
		转到：
		<select name="currentPage" onchange="gotoPage(this.value);">
			<s:iterator begin="1" end="pageCount" var="pNum">
				<option value="${pNum}"   <s:property value="%{#pNum==currentPage?'selected=selected':''}"/>>${pNum}</option>
			</s:iterator>
		 </select>
	</div>
</div>

</s:form>

<div class="Description">
	说明：<br />
	
	1，主题默认按最后更新的时间降序排列。最后更新时间是指主题最后回复的时间，如果没有回复，就是主题发表的时间。<br />
	2，帖子有普通、置顶、精华之分。置顶贴始终显示在最上面，精华贴用不同的图标标示。<br />
</div>

</body>
</html>
