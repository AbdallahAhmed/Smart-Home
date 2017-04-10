<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<%	String username = request.getParameter("username");
  	String password = request.getParameter("pass");
// 	ClientConfig config1 = new ClientConfig();
// 	Client client = ClientBuilder.newClient(config1);
// 			WebTarget target = client.target(UriBuilder.fromUri(
// 				"http://localhost:8080/Smart-Home").build());
			Client client = ClientBuilder.newClient();
			WebTarget target = client
			    .target("http://localhost:8080/Smart-Home/rest")
			    .path("signin");
// 		JSONParser parser = new JSONParser();
// 		Object obj = parser.parse(target.path("rest")
// 				.path("signin").path(username)
// 				.path(password).request()

// 				.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class)

// 				.toString());
				JSONObject jsonObj = new JSONObject();
				boolean valid = true;
				if(valid == true){
					
					out.print(username+ " "+  password);
				}else{
					out.print("Sign in failed!!");
				}%>

</body>
</html>