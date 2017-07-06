package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Janush;
import com.qatrain.janushgame.model.Level;

/**
 * This class starts the whole game.
 */
public class Game {
    int lifes = Janush.LIFES_DEFAULT;

    public static void main(String... args) {
        Game game = new Game();
        game.start();
    }

    public int start() {
        while (lifes > 0) {
            Level level = new Level();
            level.play();

            if (level.isLost())
                --lifes;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Lifes left: " + lifes);
        System.out.println("\nGAME is OVER\n");

        return lifes;
    }
}
