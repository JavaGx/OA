	<frameset border="1" rows="100px,*,20px">
		<frame noresize="noresize" name="top" scrolling="no" src="${pageContext.request.contextPath}/client_top.action"/>
		<frameset cols="180,*">
			<frame noresize="noresize" name="left" scrolling="no" src="${pageContext.request.contextPath}/client_left.action"/>
			<frame noresize="noresize" scrolling="yes" src="${pageContext.request.contextPath}/client_right.action" name="right"/>
		</frameset>
		<frame noresize="noresize" name="bottom" scrolling="no" src="${pageContext.request.contextPath}/client_bottom.action"/>
	</frameset>
