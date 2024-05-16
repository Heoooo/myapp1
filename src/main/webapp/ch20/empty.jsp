<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL Empty</h2>
name의 요청 여부 : <b>${empty param.name }</b> (요청이 없다면 true)<br/>
<a href="empty.jsp?name=heo">name값이 있는 요청</a>|| 
<a href="empty.jsp">name값이 없는 요청</a>
</body>
</html>