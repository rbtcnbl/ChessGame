package com.alinochka.game.pieces;

import com.alinochka.game.chess.Cell;
import com.alinochka.game.chess.Color;

import java.util.ArrayList;

public abstract class Piece {

    private String name; //название фигуры
    private Color color; //цвет фигуры
    protected ArrayList<Cell> possiblemoves = new ArrayList<Cell>();

//get/set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public abstract ArrayList<Cell> move(Cell pos[][], int x, int y);
}
