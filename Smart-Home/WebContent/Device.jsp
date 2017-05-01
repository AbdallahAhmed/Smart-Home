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
<%
RestConnector rc = new RestConnector("ViewDevice", "GET");
String [] param = {"50"};
rc.addParamGet(param);
JSONObject obj = rc.getJSONObject();
JSONArray arr = (JSONArray) obj.get("operations");
String s = (String)arr.get(1);
System.out.print(s);
out.print(s);



%>

</body>
</html>