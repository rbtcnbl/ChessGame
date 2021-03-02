package com.alinochka.game.pieces;

public class King extends Piece{

    public King (int x, int y){
        this.x = x;
        this.y = y;
        name = "K";

    }

    public King(){
        name = "K";
    }

    //шах и мат
    private boolean isindanger(){
        return false;
    }
}
