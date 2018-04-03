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
	<jsp:useBean id="board" class="com.study.board.model.Board"></jsp:useBean>
	<jsp:setProperty property="*" name="board"/>
		<%
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));
		board.setBo_no(bo_no);
		BoardServiceImpl boardService = new BoardServiceImpl();
		int result = boardService.modifyBoard(board);
		
		
		request.setAttribute("result", result);
		%>
		<c:if test="${result > 0}">
			<script type="text/javascript">
				alert("수정완료되었습니다.");
				location.href="boardView.jsp?bo_no=${board.bo_no}";
			</script>
		</c:if>
		<c:if test="${result <= 0}">
			없네요ㅋㅋㅋ
		</c:if>					
	</div>
</body>
</html>