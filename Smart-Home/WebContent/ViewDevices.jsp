<%@page import="Controller.Board"%>
<%@page import="RestServices.RestConnector"%>
<%@page import="org.json.simple.JSONObject,org.json.simple.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

JSONObject obj = (JSONObject)session.getAttribute("user");
String username = (String)obj.get("name");
RestConnector rc1 = new RestConnector("ViewDevices", "GET");
String[] param1 = { username };
rc1.addParamGet(param1);
JSONObject ob1 = rc1.getJSONObject();
JSONArray arr = (JSONArray) ob1.get("Devices");
session.setAttribute("devices", arr);
response.sendRedirect("Board.jsp");
%>


</body>
</html>