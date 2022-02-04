package com.example.SnakesAndLaddersKata.service;

import com.example.SnakesAndLaddersKata.entity.Dice;
import com.example.SnakesAndLaddersKata.entity.PlayDesk;
import com.example.SnakesAndLaddersKata.entity.Token;
import com.example.SnakesAndLaddersKata.entity.WinnerToken;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SnakesAndLaddersKataTest {
    private  SnakesAndLaddersKata snakesAndLaddersKata;

    @Test
    public void testMoveTokenMethod() {
        Token token1 = new Token(1, "first");
        Token token2 = new Token(2, "second");
        PlayDesk playDesk = Mockito.mock(PlayDesk.class);
        Dice dice = Mockito.mock(Dice.class);

        snakesAndLaddersKata = new SnakesAndLaddersKata(Arrays.asList(token1, token2), playDesk, dice);

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

    @Test
    public void testMoveTokenMethodWithGetWinner() {
        Token token1 = new Token(1, "first");
        Token token2 = new Token(2, "second");
        PlayDesk playDesk = new PlayDesk();
        Dice dice = new Dice();
        WinnerToken winnerToken = null;
        snakesAndLaddersKata=new SnakesAndLaddersKata(Arrays.asList(token1, token2), playDesk, dice);
        while (winnerToken==null){
            winnerToken=snakesAndLaddersKata.moveToken();
        }
        assertNotNull(winnerToken);
    }
}