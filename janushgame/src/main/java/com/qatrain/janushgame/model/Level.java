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
        System.out.println("Creating level...");

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
        System.out.println("\n. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ");
        System.out.println("Janusz starts playing...");

        status = Status.STARTED;
        System.out.println(this);

        startTime = System.currentTimeMillis(); // order current system time as start time

        int[] moves = {0, 9, 9, 0};
        int i = 0;

        while (true) {
            //random moves
            //int move = (int) (Math.random() * 4) * 3;

            //decided moves
            int move = moves[i % 4];

            if (Directions.UP.clockPos == move)
                moveJanuszUp();
            else if (Directions.LEFT.clockPos == move)
                moveJanuszLeft();
//            else if (Directions.RIGHT.clockPos == random)
//                moveJanuszRight();
//            else if (Directions.DOWN.clockPos == random)
//                moveJanuszDown();

            //group of moves
//            moveJanuszUp();
//            moveJanuszLeft();
//            moveJanuszLeft();
//            moveJanuszUp();

            if (isWon() || isLost())
                break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i++;
        }

        //TODO listen for keyboard clicks

        System.out.println("Janusz is done playing. ");
        System.out.println("==================================================================================================================\n");
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
        else if (janusz.isOverboard(board))
            status = Status.LOST;
    }

    @Override
    public String toString() {
        return "Level: " + status + ". \n" +
                "Board: " + board + "\n" +
                board.drawTable(janusz, beer);

        //(timer <= 0 ? "because timer finished. The beer is warm now. " : "Time left was " + timer + ". The beer got spilled! No beer for Janusz this time. ");
    }
}