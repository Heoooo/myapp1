<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<%
	request.setAttribute("name","Heo");
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL 기본문법</h2>
이름 : <b>${name }</b>
</body>
</html>