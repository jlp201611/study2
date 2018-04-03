<%@page import="com.study.member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // post는 무조건 해야지 한글이 깨지지 않음 / get방식은 서버마다 조건이 달름
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>민경사이트</h2>
<a href="<%=request.getContextPath()%>/index.jsp">Home</a>
<a href="<%=request.getContextPath()%>/Ex01_member/memberList.do">회원관리</a>
<a href="<%=request.getContextPath()%>/Ex02_board/boardList.do">게시판</a>
<%
	Member member = (Member)session.getAttribute("LOGIN_USER");
	if(member != null){
		%>
		<!--로그인 상태인 경우-->
		<a href="<%=request.getContextPath()%>/Ex12/Ex01_logout.jsp">로그아웃</a><br>
		<%=member.getMem_name()%>님 방가~~
		<%
	}else{
		%>
		<!--로그아웃 상태인 경우-->
		<a href="<%=request.getContextPath()%>/Ex12/Ex01_login.jsp">로그인</a>
		<%
	}
%>

</body>
</html>