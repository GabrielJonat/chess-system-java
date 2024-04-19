package chess;

import boardGame.Board;
import boardGame.Piece;
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

    private void validateSourcePosition(Position pos){
        if(!board.thereIsAPiece(pos))
            throw new ChessException("There is no piece on source position");
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removepiece(source);
        Piece capturedPiece = board.removepiece(target);
        board.placePiece(target,p);
        return capturedPiece;
    }

    public ChessPiece performChessMovement(ChessPosition source, ChessPosition target){
        Position origin = ChessPosition.toPosition(source.getRow(), source.getColumn());
        Position destination = ChessPosition.toPosition(target.getRow(), target.getColumn());
        validateSourcePosition(origin);
        return  (ChessPiece) makeMove(origin, destination);

    }

    public void initialSetup(){

        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

}
