<%@page import="javax.ws.rs.client.Entity"%>
<%@page import="javax.ws.rs.core.Form"%>
<%@ page import="RestServices.RestConnector" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loading...</title>
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
long st = System.currentTimeMillis();
String username = request.getParameter("username");
String pass = request.getParameter("password");
RestConnector rc = new RestConnector("SignIn", "POST");
rc.addParamPost("username", username);
rc.addParamPost("password", pass);
JSONObject obj = rc.getJSONObject();
long end = System.currentTimeMillis();
//System.out.print(end - st);
boolean valid = (Boolean) (obj.get("signin"));
if(valid == true)
{
	session.setAttribute("user", obj.get("user"));
	response.sendRedirect("Home.jsp"); 
	
}else {
	response.sendRedirect("404.jsp");
} 
 %>
</body>
</html>