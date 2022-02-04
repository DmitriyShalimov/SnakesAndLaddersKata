package com.example.SnakesAndLaddersKata.service;

import com.example.SnakesAndLaddersKata.entity.Dice;
import com.example.SnakesAndLaddersKata.entity.PlayDesk;
import com.example.SnakesAndLaddersKata.entity.Token;
import com.example.SnakesAndLaddersKata.entity.WinnerToken;

import java.util.List;

public class SnakesAndLaddersKata {
    private final Dice dice;
    private final PlayDesk playDesk;
    private Node currentToken;

    public SnakesAndLaddersKata(List<Token> tokens, PlayDesk playDesk, Dice dice) {
        this.dice = dice;
        this.playDesk = playDesk;
        //created looped list of tokens, where the first refers to the second, the second to the third, ... the last to the first
        for (int i = 0; i < tokens.size(); i++) {
            Node newNode = new Node(tokens.get(i));
            if (currentToken == null) {
                currentToken = newNode;
            } else {
                Node last = currentToken;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }
            if (i == tokens.size() - 1) {
                newNode.next = currentToken;
            }
        }
    }

    public WinnerToken moveToken() {
        int position = currentToken.token.getPosition() + dice.role();
        if (position > 100) {
            position = currentToken.token.getPosition();
        }
        int newPosition = playDesk.getPosition(position);
        if (newPosition == 100) {
            currentToken.token.setPosition(100);
            return new WinnerToken(currentToken.token);
        }
        currentToken.token.setPosition(newPosition);
        currentToken = currentToken.next;
        return null;
    }

    private class Node {
        Token token;
        Node next;

        public Node(Token token) {
            this.token = token;
        }
    }
}
