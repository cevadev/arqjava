/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.dao;

import com.ceva.arqjv1.records.Actor;
import java.util.Set;

import static com.ceva.arqjv1.dao.ActorDAO.FIND_ALL;
import static com.ceva.arqjv1.dao.ActorDAO.FIND_BY_ID;
import static com.ceva.arqjv1.dao.ActorDAO.CONCAT_NAME_BY_ID;
import static com.ceva.arqjv1.dao.ActorDAO.INSERT;
import static com.ceva.arqjv1.dao.ActorDAO.DELETE;
import static com.ceva.arqjv1.dao.ActorDAO.UPDATE;
import static com.ceva.arqjv1.dao.ActorDAO.FIND_ONE_WITH_FILMS;
import static com.ceva.arqjv1.dao.ActorDAO.FIND_ALL_WITH_FILMS;
import com.ceva.arqjv1.helpers.DatabaseHelper;
import java.sql.SQLException;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Test
 */
public class ActorDAOImpl implements ActorDAO{
  private static final Logger LOGGER = LoggerFactory.getLogger(ActorDAOImpl.class);
  @Override
  public Set<Actor> findAll() {
    Set<Actor> actors = new HashSet<Actor>();
    try(var connection = DatabaseHelper.getConnection();
        var statement = connection.prepareStatement(FIND_ALL);
        var resultSet = statement.executeQuery()){
      while(resultSet.next()){
        Actor actor = new Actor(
          resultSet.getInt("actor_id"),
          resultSet.getString("first_name"),
          resultSet.getString("last_name"),
          Set.of(),
          resultSet.getTimestamp("last_update").toInstant());
        actors.add(actor);
      }
    }
    catch(SQLException ex){
      LOGGER.error("A problem when executing SELECT query", ex);
    }
    return actors;
  }

  @Override
  public Actor findById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public String findNameById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public Actor insert(Actor actor) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public void update(Actor actor) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public void delete(Integer id) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public Set<Actor> findAllWithFilms() {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
  
}
