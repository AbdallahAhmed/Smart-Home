<%@ page import="RestServices.RestConnector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.net.URI, 
javax.ws.rs.client.Client , 
javax.ws.rs.client.ClientBuilder , 
javax.ws.rs.client.WebTarget , 
javax.ws.rs.core.MediaType , 
javax.ws.rs.core.Response ,
javax.ws.rs.core.UriBuilder , 
org.glassfish.jersey.client.ClientConfig ,org.json.simple.parser.*,org.json.simple.*"%>
<!DOCTYPE html >
<html>
<head>
<link rel="shortcut icon" href="icons/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style_device.css">
<link rel="stylesheet" type="text/css"
	href="css/font-awesome-4.7.0/css/font-awesome.css">
<link href="https://fonts.googleapis.com/css?family=Righteous"
	rel="stylesheet">
<link rel="stylesheet" href="css/animate.css">
<!-- 	<link rel="stylesheet" href="css/buttons.css"> -->
<script type="text/javascript" src="js/device.js"></script>
<title>Device</title>
</head>

<body onload="construct()">
	<%
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(session.getAttribute("user").toString());
	%>

	<div id="upper">
		<a href="Board.jsp"><button class="back">
				<span class="fa fa-angle-left"></span>
			</button></a> <label style="" id="devName">Device Name</label>
	</div>
	<div class="inter">
		<form action="">
			<input type="color" name="mainColor" id="color">
			<button onclick="ch()" type="submit">Confirm</button>
		</form>
		<div id="dev">
			<form action="">
				<div class="operation">
					<label>ON/OFF</label> <input onclick="updateSwitch(this)"
						type="button" class="fill" id="statusbtn" value="OFF">
					<button id="lamp"></button>
				</div>
			</form>
			<%
				RestConnector rc = new RestConnector("ViewDevice", "GET");
				String[] x = { "50" };
				rc.addParamGet(x);
				JSONObject obj1 = rc.getJSONObject();
				JSONArray arr = (JSONArray) obj1.get("operations");
				String s = "";
				for (int i = 0; i < arr.size(); i++) {
					out.print(arr.get(i));
					System.out.print(arr.get(i));
				}
			%>
			<form>
				<div class="operation">
					<label>Volume</label> <input type="range" step="2" value="50"
						min="0" max="100" onchange="updateChosen(this)">
					<div id="chosen">50</div>
				</div>
			</form>
			<div class="operation">
				<label>Mode :
					<div id="chosenMode">Mode 1</div>
				</label>
				<form action="">
					<select name="mode" id="mode">
						<option value="mode1">Mode 1</option>
						<option value="mode2">Mode 2</option>
						<option value="mode3">Mode 3</option>
						<option value="mode4">Mode 4</option>
					</select> <br>
					<br> <input type="button" value="Submit"
						onclick="updateMode()">
				</form>

			</div>
		</div>
		<div id="light"></div>
	</div>
</body>
</html>