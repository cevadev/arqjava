/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.dao;

import com.ceva.arqjv1.records.Actor;
import java.util.Set;

/**
 *
 * @author Test
 */
public interface ActorDAO {
  public static final String FIND_ALL ="SELECT actor_id, first_name, last_name FROM actor";
  public static final String FIND_BY_ID = "SELECT actor_id, first_name, last_name WHERE actor_id=?";
  public static final String CONCAT_NAME_BY_ID = "SELECT CONCAT(first_name, ' ', last_name) FROM actor WHERE actor_id=?";
  
  public static final String INSERT = "INSERT INTO actor(fist_name, last_name, last_update) VALUES(?,?,?)";
  public static final String DELETE = "DELETE actor where actor_id=?";
  public static final String UPDATE = "UPDATE actor set first_name=?, last_name=?, last_update=? where actor_id=?";
  
  public static final String FIND_ALL_WITH_FILMS = """
    SELECT "a.actor_id", "a.first_name", "a.last_name", f.title as movie"
    FROM "actor a"
    LEFT JOIN "film_actor fa" ON "fa.actor_id"="a.actor_id"
    LEFT JOIN "film f" ON "f.film_id"="fa.film_id"                  
                                                      """;
  
  public static final String FIND_ONE_WITH_FILMS = """
                                                   """;
  
  Set<Actor> findAll();
  Actor findById(Integer id);
  String findNameById(Integer id);
  Actor insert(Actor actor);
  void update(Actor actor);
  void delete(Integer id);
  Set<Actor> findAllWithFilms();
}
