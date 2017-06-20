package com.qatrain.janushgame.model;

import com.qatrain.janushgame.Game;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    
    @Test
    public void shouldGetNoLives() {
        Game game = new Game();
        int getLives = game.Start();
        int expectedLives = 0;
        Assert.assertEquals(expectedLives, getLives);
    }
}
