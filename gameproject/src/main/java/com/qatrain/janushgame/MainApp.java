package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Game;

/**
 * This class starts the whole game.
 * */
public class MainApp {
    static Game game;

    public static void main(String ...args) {
        System.out.println("GAME START!");

        for (int lives=0; lives<3; lives++) {
            game = new Game();

            game.play();
        }

        System.out.println("GAME OVER! " + game);
    }
}