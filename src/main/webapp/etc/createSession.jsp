<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>세션 사용 예제(세션 생성)</title>
</head>
<body>
<%
	String id = "heo";
	String pwd = "9290";
	
	session.setAttribute("idKey", id);
	session.setAttribute("pwdKey",pwd);
%>
세션이 생성되었습니다.<br/>
<a href="viewSeesionInfo.jsp">세션정보를 확인하는 페이지</a>
</body>
</html>