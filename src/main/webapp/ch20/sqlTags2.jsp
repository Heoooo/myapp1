<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
<title>JSTL</title>
</head>
<body>
<h2>SQL Tags2</h2>
<sql:update dataSource="${db }">
	update tblpmember set name=? where id=?
	<sql:param value="${'Jsp' }"/>
	<sql:param value="${'a100' }"/>
</sql:update>
업데이트를 하였습니다.<br/>
<a href="sqlTags1.jsp">SELECT</a>
</body>
</html>