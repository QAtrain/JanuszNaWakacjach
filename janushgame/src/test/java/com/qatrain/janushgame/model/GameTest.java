package com.qatrain.janushgame.model;

import com.qatrain.janushgame.Game;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class GameTest {

    @Ignore
    @Test
    public void shouldGetNoLives() {
        Game game = new Game();
        int getLives = game.start();
        int expectedLives = 0;
        Assert.assertEquals(expectedLives, getLives);
    }
}
