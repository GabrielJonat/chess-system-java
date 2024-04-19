package boardGame;

public abstract class Piece {
    protected Board board;
    protected Position position;

    public Piece(Board board){
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position pos){
        return possibleMoves()[pos.getColumn()][pos.getRow()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++)
                if (mat[i][j])
                    return true;
        return false;
    }

}

