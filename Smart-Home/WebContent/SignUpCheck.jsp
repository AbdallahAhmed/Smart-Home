<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title></title>
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
<%
	String username = request.getParameter("newuser");
	String pass = request.getParameter("newpass");
	ClientConfig config1 = new ClientConfig();
	Client client = ClientBuilder.newClient(config1);
			WebTarget target = client.target(UriBuilder.fromUri(
				"http://localhost:8080/Smart-Home").build());
						JSONParser parser = new JSONParser();
 		Object obj = parser.parse(target
 				.path("rest")
 				.path("SignUp").path(username).path(pass)
 				.request()
 				.accept(MediaType.TEXT_PLAIN)
 				.get(String.class).toString());
		JSONObject jsonObj = (JSONObject) obj;
		boolean valid = (Boolean)(jsonObj.get("signup"));
		if(valid == true){
			out.println("Successfully Signed up !!");
		}else{
			out.println("Sign up failed !!");
		}
%>
</body>
</html>