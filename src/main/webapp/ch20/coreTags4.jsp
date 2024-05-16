<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>JSTL</title>
</head>
<body>
<h2>Core Tags4</h2>
<hr width="150" align="left" />
<c:import url="http://localhost/myapp1/ch20/coreTags2.jsp">
	<c:param name="id" value="Heo" />
	<c:param name="color" value="orange" />
</c:import>
<hr width="360" align="left" />
<c:url var="url1" value="http://www.google.co.kr/">
	<c:param name="q" value="Heo" />
	<c:param name="safe" value="off" />
</c:url>
<a href="${url1 }">구글에서 Heo 검색</a>
</body>
</html>