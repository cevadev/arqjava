<%-- 
    Document   : register_actor
    Created on : 23 abr. 2024, 22:11:31
    Author     : Test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.text.SimpleDateFormat, java.util.Date, java.io.StringWriter, java.io.PrintWriter"%>
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
	
	try{
		// conexion mysql
		String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection=DriverManager.getConnection(jdbcUrl, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO actor (first_name, last_name, last_update) VALUES(?,?,?)")){
			// parametros de la consulta
			preparedStatement.setString(1, first_name);
			preparedStatement.setString(2, last_name);
			preparedStatement.setTimestamp(3, last_update);
			
			preparedStatement.executeUpdate();
                        response.sendRedirect("list_actors.jsp");
			//out.println("<p>Actor saved</p>");
		}
		catch(SQLException e){
			StringWriter sw = new StringWriter();
                        PrintWriter pw = new PrintWriter(sw);
                        e.printStackTrace(pw);
                        out.println(sw.toString());
		}
	}
	catch(Exception e){
		out.println("<p>was not possible process this request</p>");
	}
%>
</body>
</html>
