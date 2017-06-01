package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Game;

import java.util.Timer;

/**
 * This class starts the whole game.
 */
public class MainApp {

    public static void main(String... args) {

        //a timer task try out:
//        Timer timer = new Timer();
//        //Time frame within which Janusz needs to pick the beer to win
//        timer.schedule(
//                new Game(),1000,15000); //This method is scheduling Game. Delay 1 second, running time = 15 seconds
//        //always the same game will be played!

        //a new single game play:
        new Game().play();

    }
}