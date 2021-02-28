package com.alinochka.game.chess;

public class Board {
    private final int board_size = 8;
    private final String horizont_simbol = "+___";
    private final String vertical_simbol = "|";

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
            for (int v = 0; v <= board_size; v++) {
                System.out.print(vertical_simbol + "   ");
            }
            System.out.print("\n");
            System.out.print("  ");
        }

}
