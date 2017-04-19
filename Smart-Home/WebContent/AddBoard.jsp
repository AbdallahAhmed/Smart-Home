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
<%	String boardName = request.getParameter("boardname");
System.out.println(boardName);
	JSONObject obj = (JSONObject)session.getAttribute("user");
	String username = (String)obj.get("name");
 	RestConnector rc = new RestConnector("AddBoard");
	String[] param = {username, boardName};
	rc.addParam(param); 
	JSONObject btengan = rc.getJSONObject();
	Board brd = new Board(boardName);
	JSONArray brds =  (JSONArray)obj.get("boards");
	brds.add(brd.toJson());
	obj.put("boards", brds);
	session.setAttribute("user", obj);
	response.sendRedirect("Home.jsp");
	
%>
</body>
</html>