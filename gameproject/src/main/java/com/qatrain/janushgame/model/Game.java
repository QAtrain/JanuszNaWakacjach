package com.qatrain.janushgame.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This is one small game on one level. It contains grid, timer, janusz and beer.
 * <p>
 * Janusz needs to pick beer within timer frames to win the game. In case Janusz
 * does not pick beer within timer frames the beer is very warm - he looses the game.
 * <p>
 * Game object is one usage. Another game needs to be created to be played. (we could have restart of same game but we did not plan for it)
 */
public class Game {

    int lives = Janush.LIVES_DEFAULT;

    /**
     * Grid or grid for this game.
     */
    Grid grid;

    /**
     * Janusz standing on the grid.
     */
    // TODO Janusz not ready
    Janush janusz;

    /**
     * Beer to be picked by Janusz.
     */
    Beer beer;

    /**
     * Time frame within which Janusz needs to pick the beer to win.
     */
    Timer timer;

    /**
     * Did Janusz win (true) or loose (false)?
     */
    boolean won = false;

    /**
     * Main Game constructor
     */
    public Game() {
        //TODO Janusz not ready
        //janusz = new Janusz();
        //beer = new Beer(0,0);
        createGame();
    }

    /**
     * This method initializes game.
     */
    private void createGame() {
        System.out.println("Creating game...");
        setTimer();
        System.out.println("Game created.");
    }

    /**
     * This method sets the timer.
     */
    private void setTimer() {
        timer = new Timer();
        timer.schedule(new Task(), 0, 15000); //This method is scheduling Task. No delay, running time = 15 seconds
    }

    /**
     * Inner class which runs Timer Task
     */
    class Task extends TimerTask {
        @Override
        public void run() {
            grid = new Grid();

            System.out.println("Lives left: " + lives);
            System.out.println(grid.drawTable());
            --lives;

            if (lives == 0) {
                timer.cancel();
                System.out.println("GAME OVER");
            }
        }
    }

    /**
     * Starts the game.
     */
    public void play() {
        System.out.println("Janusz starts playing...");

        //TODO play in a loop
        //TODO count time down
        //TODO listen for keyboard clicks
        //TODO refresh GUI

        System.out.println("Janusz is done playing.");
    }

    //@Override
    //public String toString() {
    //return "Janusz " + (won ? "won :D " : "lost :( ") +
    //(timer <= 0 ? "because timer finished. The beer is warm now. " : "Time left was " + timer + ". The beer got spilled! No beer for Janusz this time. ");
    //TODO add beer position
    //TODO print janusz position
    //}
}