package com.alinochka.game.chess;

public class Board {
    private Board[][] board = new Board[8][8];
    private final int board_size = 8;
    private final String horizont_simbol = "+___";
    private final String vertical_simbol = "|";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String pawn = ANSI_RED + "P" + ANSI_RESET;

    public void displayBoard() {

        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.print("  ");
        
        horizontalLine();


        for (int g = 1; g <= board_size; g++) {
            verticalLine(g);
            horizontalLine();
        }

    }

    public void horizontalLine(){
        for (int c = 0; c < board_size; c++) {
            System.out.print(horizont_simbol);
        }
        System.out.print("+\n");
    }

    public void verticalLine(int numLine){
        System.out.print(numLine + " ");
//        if(numLine >= 1 && numLine <= 2){
//
//        }


            for (int v = 0; v <board_size; v++) {
                System.out.print(vertical_simbol  + " " + pawn + " ");
            }
            System.out.print(vertical_simbol + "\n");
            System.out.print("  ");
        }

}
