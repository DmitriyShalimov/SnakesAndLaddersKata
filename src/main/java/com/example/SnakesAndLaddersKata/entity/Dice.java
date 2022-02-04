package com.example.SnakesAndLaddersKata.entity;

public class Dice {
    public int role() {
        return (int) (1 + Math.random() * 6);
    }
}