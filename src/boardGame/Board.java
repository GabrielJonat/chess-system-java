package boardGame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }


    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    public Piece piece(Position pos){
        return pieces[pos.getRow()][pos.getColumn()];
    }

    public void placePiece(Position pos, Piece piece){
        pieces[pos.getRow()][pos.getColumn()] = piece;
        piece.position = pos;
    }
}
