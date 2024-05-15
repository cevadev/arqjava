/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.records;

import java.util.Set;
import java.time.Instant;

/**
 *
 * @author Test
 */
public record Film(
        Integer fild_id,
        String title,
        String description,
        Integer year_release,
        Integer language_release,
        Integer original_language_id,
        Integer rental_duration,
        double rental_rate,
        int length,
        double replacement_cost,
        String rate,
        Set<String> special_features,
        Set<Actor> actors,
        Instant last_update) {
  
}
