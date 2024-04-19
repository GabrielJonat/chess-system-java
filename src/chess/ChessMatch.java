package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.Rook;
import chess.pieces.King;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows(); i ++)
            for(int j = 0; j < board.getColumns(); j ++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(ChessPosition.toPosition(row,column),piece);
    }

    public void initialSetup(){
        board.placePiece(ChessPosition.toPosition(6,'b'), new Rook(board,Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e',1, new King(board, Color.WHITE));
    }

}
