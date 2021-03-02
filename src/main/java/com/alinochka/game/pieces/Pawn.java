package com.alinochka.game.pieces;

import com.alinochka.game.chess.Cell;
import com.alinochka.game.chess.Color;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn (int x, int y){
        this.x = x;
        this.y = y;
        name = "P";

    }

    public Pawn(){
        name = "P";
    }



//    public ArrayList<Cell> move(Cell cur_pos[][], int x, int y){
//
//       //белая пешка
//        possiblemoves.clear();
//       if(getColor()==Color.WHITE){
//           if(x==0){
//
//           }
//       }
//
//       //черная пешка
//        if(getColor()==Color.BLACK){
//
//        }
//
//       return null;
//    }



}
