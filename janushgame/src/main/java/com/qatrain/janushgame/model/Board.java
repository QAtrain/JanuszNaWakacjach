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
    public static final int ROWS_MIN = 13;
    public static final int ROWS_MAX = 17; //in fact max value of ROWS is 16, but we have to set 13 to create random algorithm which can create correct board

    public static final int COLUMNS_MIN = 13;
    public static final int COLUMNS_MAX = 17; //the same situation as above

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

        rows = (int) (Math.random() * (ROWS_MAX - ROWS_MIN)) + ROWS_MIN; //Random function from Math class returns the value between 0 and 1, so we have to use algorithm to create Board with 3 <= size <= 16
        columns = (int) (Math.random() * (COLUMNS_MAX - COLUMNS_MIN)) + COLUMNS_MIN; //The same as above
        board = new int[rows][columns];

        System.out.println("Board created " + this.toString() + ".");
    }

    /**
     * This method draws board with Janush and Beer on it
     * @param beer beer to be put on board
     * @param janusz janush to be put on board
     * @return string representation of the board
     */
    public String drawBoard(Janush janusz, Beer beer) {
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

        }

        return printout;
    }

    /**
     * This method draws board without Janush and Beer on it
     * @return string representation of board
     */
    public String drawBoard() {
        String printout = "";
        for (int row = 0; row < rows; ++row) {
            printout += drawRow(board[row]);
        }

        return printout;
    }

    /**
     * This method draws single row
     * @param row the row contents to draw
     * @return string representation of the row
     */
    private String drawRow(int[] row) {
        String printout = "";
        for (int column = 0; column < columns; ++column) {
            printout += printCell(row[column]); //print each of the cells
            printout += ("|"); //print vertical partition
        }
        printout += "\n";
        return printout;
    }

    /**
     * This method prints a cell depending on its value
     * @param cellContentAsInt integer content of a cell representing
     *                         either Janush, Beer or Janush on Beer
     * @return depending on contents of the cell:
     * J, B, X for Janush, Beer and Janush on Beer respectively
     */
    private String printCell(int cellContentAsInt) {
        switch (cellContentAsInt) {
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
     * Puts a {@link Positioned} object (beer or janush) inside this board
     * (modifies postionX and Y of the object so that its coordinates are
     * inside this board).
     *
     * @param object object to be put inside board (which position will be altered)
     */
    public void placeInside(Positioned object) {
        object.putOnGrid(this);
    }

    /**
     * Returns width of this board.
     * @return number of columns
     */
    public int getWidth() {
        return columns;
    }

    /**
     * Returns height of this board.
     * @return number of rows
     */
    public int getHeight() {
        return rows;
    }

    public String toString() {
        return "(" + getWidth() + ", " + getHeight() + ")";
    }
}