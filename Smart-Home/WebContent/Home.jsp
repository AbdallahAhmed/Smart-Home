<%@page import="RestServices.RestConnector"%>
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
	RestConnector rc = new RestConnector("SignIn");
	String[] tmp = {username, password};
	rc.addParam(tmp);
	JSONObject jsonObj = rc.getJSONObject(); 
	boolean valid = (Boolean)(jsonObj.get("signin"));
	if(valid == true){					
		out.print(username+ " "+  password);
	}else{
		out.print("Sign in failed!!");
	}
%>

</body>
</html>