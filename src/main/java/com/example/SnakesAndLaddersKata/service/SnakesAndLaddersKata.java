package com.example.SnakesAndLaddersKata.service;

import com.example.SnakesAndLaddersKata.entity.PlayDesk;
import com.example.SnakesAndLaddersKata.entity.Token;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class SnakesAndLaddersKata {
    private final List<Token> tokens;
    private final PlayDesk playDesk;
    private Node currentToken;

    public SnakesAndLaddersKata(List<Token> tokens, PlayDesk playDesk) {
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

    public void moveToken(int moveValue) {
        int currentPosition = currentToken.token.getPosition();
        int newPosition = playDesk.getPosition( currentPosition + moveValue);
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
