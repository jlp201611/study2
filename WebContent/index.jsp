<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/error/msgError.jsp" %>    
<% 
	request.setCharacterEncoding("utf-8");
/* 	String ctxPath =request.getContextPath(); */

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <script type="text/javascript" src="<%ctxPath%>/js/script.js"></script> --%>
<title>2018.03.15</title>
<style type="text/css">
	body, html {
		width:100%; height:100%;
		}
	div:last-child {
		clear:both;
		}
</style>
</head>
<body style="width:100%; height:100%; ">
	<div>
	
		<!--해더 start-->
		<jsp:include page="include/top_ssam.jsp" flush="false"/>
		<!--해더 end-->
	</div>
	
	<div style="width:30%; float:left ">
		<!--좌측메뉴 start-->
		<jsp:include page="include/left.jsp" flush="false"/>
		<!--좌 end-->
	</div>
	
	<div style="width:70%; float:left ">
		<!--본문 start-->
		HATENAKI 사이트
		<!--본문 end-->
	</div>
	
	<div>
		<!--풋터 start-->
		<jsp:include page="include/footer.jsp" flush="false"/>
		<!--풋터 end-->
	</div>
</body>
</html>