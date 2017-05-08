<%@page import="Controller.Board"%>
<%@page import="RestServices.RestConnector"%>
<%@page import="org.json.simple.JSONObject,org.json.simple.*,org.json.simple.parser.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
JSONParser parser = new JSONParser();
JSONObject obj1 = (JSONObject) parser.parse(session.getAttribute("user").toString());
System.out.println(obj1.get("name".toString()));
RestConnector rc = new RestConnector("RemoveBoard", "GET");
String boardname = request.getParameter("boardname");
String  username = request.getParameter("username");
System.out.print(boardname + "   " + username);
String [] param = {boardname, username};
rc.addParamGet(param);
JSONObject obj = (JSONObject) rc.getJSONObject();
boolean valid = (Boolean) (obj.get("valid"));
if(valid == true){
	session.setAttribute("user", obj1);
	response.sendRedirect("Home.jsp");
	
}
%>

</body>
</html>