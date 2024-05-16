<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>JSTL</title>
</head>
<body>
<h2>Functions Tags</h2>
<c:set var="str" value="Heo :: Java JSP Spring Fighting!"/>
<hr width="430" align="left" color="red"/>
str : <b>${str }</b><br/>
length : <b>${fn:length(str) }</b><br/>
substring : <b>${fn:substring(str,0,3) }</b><br/>
substringAfter : <b>${fn:substringAfter(str,"Heo") }</b><br/>
substringBefore : <b>${fn:substringBefore(str,"Java") }</b><br/>
toUpperCase : <b>${fn:toUpperCase(str) }</b><br/>
toLowerCase : <b>${fn:toLowerCase(str) }</b><br/>
replace : <b>${fn:replace(str,"Heo","Kim") }</b><br/>
indexOf : <b>${fn:indexOf(str,"the") }</b><br/>
startsWith : <b>${fn:startsWith(str,"Heo") }</b><br/>
endsWith : <b>${fn:endsWith(str,"Heo") }</b><br/>
contains : <b>${fn:contains(str,"heo") }</b><br/>
containsIgnoreCase : <b>${fn:containsIgnoreCase(str,"heo") }</b><br/>
trim : ***<b>${fn:trim("	Heo!123	  ") }</b>***<br/>
<c:set var="arr" value="${fn:split(str,' ') }" />
join : <b>${fn:join(arr,"&&") }</b><br/>
<hr width="430" align="left" color="blue"/>
</body>
</html>