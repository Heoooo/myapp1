<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("id", "abcd");
	application.setAttribute("name", "heo");
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL Scope2</h2>
<jsp:forward page="scope4.jsp" />
forward 액션태그를 사용해 scope4.jsp 포워드
</body>
</html>