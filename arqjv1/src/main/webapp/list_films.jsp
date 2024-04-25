<%-- 
    Document   : list_films
    Created on : 24 abr. 2024, 20:52:43
    Author     : Test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ceva.arqjv1.helpers.DatabaseHelper, java.io.StringWriter, java.io.PrintWriter, java.sql.*"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of films</title>
  </head>
  <body>
    <%
        String category_film_query =  "SELECT category_id, name FROM category";
        try{
          ResultSet rsCategoriesFilm = DatabaseHelper.executeQuery(category_film_query);
          out.println("<select name='category'>");
          while(rsCategoriesFilm.next()){
            String categoriesFilm = rsCategoriesFilm.getString("name");
            out.println("<option>" + categoriesFilm + "</option>");
          }
          out.println("</select>");
        }
        catch(Exception ex){
          StringWriter sw = new StringWriter();
          PrintWriter pw = new PrintWriter(sw);
          ex.printStackTrace(pw);
          out.println(sw.toString());
      }
        
        String query = "SELECT title, description, release_year FROM  film";
        try{
          ResultSet resultSet = DatabaseHelper.executeQuery(query);
          out.println("<h2>List of Films</h2><br />");
          out.println("<br />");
          out.println("<table border='1'>");
          out.println("<tr><th>Title</th><th>Description</th><th>Release Year</th></tr>");
          while(resultSet.next()){
            String film_title = resultSet.getString("title");
            String film_description = resultSet.getString("description");
            int film_release = resultSet.getInt("release_year");
            out.println("<tr><td>"+ film_title + "</td><td>" + film_description + "</td><td>" + film_release + "</td></tr>");
          }
          out.println("</table>");
          // close connection
        DatabaseHelper.close(null, null, resultSet);
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
