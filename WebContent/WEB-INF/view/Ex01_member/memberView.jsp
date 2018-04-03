<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>


</head>

<body>
	<div class="container">
		<form action="memberDelete.do" method="post">
			<div class="page-header">
				<h2>회원 상세정보</h2>
			</div>
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
							<td>${member.mem_id}<input type="hidden" name="mem_id"
								value="${member.mem_id}">
							</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${member.mem_name}</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${member.mem_phone}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${member.mem_email}</td>
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
				<a class="btn btn-default pull-right"
					href="memberEdit.do?mem_id=${member.mem_id}" role="button">수정</a>
				
				<!-- 모달 버튼 -->	 
				<button type="button" class="btn btn-primary  pull-right" 
				data-toggle="modal" data-target="#myModal">삭제하기</button>
			</div>

		<!-- 모달 팝업 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요</h4>
					</div>
					<div class="modal-body"><input type="password" name="mem_pwd" class="form-control" placeholder="비밀번호" /></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary" >확인</button>
					</div>
				</div>
			</div>
		</div>
		</form>


	</div>
	<div id="bg"></div>
</body>
</html>