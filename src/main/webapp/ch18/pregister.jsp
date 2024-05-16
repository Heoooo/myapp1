<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)session.getAttribute("msg");
%>
<html>
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>PhotoBlog</title>
<%@include file = "js_css.html" %>
<script type="text/javascript">
function register() {
	document.frm.submit();
}
</script>
</head>
<body>
<div data-role="page">
	<div data-role="header">
	<table>
	<tr>
		<td align="left" width="200">
		<h1 style="font-family:fantasy;" align="left">&nbsp;&nbsp;PhotoBlog</h1>
		</td>
	</tr>
	</table>
	</div>
	<div data-role="content">
	<h1>PMember Register</h1>
	<form method="post" name="frm" action="pmemberPost" enctype="multipart/form-data" class="post_form">
	<p>
		<label for="user_id">아이디:
		<input name="id">
		</label>
	</p>
	<p>
		<label for="user_password">비밀번호:
		<input type="password" name="pwd">
		</label>
	</p>
	<p>
		<label for="user_name">이름:
		<input name="name">
		</label>
	</p>
	<p>
		<label for="user_profile">프로필 사진:
		<input type="file" name="profile">
		</label>
	</p>
	<input type="button" value="회원가입" onclick="register()">
	</form>
	<%if(msg!=null){ %>
	<div align="center"><font color="red"><%=msg %></font></div>
	<%} %>
	</div>
<%@include file="footer.jsp" %>
</div>
</body>
</html>