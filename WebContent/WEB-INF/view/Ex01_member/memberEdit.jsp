<%@page import="com.study.member.model.Member"%>
<%@page import="com.study.member.service.MemberServiceImpl"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title>title</title>
	
	<!-- 부트스트랩 -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</head>

<body>
	<div class="container">
		<div class="page-header">
			<h2>회원 정보수정</h2>
		</div>
		<form action="memberUpdate.do" method="post">
			<div class="row">

			<table class="table table-striped">
				<c:if test="${empty member}">
					<tr>
						<th>해당회원이 없습니다</th>
					</tr>
				</c:if>			
				<c:if test="${! empty member}">
					<tr>
						<th>ID</th>
						<td>${member.mem_id}
							<input type="hidden" name ="mem_id" value="${member.mem_id}" >
							<!--페러미터로 넘겨줘야 하기 때문에 input을 사용하지만 -->
							<!--기본키는 반드시 페러미터로 넘겨줘야함-->
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="mem_name" value="${member.mem_name}" /></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="mem_phone" value="${member.mem_phone}"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="mem_email" value="${member.mem_email}"></td>
					</tr>
					<tr>
						<th>가입</th>
						<td>${member.reg_date}</td>
					</tr>
				</c:if>

			</table>
			</div>
			<div class="row">
					<a class="btn btn-default" href="memberList.do" role="button">목록으로</a>
					<button type="submit" class="btn btn-default pull-right" role="button">저장</button>
			</div>
		</form>	
	</div>		
</body>
</html>