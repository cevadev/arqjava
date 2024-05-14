/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase almacena todas las consultas que manejen los datos de la tabla film de la base
 * de datos sakila.
 * @author Test
 */
public class FilmActiveRecord {
  public static ResultSet findAllCategories() throws Exception{
    String query = "SELECT category_id, name FROM category";
    ResultSet rs = DatabaseHelper.executeQuery(query);
    return rs;
  }
  
  public static void add()throws Exception{}
  
  public static ResultSet findAll()throws Exception{
    String query = "SELECT * FROM film";
    ResultSet resultSet = DatabaseHelper.executeQuery(query);
    return resultSet;
  }
}
