<%@ page import="RestServices.RestConnector" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/style0.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/buttons.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	<title>Board</title>
	<style type="text/css">
		#devName{	
			position: relative;
			font-size: 40px;
			float: left;
		}
		.back {
			position : absolute;
			margin: auto;
			top: 10px;
			left :25px;
			width: 50px;
			height: 50px;
			border-radius: 30px;
			border : 0px;
			background-color: none;
		}
		.back:hover{
			background-color: #c5c5c5;
		}
		.back span {
			position: absolute;
			margin: auto;
			font-size: 50px;
			top:-1px;
			left:13px;
		}
	</style>
</head>
<%@ page import="java.net.URI, 
javax.ws.rs.client.Client , 
javax.ws.rs.client.ClientBuilder , 
javax.ws.rs.client.WebTarget , 
javax.ws.rs.core.MediaType , 
javax.ws.rs.core.Response ,
javax.ws.rs.core.UriBuilder , 
org.glassfish.jersey.client.ClientConfig ,org.json.simple.parser.*,org.json.simple.*" %>
<body>
 <% JSONParser parser = new JSONParser(); 
 JSONObject obj = (JSONObject)parser.parse(session.getAttribute("user").toString()); 
%>

	<div id="upper" style="background-color: #e6e6e6;">
		<a href="Home.jsp"><button class="back"><span class="fa fa-angle-left"></span></button></a>
		<label style="position:absolute; right: 20px;" id="right">Board No.1</label>
	</div>
	<div class="inter">
 		<form action="">
 		<div class="board" id="left">
			<button class="close" id="la"><span class="fa fa-close"></span></button>
			<label id="left" style="max-width : 200px; ">Device Name :   </label>
		<a href="Board.jsp"><button class="view" id="right"><span class="fa fa-arrows-alt"></span></button></a>	
		</div> 
		</form>
		<form method="post">
			<div class="addboard">
				<button id="myBtn" onclick="popup()" type="button" class="fill" style=" margin: 20%; margin-left: 28%; width: auto;"> Add Device </button>
			</div>
		</form>
		<label style="margin: 10px 20px; position: absolute; color: #165258;">DELETE</label>
		<label style="margin: 25px 20px; position: absolute; color: #165258;">DEVICE</label>
		<label class="switch">
  			<input onclick="fn3()" type="checkbox">
  			<div class="slider round"></div>
		</label>
	</div>
	<form action="AddBoard.jsp">
	<div id="myModal" class="popup">
  			<div class="popup-content">
				<span class="closebtn fa fa-close"></span>
				<h1>Add Device</h1>
				<input type="radio" name="device" value ="Samsung TV"><label id="devName">Samsung Smart TV</label> <br>
    			<input type="radio" name="device" value ="Samsung TV"><label id="devName">Dell Laptop</label> <br>
    			<button type="submit" class="fill">Confirm</button>
  			</div>
	</div>
</form>
</body>
</html>