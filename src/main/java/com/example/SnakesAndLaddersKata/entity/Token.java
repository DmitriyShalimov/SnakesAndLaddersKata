package com.example.SnakesAndLaddersKata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Token {
    private int id;
    private String name;
    private int position;

}
