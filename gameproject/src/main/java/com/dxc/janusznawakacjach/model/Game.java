package com.dxc.janusznawakacjach.model;

/**
 * This is one small game on one level. It contains grid, timer, janusz and beer.
 *
 * Janusz needs to pick beer within timer frames to win the game. In case Janusz
 * does not pick beer within timer frames the beer is very warm - he looses the game.
 *
 * Game object is one usage. Another game needs to be created to be played. (we could have restart of same game but we did not plan for it)
 */
public class Game {
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
        grid = new Grid();
        //TODO Janusz not ready
        //janusz = new Janusz();
        beer = new Beer(0,0);

        createGame();
    }

    /** This method initializes game. */
    private void createGame() {
        System.out.println("Creating game...");

        grid.createGrid();
        //TODO create rest of game
        setTimer();

        System.out.println("Game created.");
    }

    /** Sets the timer. */
    private void setTimer() {
        //TODO set timer
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