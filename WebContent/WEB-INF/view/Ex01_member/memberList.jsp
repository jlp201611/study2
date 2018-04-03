<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h2>회원 정보</h2>
			<button type="button" class="btn btn-default" aria-label="Left Align">
			  <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
			</button>
		</div>
		<div class="row">
			<a class="btn btn-default pull-right" href="memberForm.do" role="button">회원등록</a>
		</div>		
		<div class="row">
			<table class="table table-striped">
				<colgroup>
					<col width="8%">
					<col width="20%">
					<col width="20%">
					<col width="20%">
					<col width="20%">
					<col width="auto">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
						<th>가입</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${! empty list}">			
						<c:forEach var="uesr" items="${list}" varStatus="st">
							<tr>
								<td>${st.count}</td>
								<td>${uesr.mem_id}</td>
								<td><a href="memberView.do?mem_id=${uesr.mem_id}">${uesr.mem_name}</a></td>
								<td>${uesr.mem_phone}</td>
								<td>${uesr.mem_email}</td>
								<td>${uesr.reg_date}</td>
						</c:forEach>
					</c:if>
					<c:if test="${empty list}">
						<tr><td>데이터가 없습니다</td></tr>
					</c:if>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>