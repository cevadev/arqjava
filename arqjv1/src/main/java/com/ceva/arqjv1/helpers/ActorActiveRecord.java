/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.helpers;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author Test
 */
public class ActorActiveRecord {
  public static ResultSet findAll() throws Exception{
    String query = "SELECT * FROM actor";
    ResultSet rs = DatabaseHelper.executeQuery(query);
    return rs;
  }
  
  public static void add(String first_name, String last_name, Timestamp last_update)throws Exception{
    String query = "INSERT INTO actor(first_name, last_name, last_update) VALUES(?,?,?)";
    DatabaseHelper.executeUpdate(query, first_name, last_name, last_update);
  }
}
