<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head>
  <meta charset="UTF-8">
  <title>구구단</title>
 </head>
<body>
  <c:forEach var="a" begin="2" end="5" step="1">
    <div style="float: left; margin-right: 20px;">
      <c:forEach var="b" begin="1" end="9" step="1">
        <c:out value="${a}"/>*<c:out value="${b}"/>=<c:out value="${ a*b }"/><br>
      </c:forEach>
    </div>
  </c:forEach>
  <div style="clear: both; margin-bottom: 20px;"></div>
  <c:forEach var="a" begin="6" end="9" step="1">
    <div style="float: left; margin-right: 20px;">
      <c:forEach var="b" begin="1" end="9" step="1">
        <c:out value="${a}"/>*<c:out value="${b}"/>=<c:out value="${ a*b }"/><br>
      </c:forEach>
    </div>
  </c:forEach>
</body>
</html>
