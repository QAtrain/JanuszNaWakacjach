package com.qatrain.janushgame.model;

/**
 * This is one small game on one level. It contains board, timer, janusz and beer.
 * <p>
 * Janusz needs to pick beer within timer frames to win the game. In case Janusz
 * does not pick beer within timer frames the beer is very warm - he looses the game.
 * <p>
 * Level object is one usage. Another game needs to be created to be played. (we could have restart of same game but we did not plan for it)
 */
public class Level {

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

    private static final long MAX_DURATION = 5000;

    long startTime;

    /**
     * Did Janusz win (true) or loose (false)?
     */
    public Status status = null;

    public enum Status {
        WOOOOOOOOOOOOOOOoooooooooooooN,
        LOST,
        LOST_BY_TIME,
        IS_ON,
        DID_NOT_START
    }

    enum Directions {
        UP(0),
        RIGHT(3),
        LEFT(6),
        DOWN(9);

        int clockPos;

        Directions(int c) {
            clockPos = c;
        }
    }

    /**
     * Main Level constructor
     */
    public Level() {
        createGame();
    }

    /**
     * This method initializes game.
     */
    private void createGame() {
        System.out.println("Creating game...");

        board = new Board();

        janusz = new Janush();
        board.placeInside(janusz);

        beer = new Beer();
        board.placeInside(beer);

        status = Status.DID_NOT_START;

        System.out.println("Level created. \n");
        System.out.println(this);
    }

    /**
     * Starts the game.
     */
    public void play() {
        System.out.println("==================================================================================================================");
        System.out.println("Janusz starts playing...");

        status = Status.IS_ON;
        System.out.println(this);

        startTime = System.currentTimeMillis(); // order current system time as start time

        while (true) {
            int random = (int) (Math.random() * 4) * 3;

            if (Directions.UP.clockPos == random)
                moveJanuszUp();
            else if (Directions.LEFT.clockPos == random)
                moveJanuszLeft();
            else if (Directions.RIGHT.clockPos == random)
                moveJanuszRight();
            else if (Directions.DOWN.clockPos == random)
                moveJanuszDown();

            updateStatus();

            if (isWon() || isLost())
                break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //TODO listen for keyboard clicks
        //TODO refresh GUI

        System.out.println("Janusz is done playing. ");
        System.out.println("==================================================================================================================");
    }

    private boolean isWon() {
        return status == Status.WOOOOOOOOOOOOOOOoooooooooooooN;
    }

    public boolean isLost() {
        return status == Status.LOST_BY_TIME ||
                status == Status.LOST;
    }

    private void moveJanuszLeft() {
        janusz.moveLeft();
        updateStatus();
        System.out.println(this);
    }

    private void moveJanuszUp() {
        janusz.moveUp();
        updateStatus();
        System.out.println(this);
    }

    private void moveJanuszRight() {
        janusz.moveRight();
        updateStatus();
        System.out.println(this);
    }

    private void moveJanuszDown() {
        janusz.moveDown();
        updateStatus();
        System.out.println(this);
    }

    private void updateStatus() {
        if (janusz.isOn(beer))
            status = Status.WOOOOOOOOOOOOOOOoooooooooooooN;
        else if (System.currentTimeMillis() - MAX_DURATION > startTime)
            status = Status.LOST_BY_TIME;
    }

    @Override
    public String toString() {
        return "Level " + status + ". \n" +
                "Board: " + board + "\n" +
                board.drawTable(janusz, beer);

        //(timer <= 0 ? "because timer finished. The beer is warm now. " : "Time left was " + timer + ". The beer got spilled! No beer for Janusz this time. ");
    }
}