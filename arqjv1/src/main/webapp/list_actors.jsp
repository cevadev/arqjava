<%-- 
    Document   : list_actors
    Created on : 23 abr. 2024, 22:12:55
    Author     : Test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.text.SimpleDateFormat, java.util.Date"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List all Actors</title>
  </head>
  <body>
    
    <%
	try {
		// conexion mysql
		String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM actor")){
			
			out.println("<h2>List of Actors</h2>");
                        out.println("<a href=\"new_actor.jsp\">Add new actor</a>");
                        out.println("</br>");
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
		}
		catch(SQLException e){
			out.println("<p>was not possible get Actor data</p>");
		}
		
	} catch (Exception e) {
		out.println("<p>was not possible process this request</p>");
	}
	%>
  </body>
</html>
