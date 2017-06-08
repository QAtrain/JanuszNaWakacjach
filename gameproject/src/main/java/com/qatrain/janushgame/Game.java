package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Janush;
import com.qatrain.janushgame.model.Level;

/**
 * This class starts the whole game.
 */
public class Game {

    public static void main(String... args) {

        int lives = Janush.LIVES_DEFAULT;

        while (lives > 0) {
            Level level = new Level();
            level.play();

            if (level.isLost() )
                --lives;
        }

        System.out.println("Lives left: " + lives);
        System.out.println("GAME OVER");

    }
}
