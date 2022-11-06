<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script language="JavaScript" type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 70%;
	  margin: 20px auto;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	td.active {
        border: 2px solid #02cb02;
	    border-style:double;
	}

	th {
	  background-color: #dddddd;
	  text-align: left;
	}

	tr, col {
	  transition: all .3s;
	}
	tr:hover {
	  background-color: rgba(0,140,203,.2);
	}
	col.hover {
	  background-color: rgba(0,140,203,.2);
	}
	
	.input-container {
	  display: -ms-flexbox; /* IE10 */
	  display: flex;
	  width: 100%;
	  margin-bottom: 15px;
	}
	
	.icon {
	  padding: 10px;
	  color: white;
	  width: 30px;
	  text-align: center;
	}
	
	.input-field {
	  width: 50%;
	  padding: 10px;
	  outline: none;
	}
	
	.input-field:focus {
	  border: 2px solid dodgerblue;
	}

</style>

</head>
<body>

<h2 style="padding:100px; margin-bottom:-100px;">Simple Spreadsheet</h2>

<div style="padding:100px;">
	<form style="margin-left:250px;" action="javascript:handleInput()">
	  <div class="input-container">
	    <input style="width: 40px; border: 1px solid #dddddd;" class="input-field" type="text" placeholder="Cell" id="cell" name="cell" value="A1" readonly>
	    <img class="fa fa-user icon" src="/SimpleSpreadsheet/resources/formula.png">
	    <input class="input-field" type="text" placeholder="Formula" id="formula" name="formula" oninput="formulaFunction()">
	    <input style="visibility: hidden;" type="submit" value="Submit">
	  </div>
	</form>
	<table>
		<col />
		<col />
		<col />
		<col />
		<col />
	  <thead>
		  <tr>
		  	<th> </th>
		    <th>A</th>
		    <th>B</th>
		    <th>C</th>
		    <th>D</th>
		  </tr>
	  </thead>
	  <tbody>
		  <tr>
		  	<th style="background-color: #dddddd; width: 27px;">1</th>
		    <td id="A1" class="active"></td>
		    <td id="B1"></td>
		    <td id="C1"></td>
		    <td id="D1"></td>
		  </tr>
		  <tr>
		    <th style="background-color: #dddddd; width: 27px;">2</th>
		    <td id="A2"></td>
		    <td id="B2"></td>
		    <td id="C2"></td>
		    <td id="D2"></td>
		  </tr>
		  <tr>
		    <th style="background-color: #dddddd; width: 27px;">3</th>
		    <td id="A3"></td>
		    <td id="B3"></td>
		    <td id="C3"></td>
		    <td id="D3"></td>
		  </tr>
		  <tr>
		    <th style="background-color: #dddddd; width: 27px;">4</th>
		    <td id="A4"></td>
		    <td id="B4"></td>
		    <td id="C4"></td>
		    <td id="D4"></td>
		  </tr>
	  </tbody>
	</table>
	
<script>

	$('td').hover(function() {
	 $(this).parents('table').find('col:eq('+$(this).index()+')').toggleClass('hover');
	});
	
	$('table').on('click', 'td', function(e) {
	  var target = $(e.currentTarget);

	  if (e.ctrlKey && target.hasClass('active')) {
	    target.removeClass('active');
	  } else if (e.ctrlKey) {
	    target.addClass('active');
	  } else {
	    $('table td.active').removeClass('active');
	    target.addClass('active');
	  }
	  
	  document.getElementById("formula").value = target.text();
	  document.getElementById("cell").value = this.id;
	  document.getElementById("formula").focus();
	});
	
	function formulaFunction() {
	  var x = document.getElementById("formula").value;
	  $(document.getElementsByClassName("active"))[0].innerHTML = x;
	}
	
	function handleInput(){
		var theUrl = "http://localhost:8080/SimpleSpreadsheet/processor?"
				+ "id="+encodeURIComponent(document.getElementById("cell").value)
				+ "&formula="+encodeURIComponent(document.getElementById("formula").value)
				+ "&action="+encodeURIComponent("modifycell");
	    //console.log(theUrl);
	    var xmlHttp = new XMLHttpRequest();
	    xmlHttp.onreadystatechange = function() { 
	        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
	            callback(xmlHttp.responseText);
	    }
	    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
	    xmlHttp.send(null);
		
	}
	
	function callback(resp){
		//console.log("Server Response:" + resp);
		const res = JSON.parse(resp);
		
		// iterating through the response JSON
		Object.keys(res).forEach(function(key) {
		  console.log('Key : ' + key + ', Value : ' + res[key]);
		  document.getElementById(key).innerHTML = res[key];
		})
	}
</script>
</div>

</body>
</html>