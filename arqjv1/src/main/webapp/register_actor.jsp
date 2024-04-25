<%-- 
    Document   : register_actor
    Created on : 23 abr. 2024, 22:11:31
    Author     : Test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.ceva.arqjv1.helpers.DatabaseHelper, java.sql.*, java.text.SimpleDateFormat, java.util.Date, java.io.StringWriter, java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register an Actor</title>
</head>
<body>
<%
	// obtenemos parametros del formulario actor_form.jsp
	String first_name = request.getParameter("first_name");
	String last_name = request.getParameter("last_name");
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	
	String formatPattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
	Date date = sdf.parse(ts.toString());
	
	Timestamp last_update = new Timestamp(date.getTime());
        
        String query = "INSERT INTO actor (first_name, last_name, last_update) VALUES(?,?,?)";
        DatabaseHelper.executeUpdate(query, first_name, last_name, last_update);
        response.sendRedirect("list_actors.jsp");
	
%>
</body>
</html>
