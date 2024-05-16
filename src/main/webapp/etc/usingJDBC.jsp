<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"%>
<%@ page import="java.util.*,ch11.*" %>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id="", pwd="", name="", num1="", num2="", email="", phone="", zipcode="", address="", job="";
	int counter = 0;
	try {
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=true&requireSSL=true&serverTimezone=Asia/Seoul";
        conn = DriverManager.getConnection(url, "root", "9290");
        
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT * FROM tblRegister");
%>
<html>
<head>
<title>JSP에서 DB연동</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
<h2>JSP 스크립트릿에서 DB연동 예제</h2><br/>
<h3>회원정보</h3>
<table bordercolor="#0000ff" border="1">
	<tr>
		<td><strong>ID</strong></td>
		<td><strong>PWD</strong></td>
		<td><strong>NAME</strong></td>
		<td><strong>NUM1</strong></td>
		<td><strong>NUM2</strong></td>
		<td><strong>EMAIL</strong></td>
		<td><strong>PHONE</strong></td>
		<td><strong>ZIPCODE / ADDRESS</strong></td>
		<td><strong>JOB</strong></td>
	</tr>
	<%
		if(rs!=null) {
			while(rs.next()) {
				id=rs.getString("id");
				pwd=rs.getString("pwd");
				name=rs.getString("name");
				num1=rs.getString("num1");
				num2=rs.getString("num2");
				email=rs.getString("email");
				phone=rs.getString("phone");
				zipcode=rs.getString("zipcode");
				address=rs.getString("address");
				job=rs.getString("job");
	%>
	<tr>
		<td><%=id %></td>
		<td><%=pwd %></td>
		<td><%=name %></td>
		<td><%=num1 %></td>
		<td><%=num2 %></td>
		<td><%=email %></td>
		<td><%=phone %></td>
		<td><%=zipcode %>/<%=address %></td>
		<td><%=job %></td>
		<%
				counter ++;
			}
		}
		%>
	</tr>
</table>
<br/>
total records : <%=counter %>
<%
	} catch (SQLException sqlException) {
		System.out.println("sql exception");
	} catch (Exception exception) {
		System.out.println("exception");
	} finally {
		if (rs !=null)
			try {rs.close();}
			catch (SQLException ex) {}
		if (stmt !=null)
			try {stmt.close();}
			catch (SQLException ex) {}
		if (conn !=null)
			try {conn.close();}
			catch (Exception ex) {}
		
	}
%>
</body>
</html>            