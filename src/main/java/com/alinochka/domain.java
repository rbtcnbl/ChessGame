package com.alinochka;

import com.alinochka.game.chess.Cell;
import com.alinochka.game.chess.Color;
import com.alinochka.game.pieces.Piece;

public class domain {
    public static interface Board {

        Cell getCell(int x, int y);

        void move(Piece piece, int x, int y);

    }

    public static class PieceRule implements Rule {

        private final static int ROW_FOR_LONG_STROKE_WHITE = 2;
        private final static int ROW_FOR_LONG_STROKE_BLACK = 7;

        @Override
        public Result move(Board board, int startX, int startY, int x, int y) {
            try {

            } catch (Throwable t) {
                return new Result(t);
            }
            Piece piece = board.getCell(startX, startY).getPiece(); // TODO потенциальный краш если нет фигуры!!!
            if (startX == x) {
                if (calculateDiff(piece, startY, y) == 1) {
                    Cell cell = board.getCell(x, y);
                    moveIfCellIsEmpty(board, piece, x, y);
                    return Result()
                } else if (calculateDiff(piece, startY, y) == 2) {
                    if (piece.getColor() == Color.WHITE) {
                        if (startY == ROW_FOR_LONG_STROKE_WHITE) {
                            for (int i = startY + 1; i <= y; i++) {
                                moveIfCellIsEmpty(board, piece, x, i);
                            }
                            return Result()
                        } else {
                            throw new IllegalArgumentException("не может пойти на две клетки");
                        }
                    } else {
                        if (startY == ROW_FOR_LONG_STROKE_BLACK) {
                            for (int i = startY - 1; i >= y; i++) {
                                moveIfCellIsEmpty(board, piece, x, i);
                            }
                            return Result()
                        } else {
                            throw new IllegalArgumentException("не может пойти на две клетки");
                        }
                    }
                } else {
                    return new Result(new IllegalArgumentException("нельзя передвинуть пешку"));
                }
            } else if (x - startX == Math.abs(1) && calculateDiff(piece, startY, y) == 1) {
                Cell cell = board.getCell(x, y);
                if (cell.getPiece() != null && cell.getPiece().getColor() != piece.getColor()) {
                    board.move(piece, x, y);
                    return Result(cell.getPiece())
                } else {
                    return new Result(new IllegalArgumentException("не может пойти на клетку"));
                }
            } else {
                return new Result(new IllegalArgumentException("не может пойти на клетку"));
            }
        }

        public int calculateDiff(Piece piece, int start, int end) {
            return piece.getColor() == Color.WHITE ? end - start : start - end;
        }

        private void moveIfCellIsEmpty(Board board, Piece piece, int x, int y) {
            Cell cell = board.getCell(x, y);
            if (cell.getPiece() != null) {
                board.move(piece, x, y);
            } else {
                throw new IllegalArgumentException("на клетке другая фигура");
            }
        }
    }

    public static class Result<S> {

        private Status status;
        private S state;
        private Throwable error;

        public Result(boolean gameOver, S state) {
            status = gameOver ? Status.GAME_OVER : Status.SUCCESS;
            this.state = state;
        }

        public Result(Throwable error) {
            status = Status.ERROR;
            this.error = error;
        }

        public Status getStatus() {
            return status;
        }

        public S getState() {
            return state;
        }

        public Throwable getError() {
            return error;
        }
    }

    public static interface Rule {

        boolean move(com.alinochka.game.chess.Board board, int startX, int startY, int x, int y);
    }

    public enum Status {
        SUCCESS, ERROR, GAME_OVER;
    }
}
