<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>MSG에러페이지</h1>
Ex03_read.jsp에서 난 에러
<hr>
exception에 접근하려면 꼭 페이지디렉토리에  isErrorPage를 처리 해줘야함<br>
에러타입 <%=exception.getClass().getName() %><br>
에러정보 <%=exception.getMessage() %><br>

<%
	application.log("메세지 오류 발생", exception); //톰켓 로그에 기록됨 
%>

</body>
</html>