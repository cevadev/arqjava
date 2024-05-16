/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.dao;

/**
 *
 * @author Test
 */
public interface FilmDAO {
  public static final String FIND_ALL_FILM_DATA = """
    SELECT "f.film_id", "f.title", "f.special_features", "f.rating", "lang.name as idiom", "cat.name as category"
    FROM "film f"
    LEFT JOIN "film_category fc" ON "fc.film_id"="f.film_id"
    LEFT JOIN "category cat" ON "cat.category_id"="fc.category_id"
    LEFT JOIN "language lang" ON "lang.language_id"="f.language_id"
                                                  """;
}
