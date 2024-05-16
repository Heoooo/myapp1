<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource
	url="jdbc:mysql://localhost:3306/mydb?useSSL=false&requireSSL=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8"
	driver="com.mysql.cj.jdbc.Driver" user="root" password="9290" var="db"
	scope="application" />
<html>
<head>
<title>JSTL</title>
</head>
<body>
<h2>SQL Tags1</h2>
<sql:query var="lists" dataSource="${db }">
	select id, name from tblpmember
</sql:query>

<c:forEach var="member" items="${lists.rows }">
	${member }<br/>
</c:forEach>
</body>
</html>