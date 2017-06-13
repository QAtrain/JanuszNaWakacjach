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

            if (level.isLost())
                --lives;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Lives left: " + lives);
        System.out.println("\nGAME is OVER\n");
    }
}
