/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.dao;

import com.ceva.arqjv1.records.Actor;
import java.util.Set;

import static com.ceva.arqjv1.dao.ActorDAO.FIND_ALL;
import static com.ceva.arqjv1.dao.ActorDAO.FIND_BY_ID;
import static com.ceva.arqjv1.dao.ActorDAO.CONCAT_NAMES_BY_ID;
import static com.ceva.arqjv1.dao.ActorDAO.SIMPLE_INSERT;
import static com.ceva.arqjv1.dao.ActorDAO.SIMPLE_DELETE;
import static com.ceva.arqjv1.dao.ActorDAO.SIMPLE_UPDATE;
import static com.ceva.arqjv1.dao.ActorDAO.FIND_ALL_ACTORS_WITH_FILMS;
import static com.ceva.arqjv1.dao.ActorDAO.FIND_ACTOR_WITH_FILMS;
import com.ceva.arqjv1.helpers.DatabaseHelper;
import com.ceva.arqjv1.summaries.FilmSummary;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
      LOGGER.error("A problem has occured when executing SELECT query", ex);
    }
    return actors;
  }
  
  @Override
  public Actor findActorWithFilms(Integer id) {
    Actor act = findById(id);
    Actor actor = null;
    Set<FilmSummary> filmSumary = null;
    try(var connection = DatabaseHelper.getConnection()){
      var statement = connection.prepareStatement(FIND_ACTOR_WITH_FILMS);
      statement.setInt(1, id);
      var resultSet = statement.executeQuery();
      while(resultSet.next()){
        var film = new FilmSummary(
          resultSet.getInt(1),
          resultSet.getString(2),
          resultSet.getString(3),
          resultSet.getString(4),
          resultSet.getString(5));
        filmSumary.add(film);
      }
      actor = new Actor(
        act.actor_id(),
        act.first_name(),
        act.last_name(),
        Set.copyOf(filmSumary),
        act.last_update());
    }
    catch(SQLException ex){
      LOGGER.error("A problem has occured when executing SELECT query", ex);
    }
    return actor;
  }

  @Override
  public Actor findById(Integer id) {
    Actor actor = null;
    try(var connection = DatabaseHelper.getConnection()){
      var statement = connection.prepareStatement(FIND_BY_ID);
      statement.setInt(1, id);
      var resultSet = statement.executeQuery();
      while(resultSet.next()){
        actor = new Actor(
          resultSet.getInt("actor_id"),
          resultSet.getString("first_name"),
          resultSet.getString("last_name"),
          Set.of(),
          resultSet.getTimestamp("last_update").toInstant());
      }
    }
    catch(SQLException ex){
      LOGGER.error("A problem occured when executing SELECT query", ex);
    }
    return actor;
  }

  @Override
  public String findNameById(Integer id) {
    String actorName = "";
    try(var connection = DatabaseHelper.getConnection()){
      var statement = connection.prepareStatement(CONCAT_NAMES_BY_ID);
      statement.setInt(1, id);
      var resultSet = statement.executeQuery();
      while(resultSet.next()){
        actorName = resultSet.getString("actor_name");
      }
    }
    catch(SQLException ex){
      LOGGER.error("A problem occured when executing SELECT query", ex);
    }
    return actorName;
  }

  @Override
  public Actor insert(Actor actor) {
    try(var connection = DatabaseHelper.getConnection()){
      var statement = connection.prepareStatement(SIMPLE_INSERT, Statement.RETURN_GENERATED_KEYS);
      statement.setString(1, actor.first_name());
      statement.setString(2, actor.last_name());
      statement.setTimestamp(3, Timestamp.from(actor.last_update()));
      statement.execute();
      ResultSet generatedKey = statement.getGeneratedKeys();
      if(generatedKey.next()){
        return new Actor(generatedKey.getInt(1),
          actor.first_name(),
          actor.last_name(),
          Set.of(),
          actor.last_update());
      }
    }
    catch(SQLException ex){
      LOGGER.error("A problem occured when executing INSERT statement", ex);
    }
    return null;
  }

  @Override
  public void update(Actor actor) {
    // var act = findById(actor.actor_id());
    try(var connection = DatabaseHelper.getConnection()){
      var statement = connection.prepareStatement(SIMPLE_UPDATE);
      statement.setString(1, actor.first_name());
      statement.setString(2, actor.last_name());
      statement.setTimestamp(3, Timestamp.from(actor.last_update()));
      statement.execute();
    }
    catch(SQLException ex){
      LOGGER.error("A problem occured when executing UPDATE statement", ex);
    }
  }

  @Override
  public void delete(Integer id) {
    try(var connection = DatabaseHelper.getConnection();
        var statement = connection.prepareStatement(SIMPLE_DELETE)){
      statement.setInt(1, id);
      statement.execute();
    }
    catch(SQLException ex){
      LOGGER.error("A problem occured when executing DELETE statement", ex);
    }
  }

  
  
  @Override
  public Set<Actor> findAllActorsWithFilms(){
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
