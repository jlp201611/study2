<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/index.jsp</title>
</head>
<body>
<h2>MinGyeong 사이트에 오신걸 환영합니다</h2>
index / indexm / default ->은 파일이름을 적지 않아도 경로만 맞으면 자동으로 실행이됨


<p>
<%= request.getParameter("moon") %>
</p>

<hr>
2018.03.07 추가부분<br>
<%
	//현재 속성에 저장된 lastUser를 출력
	String lastUser = (String)application.getAttribute("key");
	if(lastUser != null) {
	%>
	마지막 접속자 IP : <%=lastUser%>
	<%	
	}else {
	%>
	마지막 접속자가 없습니다.
	<%
	}

%>



</body>
</html>