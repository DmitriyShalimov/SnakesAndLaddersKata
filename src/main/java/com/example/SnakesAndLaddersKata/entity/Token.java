package com.example.SnakesAndLaddersKata.entity;

import lombok.Data;

@Data
public class Token {
    private int id;
    private String name;
    private int position = 1;

    public Token(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
