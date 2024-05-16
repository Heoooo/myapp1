<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>JSTL</title>
</head>
<body>
<h2>Core Tags6</h2>
<c:catch var="ex">
<%
	int arr[] = {1,2,3};
	int sum = arr[0] + arr[1] + arr[2] + arr[3];
%>
</c:catch>
${ex }
</body>
</html>