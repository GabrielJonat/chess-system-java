package chess.pieces;

import chess.ChessPiece;
import boardGame.Board;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    public boolean[][] possibleMoves(){
        boolean[][] mat =  new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }

}
