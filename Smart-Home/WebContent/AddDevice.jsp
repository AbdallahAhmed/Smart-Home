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
String deviceId = request.getParameter("deviceId");
String boardname = request.getParameter("boardname");
System.out.println(username);
System.out.println(deviceId);
System.out.println(boardname);
RestConnector rc = new RestConnector("AddDevice","GET");
String[] param = {username, boardname, deviceId};
rc.addParamGet(param);
JSONObject btengan = rc.getJSONObject();
/* session.setAttribute("user", obj);
response.sendRedirect("Home.jsp"); */

%>

</body>
</html>