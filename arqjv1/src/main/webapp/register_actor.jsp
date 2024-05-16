<%-- 
    Document   : register_actor
    Created on : 23 abr. 2024, 22:11:31
    Author     : Test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.ceva.arqjv1.records.Actor, com.ceva.arqjv1.dao.ActorDAO, com.ceva.arqjv1.dao.ActorDAOImpl, com.ceva.arqjv1.summaries.FilmSummary, java.sql.*, java.time.Instant, java.text.SimpleDateFormat, java.util.Set, java.util.Date, java.io.StringWriter, java.io.PrintWriter"%>
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
	Instant last_update = Instant.now();
        
        Actor actor = new Actor(null, first_name, last_name, Set.of(), last_update);
        final ActorDAO actorDao = new ActorDAOImpl();
        actor = actorDao.insert(actor);
        
        response.sendRedirect("list_actors.jsp");
	
%>
</body>
</html>
