package com.example.SnakesAndLaddersKata.service;

import com.example.SnakesAndLaddersKata.entity.Dice;
import com.example.SnakesAndLaddersKata.entity.PlayDesk;
import com.example.SnakesAndLaddersKata.entity.Token;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SnakesAndLaddersKataTest {
    @Test
    public void testMoveTokenMethod() {
        Token token1 = new Token(1, "first");
        Token token2 = new Token(2, "second");
        PlayDesk playDesk = Mockito.mock(PlayDesk.class);
        Dice dice = Mockito.mock(Dice.class);

        SnakesAndLaddersKata snakesAndLaddersKata = new SnakesAndLaddersKata(Arrays.asList(token1, token2), playDesk,dice);

        assertEquals(1, token1.getPosition());
        assertEquals(1, token2.getPosition());

        when(dice.role()).thenReturn(3);
        when(playDesk.getPosition(4)).thenReturn(4);
        snakesAndLaddersKata.moveToken();
        assertEquals(4, token1.getPosition());
        assertEquals(1, token2.getPosition());

        when(dice.role()).thenReturn(6);
        when(playDesk.getPosition(7)).thenReturn(7);
        snakesAndLaddersKata.moveToken();
        assertEquals(4, token1.getPosition());
        assertEquals(7, token2.getPosition());

        when(playDesk.getPosition(8)).thenReturn(8);
        when(dice.role()).thenReturn(4);
        snakesAndLaddersKata.moveToken();
        assertEquals(8, token1.getPosition());
        assertEquals(7, token2.getPosition());
    }

}