/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.helpers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Test
 */
public class DatabaseHelper {

  private static Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
  private static final String USER = "root";
  private static final String PASSWORD = "root";
  private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

  private static HikariConfig config = new HikariConfig();
  private static HikariDataSource ds;

  // preparacion de Hakari Datasource
  static {
    try {
      config.setJdbcUrl(JDBC_URL);
      config.setUsername(USER);
      config.setPassword(PASSWORD);
      config.setDriverClassName(DRIVER_CLASS_NAME);
      config.addDataSourceProperty("cachePrepStmts", "true");
      config.addDataSourceProperty("prepStmtCacheSize", "250");
      config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
      ds = new HikariDataSource(config);
      ds.setMaximumPoolSize(25);
    } catch (Exception ex) {
      LOGGER.error("Hikari DataSource bean cannot be created!", ex);
    }
  }

  public DatabaseHelper() {
  }

  // obtener conexion
  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }

  // ejecutar consultas de actualizacion de datos
  public static int executeUpdate(String sql, Object... parameters) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);
      // establecemos los parametros de consultas
      for (int i = 0; i < parameters.length; i++) {
        preparedStatement.setObject(i + 1, parameters[i]);
      }

      // run query
      return preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
      return -1;
    } finally {
      close(connection, preparedStatement, null);
    }
  }

  // ejecutar consultas de seleccion
  public static ResultSet executeQuery(String sql, Object... parameters) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);
      // establecemos los parametros de consultas
      for (int i = 0; i < parameters.length; i++) {
        preparedStatement.setObject(i + 1, parameters[i]);
      }
      // run query
      return preparedStatement.executeQuery();
    }
    catch (SQLException ex) {
      ex.printStackTrace();
      return null;
    } finally {
      close(connection, preparedStatement, null);
    }
  }

  // cerrar recursos
  public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException ex) {
      LOGGER.error("No se puedo cerrar los recursos", ex);
    }
  }
}
