package com.alinochka.game.chess;

import com.alinochka.game.pieces.*;

public class Board {
    private Piece[][] board = new Piece[8][8];
    private final int board_size = 8;
    private final String horizont_simbol = "+___";
    private final String vertical_simbol = "|";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    //ANSI_RED + "P" + ANSI_RESET

    public void setupDefault() {

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board[r][c] = null;
            }
        }

        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(i, 1);
            board[i][6] = new Pawn(i, 6);
        }

    }

    public void displayBoard() {

        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.print("  ");

        horizontalLine();


//        for (int g = 1; g <= board_size; g++) {
//            verticalLine(g);
//            horizontalLine();
//        }

        firstVerticalLine(1);
        horizontalLine();
        verticalLine(2, new Pawn().getName());
        for (int i = 3; i < 7; i++) {
            horizontalLine();
            verticalLine(i, " ");
        }
        horizontalLine();
        verticalLine(7, new Pawn().getName());
        horizontalLine();
        firstVerticalLine(8);
        horizontalLine();


    }

    public void horizontalLine() {
        for (int c = 0; c < board_size; c++) {
            System.out.print(horizont_simbol);
        }
        System.out.print("+\n");
    }

    public void verticalLine(int numLine, String piece) {
        System.out.print(numLine + " ");

        String color = "";

        if (numLine == 2) {
            color = ANSI_BLUE;
        } else if (numLine == 7) {
            color = ANSI_RED;
        }

        for (int v = 0; v < board_size; v++) {
            System.out.print(vertical_simbol + " " + color + piece + ANSI_RESET + " ");
        }
        System.out.print(vertical_simbol + "\n");
        System.out.print("  ");
    }

    //R N B Q K B N R
    public void firstVerticalLine(int numLine) {
        System.out.print(numLine + " ");
        String color = null;

        if (numLine == 1) {
            color = ANSI_BLUE;
        } else if (numLine == 8) {
            color = ANSI_RED;
        }
        System.out.print(vertical_simbol + " " + color + new Rook().getName() + ANSI_RESET + " " +
                vertical_simbol + " " + color + new Knight().getName() + ANSI_RESET + " " +
                vertical_simbol + " " + color + new Bishop().getName() + ANSI_RESET + " " +
                vertical_simbol + " " + color + new Queen().getName() + ANSI_RESET + " " +
                vertical_simbol + " " + color + new King().getName() + ANSI_RESET + " " +
                vertical_simbol + " " + color + new Bishop().getName() + ANSI_RESET + " " +
                vertical_simbol + " " + color + new Knight().getName() + ANSI_RESET + " " +
                vertical_simbol + " " + color + new Rook().getName() + ANSI_RESET + " ");


        System.out.print(vertical_simbol + "\n");
        System.out.print("  ");
    }


}
