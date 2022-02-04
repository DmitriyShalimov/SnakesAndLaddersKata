package com.example.SnakesAndLaddersKata.entity;

import lombok.Data;

@Data
public class PlayDesk {
    private Node start;
    private Node finish;

    private class Node {
        private Node snake;
        private int position;
        private Node ladder;
    }
}
