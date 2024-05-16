<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch1.MemberBean"%>
<jsp:useBean id="bMgr" class="ch1.MemberMgr" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<h2>리스트</h2>
<table border="0" width="100%" cellpadding="2" cellspacing="0">
<tr align="center" bgcolor="#D0D0D0" height="120%">
	<td>아이디</td>
	<td>이름</td>
	<td>권한</td>
	<td>성별</td>
	<td>전화번호</td>
</tr>

<%
	Vector<MemberBean> vlist = bMgr.readDB();
	for(int i=0;i<vlist.size();i++) {
		MemberBean mBean = vlist.get(i);
%>
<tr>
	<td><%=mBean.getId() %></td>
	<td><%=mBean.getName() %></td>
	<td><%=mBean.getLev() %></td>
	<td><%=mBean.getGender() %></td>
	<td><%=mBean.getNum() %></td>
<%
	}
%>
</table>
</body>
</html>