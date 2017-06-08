package com.qatrain.janushgame.model;

/**
 * This is one small game on one level. It contains grid, timer, janusz and beer.
 * <p>
 * Janusz needs to pick beer within timer frames to win the game. In case Janusz
 * does not pick beer within timer frames the beer is very warm - he looses the game.
 * <p>
 * Level object is one usage. Another game needs to be created to be played. (we could have restart of same game but we did not plan for it)
 */
public class Level {

    public void run() {
        while (lives > 0) {
            play();
            if (status == Status.LOST || status == Status.LOST_BY_TIME) {
                --lives;
            }
            if (lives == 0) {
                System.out.println("Lives left: " + lives);
                System.out.println("GAME OVER");
            }
        }
    }

    int lives = Janush.LIVES_DEFAULT;

    /**
     * Grid or grid for this game.
     */
    Grid grid;

    /**
     * Janusz standing on the grid.
     */
    Janush janusz;

    /**
     * Beer to be picked by Janusz.
     */
    Beer beer;


    /**
     * Did Janusz win (true) or loose (false)?
     */
    Status status = null;

    enum Status {
        WOOOOOOOOOOOOOOOoooooooooooooN,
        LOST,
        LOST_BY_TIME,
        IS_ON,
        DID_NOT_START
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

        grid = new Grid();

        janusz = new Janush();
        grid.placeInside(janusz);

        beer = new Beer();
        grid.placeInside(beer);

        status = Status.DID_NOT_START;

        System.out.println("Level created. \n");
        System.out.println(this.toString());
    }

    /**
     * Starts the game.
     */
    public void play() {
        long start = System.currentTimeMillis(); // order current system time as start time
        long end = start + 15000; // order end time as current system time + 10 seconds
        boolean timeEnd = (System.currentTimeMillis() == end); // boolean condition for loop statement

        status = Status.IS_ON;
        System.out.println(this);

        System.out.println("========================");
        System.out.println("Janusz starts playing...");
        System.out.println("Lives left: " + lives);

        while (System.currentTimeMillis() < end || status != Status.LOST || status != Status.LOST_BY_TIME || status != Status.WOOOOOOOOOOOOOOOoooooooooooooN) {

                moveJanuszUp();
                moveJanuszUp();

                moveJanuszLeft();
                moveJanuszLeft();

                moveJanuszUp();

                moveJanuszLeft();
                moveJanuszLeft();
                moveJanuszLeft();


                if (janusz.isOn(beer)) {
                    status = Status.WOOOOOOOOOOOOOOOoooooooooooooN;
                    System.out.println(this);
                    break;
                } else if (!janusz.isOn(beer) && timeEnd) {
                    status = Status.LOST_BY_TIME;
                    System.out.println(this);
                    break;
                } else {
                    status = Status.LOST;
                    System.out.println(this);
                    break;
                }
        }

        //TODO listen for keyboard clicks
        //TODO refresh GUI

        System.out.println("Janusz is done playing. ");
        System.out.println("========================");

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

    private void updateStatus() {
        if (janusz.isOn(beer))
            status = Status.WOOOOOOOOOOOOOOOoooooooooooooN;
    }

    @Override
    public String toString() {
        return "Level " + status + ". \n" +
                "Grid: \n" +
                grid.drawTable(janusz, beer);

        //(timer <= 0 ? "because timer finished. The beer is warm now. " : "Time left was " + timer + ". The beer got spilled! No beer for Janusz this time. ");
    }
}