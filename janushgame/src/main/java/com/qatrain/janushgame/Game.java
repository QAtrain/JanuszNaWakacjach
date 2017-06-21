package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Janush;
import com.qatrain.janushgame.model.Level;

/**
 * This class starts the whole game.
 */
public class Game {

    public static void main(String... args) {
        Game game = new Game();
        game.Start();
    }

    public int Start() {
        int lifes = Janush.LIFES_DEFAULT;

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
