package com.example.SnakesAndLaddersKata.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayDesk {
    private List<Node> squares;

    public PlayDesk() {
        squares = new ArrayList<>(100);
        for (int i = 1; i < 100; i++) {
            Node newNode = new Node(i);
            //snakeLadderId=1- node have snakeValue
            //snakeLadderId=2- node have ladderValue
            //snakeLadderId=1- node have only position
            int snakeLadderId = (int) (1 + Math.random() * 3);
            int snakeValue = (int) (Math.random() * 10);
            if (snakeLadderId == 1) {
                newNode.snake = Math.max(i - snakeValue, 0);
            } else {
                if (snakeLadderId == 2) {
                    newNode.ladder = Math.min(i + snakeValue, 99);
                }
            }
            squares.add(newNode);
        }
        squares.add(new Node(100));
    }

    public int getPosition(int value) {
        Node node = squares.get(value - 1);
        if (node.snake != 0) {
            return node.snake;
        } else {
            if (node.ladder != 0) {
                return node.ladder;
            } else {
                return node.position;
            }
        }
    }

    private class Node {
        private int snake;
        private final int position;
        private int ladder;

        public Node(int position) {
            this.position = position;
        }
    }
}
