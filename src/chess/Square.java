package chess;


public class Square {
	
	private int xCoordinate = -1;
	
	private int yCoordinate = -1;
	
    public enum Color { BLACK, WHITE; }
    
    private Color color;
    
    private Piece piece = null;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	 
	public boolean hasPiece(){
		if (piece != null){
			return true;
		}
		return false;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPieceAt(Square square){
		return square.getPiece();
	}
	
}

