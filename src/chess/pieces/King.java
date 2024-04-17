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
}
