<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mMgr" class="ch14.MemberMgr" />
<jsp:useBean id="mBean" class="ch14.MemberBean" />
<jsp:setProperty name="mBean" property="*" />
<%
	boolean result = mMgr.updateMember(mBean);
	if(result) {
%>
<script type="text/javascript">
alert("회원정보 수정 하였습니다.");
location.href="../main.jsp";
</script>
<%	}else{ %>
<script type="text/javascript">
alert("회원정보 수정에 실패 하였습니다.");
history.back();
</script>
<%	}%>