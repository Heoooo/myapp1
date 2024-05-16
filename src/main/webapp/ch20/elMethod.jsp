<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/Functions.tld" %>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL 정적 메소드</h2>
123456789를 1000단위 구분 기호(,)로 표시<p/>
<b>result : ${m:comma(123456789) }</b>
</body>
</html>