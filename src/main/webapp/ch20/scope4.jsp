<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL Scope2</h2>
id(sessionScope로 받은 값) : <b>${sessionScope.id }</b><p/>
name(applicationScope로 받은 값) : <b>${applicationScope.name }</b><p/>
</body>
</html>