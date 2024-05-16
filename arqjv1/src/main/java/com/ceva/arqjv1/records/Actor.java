/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.records;

import com.ceva.arqjv1.summaries.FilmSummary;
import java.time.Instant;
import java.util.Set;

/**
 *
 * @author Test
 */
public record Actor(
        Integer actor_id,
        String first_name,
        String last_name,
        Set<FilmSummary> films,
        Instant last_update){
}
