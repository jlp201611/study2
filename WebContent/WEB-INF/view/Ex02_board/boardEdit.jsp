<%@page import="com.study.board.model.Board"%>
<%@page import="com.study.board.service.BoardServiceImpl"%>
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
			<h2>게시물 수정</h2>
		</div>
		<%
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));
		BoardServiceImpl boardService = new BoardServiceImpl();
		Board board = boardService.getBoard(bo_no);
		
		request.setAttribute("board", board);
		%>		
		<form action="boardUpdate.jsp?bo_no=${board.bo_no}" method="post">
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
						<td colspan="3"><input name="bo_title" type="text" class="form-control" value="${board.bo_title}"></td>
					</tr>
					<tr>
						<th class="text-center">작성자</th>
						<td><input name="bo_writer" type="text" class="form-control" value="${board.bo_writer}"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th colspan="4">
							<textarea name="bo_content" class="form-control" rows="10" >${board.bo_content }</textarea>
						</th>
					</tr>
				</tbody>	
			</table>
			</div>
			<div class="row">
				<a class="btn btn-default" href="boardList.jsp" role="button">취소</a>
				<button type="submit" class="btn btn-default pull-right" role="button">수정완료</button>
			</div>
		</form>	
	</div>
</body>
</html>