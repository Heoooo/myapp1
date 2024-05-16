<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Cook Cookie</title>
</head>
<%
	String cookieName = "myCookie";
	Cookie cookie = new Cookie(cookieName, "Apple");
	cookie.setMaxAge(60);
	cookie.setValue("Melon");
	response.addCookie(cookie);
%>
<body>
<h1>Example Cookie</h1>
쿠키를 만듭니다.<br/>
쿠키 내용은 <a href="tasteCookie.jsp">여기</a>!!
</body>
</html>