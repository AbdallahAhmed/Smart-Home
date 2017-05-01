<%@ page import="RestServices.RestConnector" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.net.URI, 
javax.ws.rs.client.Client , 
javax.ws.rs.client.ClientBuilder , 
javax.ws.rs.client.WebTarget , 
javax.ws.rs.core.MediaType , 
javax.ws.rs.core.Response ,
javax.ws.rs.core.UriBuilder , 
org.glassfish.jersey.client.ClientConfig ,org.json.simple.parser.*,org.json.simple.*" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <link rel="stylesheet" href="css/style_device.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
	<link rel="stylesheet" href="css/animate.css">
<!-- 	<link rel="stylesheet" href="css/buttons.css"> -->
	<script type="text/javascript" src="js/device.js"></script>
	<title>Device</title>
</head>

<body>
 <% JSONParser parser = new JSONParser(); 
 JSONObject obj = (JSONObject)parser.parse(session.getAttribute("user").toString()); 
%>

	<div id="upper">
		<a href="Board.jsp"><button class="back"><span class="fa fa-angle-left"></span></button></a>
		<label style="" id="">Device Name</label>
	</div>
	<div class="inter">
		
 		<div id="dev">
 			<div class="operation">
 				<label>ON/OFF</label>
 				<input onclick="updateSwitch(this)" type="button" class="fill" value="OFF">
 				<button id="lamp"></button>
 			 </div>
 			<div class="operation">
 				<label>Volume</label>
 				<input type="range" step="2" value="50" min="0" max="100" onchange="updateChosen(this)"/>
 				<div id="chosen">50</div>
 			</div>
 			<div class="operation"></div>
 		</div>
 		<div id="light"></div>
 	</div> 
</body>
</html>