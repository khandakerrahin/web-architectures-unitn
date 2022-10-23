<%@ page import="java.util.Map, unitn.webarchitecture.flaggame.utils.FlagGameServletContextListener,java.util.List,unitn.webarchitecture.flaggame.resources.Player, unitn.webarchitecture.flaggame.utils.FlagCollector, java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Flag Game Admin</title>
	<link rel="icon" href="data:image/svg+xml,<svg xmlns=%22http://www.w3.org/2000/svg%22 viewBox=%220 0 100 100%22><text y=%22.9em%22 font-size=%2290%22>🏳️</text></svg>">
	<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 50%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
	</style>
</head>
<body>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}

	if(session.getAttribute("isAdmin")=="0"){
		response.sendRedirect("401.jsp");
	}
%>
<jsp:include page="WEB-INF/includes/Header.jsp"/>
	<div align ="center">
		<div style="text-align:left; margin-left:70px; margin-top:20px;">
		<h2>Active Players Table</h2>

		<table>
		  <tr>
		    <th>Name</th>
		    <th>Score</th>
		  </tr>
		  
  
			<% try{
				Map <String, Player> players = FlagGameServletContextListener.pdb.getPlayerDB(); 
				for (Map.Entry<String, Player> entry : players.entrySet()) {
		
						%><tr><td><%out.println(entry.getKey());%></td>
						<td><% out.println(entry.getValue().getScore());%></td></tr><%
		              
		          } 
				} catch(Exception e){
					out.println("<tr><td>-</td><td>-</td></tr>");
	          }%>
	          	
  
			</table>
		</div>
		<form action="logout">
		   <button type="submit" style="position:fixed; right:30px; top:30px;">Logout</button>
		</form>
</div>
</body>
</html>