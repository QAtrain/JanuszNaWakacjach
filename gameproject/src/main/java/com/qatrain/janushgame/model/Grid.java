package com.qatrain.janushgame.model;

/**
 * Grid resembles x / y grid on which Janusz and Beer are positioned.
 */
public class Grid {
    public String drawTableResult;
    public int rows;
    public int columns;
    public int[][] board;

    /**
     * Static values for SWITCH case
     */
    public static final int EMPTY = 0;
    public static final int JANUSH = 1;
    public static final int BEER = 2;

    /**
     * Setting static values which represent MAX and MIN quantity for ROWS and COLUMS in Grid
     */
    public static final int ROWS_MIN = 3;
    public static final int ROWS_MAX = 13; //in fact max value of ROWS is 16, but we have to set 13 to create random algorithm which can create correct grid

    public static final int COLUMNS_MIN = 3;
    public static final int COLUMNS_MAX = 13; //the same situation as above

    /**
     * This method initializes grid.
     */
    public Grid() {
        createGrid();
    }

    /**
     * Setting algorithm which can create random Grid using static values inside constructor
     */
    public void createGrid() {
        System.out.println("Creating grid...");
        rows = (int) (Math.random() * ROWS_MAX) + ROWS_MIN; //Random function from Math class returns the value between 0 and 1, so we have to use algorithm to create Grid with 3 <= size <= 16
        columns = (int) (Math.random() * COLUMNS_MAX) + COLUMNS_MIN; //The same as above
        board = new int[rows][columns];
        String calculatedString = drawTable();
        //System.out.println(calculatedString);
        System.out.println("Grid created.");
    }

    /**
     * This method draws Table
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
        printout += "\n";
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
     * This method print a cell with a specified 'content' (for now - it's using only EMPTY case, )
     */
    private String printCell(int content) {
        switch (content) {
            case EMPTY:
                return " "; //for now it will always get this case and generate empty board
            case JANUSH:
                return " O ";
            case BEER:
                return " X ";
            default:
                return "_";
        }
    }
}