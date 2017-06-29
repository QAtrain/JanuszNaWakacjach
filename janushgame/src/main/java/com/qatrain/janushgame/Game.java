package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Janush;
import com.qatrain.janushgame.model.Level;

import java.io.Console;

/**
 * This class starts the whole game.
 */
public class Game {
    Console console = null;

    public Game() {
        console = System.console();

        if (console == null) {
            System.out.println(
                    "Can't run in non-interactive mode! Run in console using: \n" +
                            "     java -cp ./target/classes com.qatrain.janushgame.ConsoleMoves \n");
            System.exit(0);
        }

        System.out.println("Press ENTER after every move / set of moves. \n" +
                "Press x to exit. Clear screen before starting. \n" +
                "Use keyboard keys ^v<> or asdw:");
    }

    public static void main(String... args) {
        Game game = new Game();
        game.start();
    }

    public int start() {
        int lives = Janush.LIVES_DEFAULT;

        while (lives > 0) {
            Level level = new Level();
            level.play(console);

            if (level.isLost())
                --lives;

            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.print(".");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Lives left: " + lives);
        System.out.println("\nGAME is OVER\n");
        return lives;
    }
}
