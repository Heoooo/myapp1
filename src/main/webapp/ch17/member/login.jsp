<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("idKey");
%>
<html>
<head>
<title>로그인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function loginCheck() {
	if(document.loginFrm.id.value=="") {
		alert("아이디를 입력해주세요.");
		document.loginFrm.id.focus();
		return;
	}
	if(document.loginFrm.pwd.value=="") {
		alert("비밀번호를 입력해주세요.");
		document.loginFrm.pwd.focus();
		return;
	}
	document.loginFrm.submit();
}
</script>
</head>
<body bgcolor="#ffffcc">
<div align="center"><br/><br/>
<%
	if(id!=null) {
%>
<b><%=id %></b>님 환영합니다.
<p>제한된 기능을 사용할 수 있습니다.<p/>
<a href="logout.jsp">로그아웃</a>
<%
	}else {
%>
<form name="loginFrm" method="post" action="loginProc.jsp">
<table>
<tr>
	<td align="center" colspan="2"><h4>로그인</h4></td>
</tr>
<tr>
	<td>아이디</td>
	<td><input name="id"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pwd"></td>
</tr>
<tr>
	<td colspan="2">
	<div align="right">
	<input type="button" value="로그인" onclick="loginCheck()">&nbsp;
	<input type="button" value="회원가입" onClick="javascript:location.href='member.jsp'">
	</div>
	</td>
</tr>
</table>
</form>
<%
	}
%>
</div>
</body>
</html>