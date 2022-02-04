package com.example.SnakesAndLaddersKata.service;

import com.example.SnakesAndLaddersKata.entity.Dice;
import com.example.SnakesAndLaddersKata.entity.PlayDesk;
import com.example.SnakesAndLaddersKata.entity.Token;

import java.util.List;

public class SnakesAndLaddersKata {
    private final Dice dice;
    private final List<Token> tokens;
    private final PlayDesk playDesk;
    private Node currentToken;

    public SnakesAndLaddersKata(List<Token> tokens, PlayDesk playDesk, Dice dice) {
        this.dice = dice;
        this.tokens = tokens;
        this.playDesk = playDesk;

        //created looped list of tokens, where the first refers to the second, the second to the third, ... the last to the first
        for (int i = 0; i < tokens.size(); i++) {
            Node new_node = new Node(tokens.get(i));
            if (currentToken == null) {
                currentToken = new_node;
            } else {
                Node last = currentToken;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = new_node;
            }
            if (i == tokens.size() - 1) {
                new_node.next = currentToken;
            }
        }
    }

    public void moveToken() {
        int position = currentToken.token.getPosition() + dice.role();
        if (position > 100) {
            position = currentToken.token.getPosition();
        }
        int newPosition = playDesk.getPosition(position);
        currentToken.token.setPosition(newPosition);
        currentToken = currentToken.next;
    }

    private class Node {
        Token token;
        Node next;

        public Node(Token token) {
            this.token = token;
        }
    }
}
