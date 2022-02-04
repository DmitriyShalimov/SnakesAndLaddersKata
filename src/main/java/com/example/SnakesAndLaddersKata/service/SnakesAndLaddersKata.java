package com.example.SnakesAndLaddersKata.service;

import com.example.SnakesAndLaddersKata.entity.PlayDesk;
import com.example.SnakesAndLaddersKata.entity.Token;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class SnakesAndLaddersKata {
    private final List<Token> tokens;
    private final PlayDesk playDesk;

    public void moveToken(int moveValue) {
    }
}
