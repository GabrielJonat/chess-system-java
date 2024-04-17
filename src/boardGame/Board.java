package boardGame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        if(rows < 1 || columns < 1)
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
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
        if(!positionExists(row,column))
            throw new BoardException("Position not on the board");
        return pieces[row][column];
    }

    public Piece piece(Position pos){
        if(!positionExists(pos.getRow(),pos.getColumn()))
            throw new BoardException("Position not on the board");
        return pieces[pos.getRow()][pos.getColumn()];
    }

    public void placePiece(Position pos, Piece piece){
        if(thereIsAPiece(pos))
            throw new BoardException("There is already a piece on position" + pos);
        pieces[pos.getRow()][pos.getColumn()] = piece;
        piece.position = pos;
    }

    public boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position pos){
        return positionExists(pos.getRow(), pos.getColumn());
    }

    public boolean thereIsAPiece(Position pos){
        if(!positionExists(pos.getRow(),pos.getColumn()))
            throw new BoardException("Position not on the board");
        return piece(pos) != null;
    }
}
