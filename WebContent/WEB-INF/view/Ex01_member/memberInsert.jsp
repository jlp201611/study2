
<%@page import="com.study.member.model.Member"%>
<%@page import="com.study.member.service.MemberServiceImpl"%>
<%@page import="oracle.jdbc.driver.OracleDriver"%>
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
		<jsp:useBean id="member" class="com.study.member.model.Member"></jsp:useBean>
		<jsp:setProperty property="*" name="member"/>
		<%	
			MemberServiceImpl memberService = new MemberServiceImpl();
			String mem_id = request.getParameter("mem_id");
		
			int result = memberService.insertMember(member);
			
			if(result > 0){
		%>
	
	
			<script type="text/javascript">
				alert("회원가입 성공하셨습니다");
				location.href="memberView.jsp?mem_id=<%=mem_id%>";
			</script>
					<%
				}else{//업데이트 할것이 없음 //실패
					%>
					<div class="row">
						업데이트 항목이 없습니다.<br>

					</div>
					<%
				}
			%>
	</div><!--컨테이너 종료-->
</body>
</html>