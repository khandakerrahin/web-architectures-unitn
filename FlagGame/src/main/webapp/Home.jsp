<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Flag Game Login</title>
	<link rel="icon" href="data:image/svg+xml,<svg xmlns=%22http://www.w3.org/2000/svg%22 viewBox=%220 0 100 100%22><text y=%22.9em%22 font-size=%2290%22>🏳️</text></svg>">
</head>
<body>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}
	if(session.getAttribute("isAdmin")!="0"){
		response.sendRedirect("Login.jsp");
	}
%>
<jsp:include page="WEB-INF/includes/Header.jsp"/>
	<div align ="center">
		<div>
			<p style="font-size:35px;">Your score is : ${score}</p>
			
			<form action="gamepage">
			   <button type="submit"><strong>Play!</strong></button>
			</form>
		</div>
	</div>
</body>
</html>