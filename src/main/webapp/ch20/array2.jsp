<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<String> nameList = new ArrayList<String>();
	String nameArr[] = {"kang","lee","park","choi"};
	for(int i=0;i<nameArr.length;i++) {
		nameList.add(nameArr[i]);
	}
	pageContext.setAttribute("Name",nameList);
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL Array</h2>
<b>Name List</b><hr width="135" align="left" />
1. ${Name[0] }<br/>
2. ${Name[1] }<br/>
3. ${Name[2] }<br/>
4. ${Name[3] }<br/>
</body>
</html>