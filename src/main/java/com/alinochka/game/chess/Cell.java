package com.alinochka.game.chess;

import com.alinochka.game.pieces.Piece;

public class Cell {
    int x, y; //позиция
    //private boolean isAvailable;
    private Piece piece;


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
