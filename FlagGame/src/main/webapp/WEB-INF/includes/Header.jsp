<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Flag Game</title>
	<style>
		button {
		  background-color: #04AA6D;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  cursor: pointer;
		  width: auto;
		}
		
		button:hover {
		  opacity: 0.8;
		}
	</style>
</head>
<body>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}
%>
	<div align ="center">
		<h1>Flag Game!🏴󠁩󠁤󠁪󠁷󠁿🏳️🚩</h1>
		<div style="height: 130px; width: 100%;  background-color: powderblue;">
			<p style="margin-top:30px; text-align:center; font-family: Papyrus, fantasy; font-size: 100px; font-style: normal; font-variant: normal; font-weight: 700;">${username}</p>
		</div>
	</div>
	<form action="logout">
	   <button type="submit" style="position:fixed; right:30px; top:30px;">Logout</button>
	</form>
</body>
</html>