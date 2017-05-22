package com.qatrain.janushgame.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This is one small game on one level. It contains grid, timer, janusz and beer.
 *
 * Janusz needs to pick beer within timer frames to win the game. In case Janusz
 * does not pick beer within timer frames the beer is very warm - he looses the game.
 *
 * Game object is one usage. Another game needs to be created to be played. (we could have restart of same game but we did not plan for it)
 */
public class Game {
    Timer timer1;
    int gameCounter = 0;

    /** Grid or grid for this game. */
    Grid grid;

    /** Janusz standing on the grid. */
    // TODO Janusz not ready
    // Janusz janusz;

    /** Beer to be picked by Janusz. */
    Beer beer;

    /** Time frame within which Janusz needs to pick the beer to win. */
    int timer = TIME_MAX;
    /** Time in seconds. */
    private static final int TIME_MAX = 15;

    /** Did Janusz win (true) or loose (false)? */
    boolean won = false;


    public Game() {
        //TODO Janusz not ready
        //janusz = new Janusz();
        //beer = new Beer(0,0);
        createGame();
    }

    class Task extends TimerTask {
        @Override
        public void run() {
            gameCounter++;
            System.out.println(gameCounter);
            Grid grid = new Grid();
            System.out.println(grid.drawTable());

            if (gameCounter == 3) {
                timer1.cancel();
            }
        }
    }

    /** This method initializes game. */
    private void createGame() {
        System.out.println("Creating game...");
        setTimer();
        System.out.println("Game created.");
    }

    /** Sets the timer. */
    private void setTimer() {
        timer1 = new Timer();
        timer1.schedule(new Task(), 0, 15000);
    }

    /** Starts the game. */
    public void play() {
        System.out.println("Janusz starts playing...");

        //TODO play in a loop
        //TODO count time down
        //TODO listen for keyboard clicks
        //TODO refresh GUI

        System.out.println("Janusz is done playing.");
    }

    @Override
    public String toString() {
        return "Janusz " + (won ? "won :D " : "lost :( ") +
                (timer <= 0 ? "because timer finished. The beer is warm now. " : "Time left was " + timer + ". The beer got spilled! No beer for Janusz this time. ");
        //TODO add beer position
        //TODO print janusz position
    }
}