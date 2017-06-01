package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Game;

/**
 * This class starts the whole game.
 */
public class MainApp {

    public static void main(String... args) {

        Game game = new Game();
        game.play();

    }
}