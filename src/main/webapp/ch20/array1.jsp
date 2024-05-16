<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String studyArr[] = {"java", "jsp", "android", "spring"};
	pageContext.setAttribute("study",studyArr);
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL Array1</h2>
<b>Java Program 과목</b><hr width="150" align="left" />
1. ${study[0] }<br/>
2. ${study[1] }<br/>
3. ${study[2] }<br/>
4. ${study[3] }<br/>
</body>
</html>