<%-- 
    Document   : list_actors
    Created on : 23 abr. 2024, 22:12:55
    Author     : Test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.ceva.arqjv1.records.Actor, com.ceva.arqjv1.dao.ActorDAOImpl, java.util.Set, java.io.StringWriter, java.io.PrintWriter, java.sql.*, java.text.SimpleDateFormat, java.util.Date"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List all Actors</title>
  </head>
  <body>

    <%
      // get actors list
      String query = "SELECT * FROM actor";
      
      try{
        // ResultSet resultSet = DatabaseHelper.executeQuery(query);
        Set<Actor> actors = ActorDAOImpl.findAll();
        out.println("<h2>List of Actors</h2>");
        out.println("<a href=\"new_actor.jsp\">Add new actor</a><br />");
        out.println("<br />");
        out.println("<table border='1'>");
        out.println("<tr><th>F. Name</th><th>L. Name</th><th>Date upd.</th></tr>");
			
        while(resultSet.next()){
          String first_name = resultSet.getString("first_name");
          String last_name = resultSet.getString("last_name");
			
          Timestamp lupdt = resultSet.getTimestamp("last_update");
          String formatPattern = "yyyy-MM-dd HH:mm:ss";
          SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
          String last_update = sdf.format(lupdt);
				
          out.println("<tr><td>"+ first_name + "</td><td>" + last_name + "</td><td>" + last_update + "</td></tr>");
        }
        out.println("</table>");
        
        // close connection
        // DatabaseHelper.close(null, null, resultSet);
      }
      catch(Exception ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        out.println(sw.toString());
      }
    %>
  </body>
</html>
