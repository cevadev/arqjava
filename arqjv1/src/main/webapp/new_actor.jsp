<%-- 
    Document   : new_actor
    Created on : 23 abr. 2024, 22:10:28
    Author     : Test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new Book</title>
  </head>
  <body>
    <h2>Register an Actor</h2>
    <form method="post" action="register_actor.jsp">
      <label for="first_name">First Name:</label>
      <input type="text" name="first_name" required><br>
      <label for="last_name">Last Name:</label>
      <input type="text" name="last_name" required><br>
      <input type="submit" value="Save">
    </form>
  </body>
</html>
