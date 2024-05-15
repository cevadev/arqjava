/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceva.arqjv1.records;

import java.time.Instant;

/**
 *
 * @author Test
 */
public record Category(
        Integer category_id,
        String name,
        Instant last_update) {
}
