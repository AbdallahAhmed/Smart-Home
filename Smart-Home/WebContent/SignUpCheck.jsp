<%@ page import="RestServices.RestConnector" %>
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
	RestConnector rc = new RestConnector("SignUp");
	String[] tmp = {username, pass};
	rc.addParam(tmp);
	JSONObject jsonObj = rc.getJSONObject();
	boolean valid = (Boolean) (jsonObj.get("signup"));
	if(valid == true)
	{
		session.setAttribute("user", jsonObj.get("user"));
		response.sendRedirect("Home.jsp");
		
	}else {
		out.print("Sign up failed");
	}
%>
</body>
</html>