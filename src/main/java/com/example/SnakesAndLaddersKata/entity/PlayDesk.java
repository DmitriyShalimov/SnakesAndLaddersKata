package com.example.SnakesAndLaddersKata.entity;

import lombok.Data;

@Data
public class PlayDesk {
    private Node start;
    private Node finish;

    public int getPosition(int value){
        return -1;
    }

    private class Node {
        private Node snake;
        private int position;
        private Node ladder;
    }
}
