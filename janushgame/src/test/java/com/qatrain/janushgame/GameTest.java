package com.qatrain.janushgame;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void shouldGetNoLifes() {
        Game game = new Game();
        int getLives = game.start();
        int expectedLives = 0;

        Assert.assertEquals(expectedLives, getLives);
    }


    @Test
    public void when0LifesThenEndImmediately() {
        Game game = new Game();
        game.lifes = 0;

        int getLives = game.start();
        int expectedLives = 0;

        Assert.assertEquals(expectedLives, getLives);
    }
}
