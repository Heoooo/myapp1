<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("msg", "꿈은 이루어 진다.");
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL Scope1</h2>
msg(pageScope로 받은 값) : <b>${pageScope.msg }</b><p/>
1에서 10까지 합(request로 받은 값) : <b><%=request.getAttribute("sum") %></b><p/>
1에서 10까지 합(requestScope로 받은 값) : <b>${requestScope.sum }</b>
</body>
</html>