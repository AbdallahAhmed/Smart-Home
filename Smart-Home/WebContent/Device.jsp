<%@page import="Connectors.SocketConnector"%>
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
        <script src="http://code.jquery.com/jquery-latest.js">   
        </script>
<title>Device</title>
</head>

<body onload="construct()">
	<%
// 		JSONParser parser = new JSONParser();
// 		JSONObject obj = (JSONObject) parser.parse(session.getAttribute("user").toString());
	%>

	<div id="upper">
		<a href="Board.jsp"><button class="back">
				<span class="fa fa-angle-left"></span>
			</button></a> <label style="" id="devName">Device Name</label>
	</div>
	<div class="inter">
		<div id="dev">
			<%
				RestConnector rc = new RestConnector("ViewDevice", "GET");
				String deviceId = request.getParameter("deviceId");
				System.out.println("port : " + request.getParameter("port"));
				String[] x = { deviceId };
				rc.addParamGet(x);
				JSONObject obj1 = rc.getJSONObject();
				JSONArray arr = (JSONArray) obj1.get("operations");
				String s = "";
				for (int i = 0; i < arr.size(); i++) {
					out.print(arr.get(i));
					System.out.print(arr.get(i));
				}				
			%>
			<script>
            $(document).ready(function() {                        
                $('#statusbtn').click(function(event) {  
                    var username=$('#statusbtn').val();
                 $.get('ActionServlet',{user:username},function(responseText) { 
                                 
                    });
                });
                $('#sub').click(function(event) {  
                    var username=$('#sub').val();
                 $.get('ActionServlet',{user:username},function(responseText) { 
                                 
                    });
                });
                $('#sub2').click(function(event) {  
                    var username=$('#sub2').val();
                 $.get('ActionServlet',{user:username},function(responseText) { 
                                 
                    });
                });
            });
			</script>
		
		
		</div>
		
		<div id="light"></div>
	</div>
</body>
</html>