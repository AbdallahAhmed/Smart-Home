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
	<title>Home</title>
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
		<div class="port">
			<img src="http://i.imgur.com/WpmTCcz.png" id="left">
		</div>
		<span class="fa fa-cog dropbtn" style="font-size: 35px; color: #165258; padding: 15px;"  id="right">
			<div class="dropdown">
 		 		<div class="dropdown-content">
    				<a href="#">Link 1</a>	
		    		<a href="#">Link 2</a>
    				<a href="#">Link 3</a>
  				</div>
			</div>
		</span>
		<span class="fa fa-bell" style="font-size: 35px; color: #165258; padding: 15px; cursor: pointer;" id="right"></span>
		<button class="profile" style="background-color: #165258; margin-left: 50px; color: #00ddf2" id="right"> Profile</button>
		<label class="" id="right"><% out.print(obj.get("name")); %></label>
	</div>
	<div class="inter">
	<%
	JSONArray brds = (JSONArray)obj.get("boards");
	 

 	    for(int i = 0; i < brds.size(); i++){   %>
 		<form action="">
 		<div class="board" id="left">
			<button class="close" id="la"><span class="fa fa-close"></span></button>
			<label id="left" style="max-width : 200px; ">Board Name :   <%  out.print(((JSONObject)(brds.get(i))).get("name"));   %></label>
		<button class="view" id="right"><span class="fa fa-arrows-alt"></span></button>	
		</div> 
		</form>
		<%}%>
		<form method="post">
			<div class="addboard">
				<button id="myBtn" onclick="popup()" type="button" class="fill" style=" margin: 20%; margin-left: 28%; width: auto;"> Add Board </button>
			</div>
		</form>
		<label style="margin: 10px 20px; position: absolute; color: #165258;">DELETE</label>
		<label style="margin: 25px 20px; position: absolute; color: #165258;">BOARD</label>
		<label class="switch">
  			<input onclick="fn3()" type="checkbox">
  			<div class="slider round"></div>
		</label>
	</div>
	<form action="AddBoard.jsp">
	<div id="myModal" class="popup">
  			<div class="popup-content">
				<span class="closebtn fa fa-close"></span>
				<h1>Add Board</h1>
				<p>board Name :</p>
    			<input type="text" name="boardname" value="Board No."/>
    			<button class="fill">Confirm</button>
  			</div>
	</div>
</form>
</body>
</html>