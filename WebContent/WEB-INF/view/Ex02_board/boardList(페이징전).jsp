<%@page import="com.study.board.model.Board"%>
<%@page import="java.util.List"%>
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
		<%
			BoardServiceImpl boardService = new BoardServiceImpl();
			List<Board> list = boardService.getBoardList();
			request.setAttribute("boardList", list);
		%>
		<div class="page-header">
			<h1 style="margin-top:50px;"> 게시판 리스트</h1>
		</div>
	
		<div class="row">
			<table class="table table-striped" style="margin-top:20px;">
				<colgroup>
					<col width="5%" >	<!--넘버-->
					<col width="auto">	<!--제목-->
					<col width="10%">	<!--작성자-->
					<col width="20%">	<!--만든날짜-->
					<col width="8%">	<!--조회수-->
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th>제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">작성일</th>
						<th class="text-center">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${! empty boardList}">
						<c:forEach var="list" items="${ boardList}" varStatus="st">
						<tr>
							<td class="text-center">${list.bo_no}</td>				
							<td><a href="boardView.jsp?bo_no=${list.bo_no}">${list.bo_title}</a></td>				
							<td class="text-center">${list.bo_writer}</td>				
							<td class="text-center">${list.bo_reg_date}</td>				
							<td class="text-center">${list.bo_read_cnt}</td>				
						</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty boardList}">
						<tr><td>데이터가 없습니다</td></tr>
					</c:if>
				
				
				</tbody>
			
			</table>
		</div>
		<div class="row">
			<a class="btn btn-default pull-right" href="boardForm.jsp" role="button">글쓰기</a>
		</div>		
	</div>
</body>
</html>