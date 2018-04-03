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
<%
	Member member = (Member)session.getAttribute("LOGIN_USER");
	String login = "로그인";
	String loginPath = "login";
	if(member != null){
		login = "로그아웃";
		loginPath = "logout";

	}else {
		
	}

%>


<h2>민경사이트</h2>
<%=member.getMem_name()%>님 방가~~<br>
<a href="<%=request.getContextPath()%>/index.jsp">Home</a>
<a href="#">회원관리</a>
<a href="#">게시판</a>

<!--로그인 상태일경우 변경되는 부분-->
<a href="<%=request.getContextPath()%>Ex12/Ex01_<%=loginPath%>.jsp"><%=login%></a><!--인클루드로 활용하기 때문에 절대 경로를 써주는것이 좋다-->


<!--비 로그인 상태인 경우-->



</body>
</html>