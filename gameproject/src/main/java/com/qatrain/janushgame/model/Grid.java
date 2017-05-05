package com.qatrain.janushgame.model;

import java.util.ArrayList;

/**
 * Grid resembles x / y grid on which Janusz and Beer are positioned.
 */
public class Grid {
    /**
     * Setting random rows and columns value (3 < ROWS, COLUMNS < 16)
     */
    public static final int ROWS = (int) (Math.random() * 13) + 3;
    public static final int COLUMNS = (int) (Math.random() * 13) + 3;

    /**
     * Static values for SWITCH case
     */
    public static final int EMPTY = 0;
    public static final int JANUSZ = 1;
    public static final int BEER = 2;

    public static final int[][] board = new int[ROWS][COLUMNS];

    /**
     * This method initializes grid.
     */
    public static void createGrid() {
        System.out.println("Creating grid...");

        System.out.println();
        for (int row = 0; row < ROWS; ++row) {
            drawRow(board[row]);
            if (row != ROWS - 1) {
                for (int columns = 0; columns < COLUMNS; ++columns) {
                    System.out.print("--"); //print horizontal partition //
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Grid created.");
    }

    /**
     * This method draws single row
     */
    private static void drawRow(int[] ints) {
        for (int column = 0; column < COLUMNS; ++column) {
            printCell(ints[column]); //print each of the cells
            System.out.print("|"); //print vertical partition
        }
        System.out.println();
    }

    /**
     * This method print a cell with a specified 'content' (not finished yet, for future purposes - DO NOT CHECK!)
     */
    public static void printCell(int content) {
        switch (content) {
            case EMPTY:
                System.out.print(" "); //for now it will always get this case and generate empty board
                break;
            case JANUSZ:
                System.out.print(" O ");
                break;
            case BEER:
                System.out.print(" X ");
                break;
            default:
                System.out.println("_");
                break;
        }
    }
}