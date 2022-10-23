<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <title>401 Unauthorized</title>
  <style>
    <!--
    BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;font-size:12px;}
    H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;}
    PRE, TT {border: 1px dotted #525D76}
    A {color : black;}A.name {color : black;}
    -->
  </style>
 </head>
 <body>
 <jsp:include page="WEB-INF/includes/Header.jsp"/>
   <h1>401 Unauthorized</h1>
   <p>
    You are not authorized to view this page. If you have not changed
    any configuration files, please examine the file
    file will contain the credentials to let you use this webapp.
   </p>
   
   <form action="logout">
	   <button type="submit">Go Home</button>
	</form>
 </body>

</html>