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
			<h1 style="margin-top:50px;"> 게시판 리스트</h1>
		</div>
		
		
		
		<div class="row">
		<!--검색-->
			<form action="boardList.do" method="post">
				<div class="form-group">
					검색구분 : 
					<select class="form-control" name ="searchType">
						<option value="all">전체</option>
						<option value="bo_title">제목</option>
						<option value="bo_writer">작성자</option>
						<option value="bo_content">내용</option>
					</select>
					<input name="searchWord" value="${search.searchWord}">
					<button type="button">검색</button>
				</div>
		
			</form>
		
		</div>		
		
		
		
		전체 게시물 : ${search.totalRowCount} / 페이지수 : ${search.totalPageCount}
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
						<c:forEach var="list" items="${boardList}" varStatus="st">
						<tr>
							<td class="text-center">${list.bo_no}</td>				
							<td><a href="boardView.do?bo_no=${list.bo_no}">${list.bo_title}</a></td>				
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
			<div>
			<ul class="pagination">
					<c:if test="${search.startPage > 1}">
					    <li><a href="boardList.do?currentPage=${search.startPage -1 }" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>						
					</c:if>

			    		
				<c:forEach var="i" begin="${search.startPage}" end="${search.endPage }" varStatus="st">
				
					<c:if test="${i eq search.currentPage}">
						<li class="active"><a >${i}</a></li>
					</c:if>
					<c:if test="${i ne search.currentPage}">
						<li ><a href="boardList.do?currentPage=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
			
					<c:if test="${search.endPage < search.totalPageCount}">
					    <li><a href="boardList.do?currentPage=${search.endPage + 1 }" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>						
					</c:if>					
			</ul>
			</div>
			<a class="btn btn-default pull-right" href="boardForm.do" role="button">글쓰기</a>
		</div>		
	</div>
</body>
</html>