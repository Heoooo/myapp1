<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strTitle = "JSP Home";
	String cPath = request.getContextPath();
%>
<html>
<head>
<title><%=strTitle %></title>
</head>
<frameset frameborder="0" framespacing="0" border="0" rows="130,*">
	<frame frameborder="0" scrolling="NO" resize="NO" name="head" src="<%=cPath %>/ch17/head.jsp">
	<frameset name="body" frameborder="0" framespacing="0" border="0" rows="*,20">
		<frameset name="main" frameborder="0" framespacing="0" border="0" cols="240,*">
			<frame name="left" marginwidth="0" marginheight="0" frameborder="0" scrolling="NO" resize="NO" src="<%=cPath %>/ch17/left.jsp">
			<frame name="content" src="<%=cPath %>/ch17/main.jsp" scrolling="YES" marginwidth="0" marginheight="0" frameborder="0" noresize>
		</frameset>
		<frame name="copy" src="<%=cPath %>/ch17/copy.jsp" scrolling="NO" marginwidth="0" marginheight="0" frameborder="0" noresize>
	</frameset>
</frameset>
</html>