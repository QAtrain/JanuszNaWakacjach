package com.qatrain.janushgame.model;

import com.qatrain.janushgame.ConsoleMoves;

import java.io.Console;

/**
 * This is one small game on one level. It contains board, timer, janusz and beer.
 * <p>
 * Janusz needs to pick beer within timer frames to win the game. In case Janusz
 * does not pick beer within timer frames the beer is very warm - he looses the game.
 * <p>
 * Level object is one usage. Another game needs to be created to be played.
 * (we could have restart of same game but we did not plan for it)
 *
 * This class is in charge of printing things in proper places on screen.
 * Other classes can print, but they have no idea where - they are blind. 
 */
public class Level extends ConsoleMoves {

    /**
     * Board or board for this game.
     */
    Board board;

    /**
     * Janusz standing on the board.
     */
    Janush janusz;

    /**
     * Beer to be picked by Janusz.
     */
    Beer beer;

    private static final long MAX_DURATION = 30000;

    long startTime;

    /**
     * Did Janusz win (true) or loose (false)?
     */
    public Status status = null;

    public enum Status {
        WOOOOOOOOOOOOOOOoooooooooooooN,
        LOST,
        LOST_BY_TIME,
        STARTED,
        DID_NOT_START
    }

    enum Directions {
        UP(0),
        RIGHT(3),
        LEFT(9),
        DOWN(6);

        int clockPos;

        Directions(int c) {
            clockPos = c;
        }
    }

    /**
     * Main Level constructor
     */
    public Level() {
        createLevel();
    }

    /**
     * This method initializes game level.
     */
    private void createLevel() {
        gotoStartPosition();

        System.out.println("Creating level...");

        board = new Board();

        janusz = new Janush();
        board.placeInside(janusz);

        beer = new Beer();
        board.placeInside(beer);

        status = Status.DID_NOT_START;

        System.out.println("Level created. \n");
    }

    /**
     * Starts the game.
     */
    public void play(Console console) {
        //System.out.println("\n. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ");
        //System.out.println("Janusz starts playing...");

        //go to where board should be printed on screen
        gotoBoardPosition();
        //draw board
        System.out.println(this);

        status = Status.STARTED;
        //System.out.println(this);

        startTime = System.currentTimeMillis(); // order current system time as start time

        //char array is needed to recognise arrow keys
        //arrow keys are not like regular characters (a, b, c...)
        //arrow keys are not one character but set of such
        //therefore the charArray - to put them together and recognise as arrow key
        String charArray = "";

        boolean exit = false;
        while (!exit) {
            //initial cursor position on screen - for typying
            gotoTypyingPosition();

            //read what user types - it waits for enter to be pressed
            String input = console.readLine();

            //read all chars from input one by one
            for (char c : input.toCharArray()) {
                if (c == 'a' || (charArray + c).equals(ARROW_LEFT)) {
                    moveJanuszLeft();
                    charArray = "";
                } else if (c == 'd' || (charArray + c).equals(ARROW_RIGHT)) {
                    moveJanuszRight();
                    charArray = "";
                } else if (c == 's' || (charArray + c).equals(ARROW_DOWN)) {
                    moveJanuszDown();
                    charArray = "";
                } else if (c == 'w' || (charArray + c).equals(ARROW_UP)) {
                    moveJanuszUp();
                    charArray = "";
                } else {
                    charArray += c;
                }

                //move cursor to board position - for drawing board
                gotoBoardPosition();
                //draw board
                System.out.print(this);

                if (isWon() || isLost()) {
                    exit = true;
                    break;
                }

                if (c == 'x')
                    exit = true;
            }
        }

        gotoTypyingPosition();
        System.out.print(String.format("%1$100s", " "));

        gotoBoardPosition();
        for (int i = 0; i < board.getHeight(); i++) {
            System.out.println(String.format("%1$" + board.getWidth() * 2 + "s", " "));
        }

        gotoLogPosition();
        System.out.println("Janusz is done playing (" + status + "). ");
    }

    private boolean isWon() {
        return status == Status.WOOOOOOOOOOOOOOOoooooooooooooN;
    }

    public boolean isLost() {
        return status == Status.LOST ||
                status == Status.LOST_BY_TIME;
    }

    public boolean isStarted() {
        return status == Status.STARTED;
    }

    private void moveJanuszLeft() {
        gotoLogPosition();
        janusz.moveLeft();
        updateStatus();
    }

    private void moveJanuszUp() {
        gotoLogPosition();
        janusz.moveUp();
        updateStatus();
    }

    private void moveJanuszRight() {
        gotoLogPosition();
        janusz.moveRight();
        updateStatus();
    }

    private void moveJanuszDown() {
        gotoLogPosition();
        janusz.moveDown();
        updateStatus();
    }

    private void updateStatus() {
        if (janusz.isOn(beer))
            status = Status.WOOOOOOOOOOOOOOOoooooooooooooN;
        else if (System.currentTimeMillis() - MAX_DURATION > startTime)
            status = Status.LOST_BY_TIME;
        else if (janusz.isOverboard(board))
            status = Status.LOST;
    }

    @Override
    public String toString() {
        return //"Level: " + status + ". \n" +
                // "Board: " + board + "\n" +
                board.drawTable(janusz, beer);

        //(timer <= 0 ? "because timer finished. The beer is warm now. " : "Time left was " + timer + ". The beer got spilled! No beer for Janusz this time. ");
    }

    private void gotoTypyingPosition() {
        gotoRowCol(TYPYING_ROW, TYPYING_COLUMN);
    }

    private void gotoLogPosition() {
        gotoRowCol(1, 70);
    }

    private void gotoBoardPosition() {
        gotoRowCol(TYPYING_ROW + 5, 1);
    }


    private void gotoStartPosition() {
        gotoRowCol(5, 1);
    }
}