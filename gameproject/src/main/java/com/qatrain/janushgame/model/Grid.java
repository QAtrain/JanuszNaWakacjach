package com.qatrain.janushgame.model;

/**
 * Grid resembles x / y grid on which Janusz and Beer are positioned.
 */
public class Grid {
    private int rows;
    private int columns;

    public int[][] board;

    /**
     * Static values for SWITCH case
     */
    static final int EMPTY = 0;
    static final int JANUSH = 1;
    static final int BEER = 2;
    static final int BOTH = 3;

    /**
     * Setting static values which represent MAX and MIN quantity for ROWS and COLUMS in Grid
     */
    public static final int ROWS_MIN = 2;
    public static final int ROWS_MAX = 3; //in fact max value of ROWS is 16, but we have to set 13 to create random algorithm which can create correct grid

    public static final int COLUMNS_MIN = 2;
    public static final int COLUMNS_MAX = 3; //the same situation as above

    /**
     * This method initializes grid.
     */
    public Grid() {
        createGrid();
    }

    /**
     * Setting algorithm which can create random Grid using static values inside method
     */
    public void createGrid() {
        System.out.println("Creating grid...");

        rows = (int) (Math.random() * ROWS_MAX) + ROWS_MIN; //Random function from Math class returns the value between 0 and 1, so we have to use algorithm to create Grid with 3 <= size <= 16
        columns = (int) (Math.random() * COLUMNS_MAX) + COLUMNS_MIN; //The same as above
        board = new int[rows][columns];

        System.out.println("Grid created.");
    }

    /**
     * This method draws Table
     */
    public String drawTable(Janush janusz, Beer beer) {
        int jx = janusz.getPositionX();
        int jy = janusz.getPositionY();
        int bx = beer.getPositionX();
        int by = beer.getPositionY();

        if (janusz.isOn(beer))
            board[jy][jx] = BOTH;
        else {
            if (jx < getWidth() && jx >= 0 &&
                    jy < getHeight() && jy >= 0)
                board[jy][jx] = JANUSH;

            if (bx < getWidth() && bx >= 0 &&
                    by < getHeight() && by >= 0)
                board[by][bx] = BEER;
        }

        String printout = "";
        for (int row = 0; row < rows; ++row) {
            printout += drawRow(board[row]);
            if (row != rows - 1) {
                for (int columns = 0; columns < this.columns; ++columns) {
                    printout += "--"; //print horizontal partition
                }
                printout += "\n";
            }
        }

        return printout;
    }

    /**
     * This method draws single row
     */
    private String drawRow(int[] ints) {
        String printout = "";
        for (int column = 0; column < columns; ++column) {
            printout += printCell(ints[column]); //print each of the cells
            printout += ("|"); //print vertical partition
        }
        printout += "\n";
        return printout;
    }

    /**
     * This method prints a cell with a specified 'content' (for now - it's using only EMPTY case, )
     */
    private String printCell(int content) {
        switch (content) {
            case EMPTY:
                return " "; //for now it will always get this case and generate empty board
            case JANUSH:
                return "J";
            case BEER:
                return "B";
            case BOTH:
                return "X";
            default:
                return "_";
        }
    }

    /**
     * Puts a {@link Positionable} object (beer or janush) inside this grid
     * (modifies postionX and Y of the object so that its coordinates are
     * inside this grid).
     *
     * @param object object to be put inside grid (which position will be altered)
     * */
    public void placeInside(Positionable object) {
        object.putOnGrid(this);
    }

    /** Returns width of this grid. */
    public int getWidth() {
        return columns;
    }

    /** Returns height of this grid. */
    public int getHeight() {
        return rows;
    }
}