<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL forEach 실습</title>
</head>
<body>
<h3>오늘의 점심 메뉴입니다.</h3>
<ul>
	<c:forEach var="lunch" items="${MENU }">
		<li>${lunch }</li>
	</c:forEach>
</ul>
</body>
</html>