<%@ page import="java.util.List,unitn.webarchitecture.flaggame.resources.Flags, unitn.webarchitecture.flaggame.utils.FlagCollector, java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Flag Game Play</title>
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
		<div style="text-align:left; margin-left:70px; margin-top:20px;">
			<% List <Flags> flags = new FlagCollector().getFlagsCollection(); 
			
				for (int i=0;i<flags.size();i++)
	          {
	
	              out.print(flags.get(i).getNumber() + ". " + flags.get(i).getCountry() + " - " + flags.get(i).getCapital());
	              %>
	              <br>
			<%
	          } %>
		</div>
		
		<div style="text-align:left; margin-left:70px; margin-top:20px;">
		<form action="scoreupdater" method="get">
			<%for (int i=0;i<3;i++)
	          {
				int flagIndex = (int)(Math.random() * flags.size());
				//out.print(flags.get(flagIndex).getNumber() + ". " + flags.get(flagIndex).getCapital());
				session.setAttribute("ans_"+(i+1), flagIndex+1);
	              %>
	              <img style="height:100px; width:auto;" src="http://www.khandakerrahin.com/webarchitecture/bandiereJPG/<%out.print(flags.get(flagIndex).getCountry());%>.jpg">
					<input type="number" id="<%out.print(flags.get(flagIndex).getNumber());%>" name="<%out.print("user_ans_"+(i+1));%>" min="1" max="10" required>
<br><br>
	              
			<%
	          } %>
	          
			   <button style="width: 20%;" type="submit">Submit!</button>
			</form>
		</div>
	</div>
</body>
</html>