package com.qatrain.janushgame.model;

/**
 * Board resembles x / y board on which Janusz and Beer are positioned.
 */
public class Board {
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
     * Setting static values which represent MAX and MIN quantity for ROWS and COLUMS in Board
     */
    public static final int ROWS_MIN = 3;
    public static final int ROWS_MAX = 4; //in fact max value of ROWS is 16, but we have to set 13 to create random algorithm which can create correct board

    public static final int COLUMNS_MIN = 3;
    public static final int COLUMNS_MAX = 4; //the same situation as above

    /**
     * This method initializes board.
     */
    public Board() {
        createBoard();
    }

    /**
     * Setting algorithm which can create random Board using static values inside method
     */
    public void createBoard() {
        System.out.println("Creating board...");

        rows = 6;//(int) (Math.random() * ROWS_MAX) + ROWS_MIN; //Random function from Math class returns the value between 0 and 1, so we have to use algorithm to create Board with 3 <= size <= 16
        columns = 6;//(int) (Math.random() * COLUMNS_MAX) + COLUMNS_MIN; //The same as above
        board = new int[rows][columns];

        System.out.println("Board created " + this.toString() + ".");
    }

    /**
     * This method draws board with Janush and Beer on it
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
     * This method draws board without Janush and Beer on it
     */
    public String drawTable() {
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
     * Puts a {@link Positionable} object (beer or janush) inside this board
     * (modifies postionX and Y of the object so that its coordinates are
     * inside this board).
     *
     * @param object object to be put inside board (which position will be altered)
     * */
    public void placeInside(Positionable object) {
        object.putOnGrid(this);
    }

    /** Returns width of this board. */
    public int getWidth() {
        return columns;
    }

    /** Returns height of this board. */
    public int getHeight() {
        return rows;
    }

    public String toString() {
        return "(" + getWidth() + ", " + getHeight() + ")";
    }
}