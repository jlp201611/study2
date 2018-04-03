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
	<!-- include summernote css/js -->
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>	

</head>
<body>
<div class="container">
		<div class="page-header">
			<h2>게시물 등록</h2>
		</div>
		<form action="boardInsert.jsp" method="post">
			<div class="row">

			<table class="table table-striped">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">제목</th>
						<td><input name="bo_title" type="text" class="form-control" placeholder="제목을 입력해주세요"></td>
					</tr>
					<tr>
						<th class="text-center">작성자</th>
						<td><input name="bo_writer" type="text" class="form-control" placeholder="작성자를 입력해주세요"></td>					
					</tr>
					<tr>			
						<th class="text-center">비밀번호</th>
						<td><input name="bo_passwd" type="password" class="form-control" id="exampleInputPassword1" placeholder="암호를 입력해 주세요"></td>
					</tr>
					<tr>
						<th class="text-center">이메일</th>
						<td><input name="bo_email" type="text" class="form-control" id="exampleInputEmail1" placeholder="이메일을 입력하세요"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th colspan="4">
							  <div id="summernote"></div>
							  <script>
							    $(document).ready(function() {
							        $('#summernote').summernote({
							            placeholder: 'Hello bootstrap 4',
							            tabsize: 2,
							            height: 300
							          });
							        
							    });
							  </script>
						</th>
					</tr>
				</tbody>	
			</table>
			</div>
			<div class="row">
				<a class="btn btn-default" href="boardList.jsp" role="button">취소</a>
				<button type="submit" class="btn btn-default pull-right" role="button">저장</button>
			</div>
		</form>	
	</div>
</body>
</html>